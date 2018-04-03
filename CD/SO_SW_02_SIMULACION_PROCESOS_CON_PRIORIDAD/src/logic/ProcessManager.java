package logic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que representa el manejador de procesos. Se encarga de crear, agregar y
 * atender cada uno de los procesos de acuerdo a sus características. Su modo de
 * atención es por prioridad, en caso de que varios procesos tengan la misma
 * prioridad se atenderan en orden FIFO (First Input, First Output)
 *
 * @author Cesar Cardozo & Gabriel Amaya
 */
public class ProcessManager {

    public static final double DEFAULT_QUANTUM = 5;//queantum que se tendra por default
    private ArrayList<Process> inputProcessList;//lista de procesos de entrada en orden de entrada
    private ArrayList<Process> inputSortedProcessList;//procesos de entrada ordenados por prioridad
    private ArrayList<Process> readyProcessList;//lista de procesos listos
    private ArrayList<Process> executionProcessList;//lista de procesos en ejecucion
    private ArrayList<Process> lockedProcessList;//lista de procesos bloqueados
    private ArrayList<Process> destroyedProcessList;//lista de procesos destruidos
    private ArrayList<Process> comunicatedProcessList;//lista de procesos que comunican
    private ArrayList<Process> outputProcessList;//lista de procesos de salida
    private ArrayList<Process> expiredProcessList;//lista de procesos expirados
    private ArrayList<Process> awakenProcessList;//lista de procesos despertados
    private double quantum;//queantum

    /**
     * Cmetodo constructor de la clase que gestiona los procesos
     */
    public ProcessManager() {
        this.quantum = DEFAULT_QUANTUM;
        this.inputProcessList = new ArrayList<>();
        this.inputSortedProcessList = new ArrayList<>();
        this.readyProcessList = new ArrayList<>();
        this.executionProcessList = new ArrayList<>();
        this.lockedProcessList = new ArrayList<>();
        this.destroyedProcessList = new ArrayList<>();
        this.comunicatedProcessList = new ArrayList<>();
        this.outputProcessList = new ArrayList<>();
        this.expiredProcessList = new ArrayList<>();
        this.awakenProcessList = new ArrayList<>();
    }

    /**
     * Agregar un nuevo proceso al manejador de procesos. en caso de que un pro-
     * ceso con el mismo nombre ya haya sido agregado el nuevo n o sera agregado
     *
     * @param p El proceso a ser agregado
     * @return true si el proceso fue agregado, de lo contrario, false
     */
    public boolean addProcess(Process p) {
        if (searchProcess(p.getName(), inputProcessList) == null) {
            inputProcessList.add(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que procesa los procesos
     */
    public void processProcesses() {
        sortProcessList();//ordena los procesos por prioridad y los almacena en otra lista
        while (outputProcessList.size() != returnNumberOfUndestroyed(inputSortedProcessList)) {//mientras la lista de salida aun no este completa continue
            for (Process p : inputSortedProcessList) {//recorrer la lista de procesos
                if (!outputProcessList.contains(p) && !destroyedProcessList.contains(p)) {//si aun no ha salido el proceso, y si no ha sido destruido
                    doTransition(readyProcessList, p.getName(), inputSortedProcessList);//despachar
                    doTransition(executionProcessList, p.getName(), readyProcessList);//envielo a la lista de ejecucion "ejecutar"
                    p.setExecutionTime(p.getExecutionTime() - quantum);//restarle un ciclo de procesador"ejecutarlo"
                    if (p.getExecutionTime() > 0) {//si ya termino
                        if (p.isIsLock()) {//si esta bloqueado
                            doTransition(lockedProcessList, p.getName(), executionProcessList);//envielo a la lista de bloqueos
                            doTransition(awakenProcessList, p.getName(), lockedProcessList);//envielo a la lista de despertar para su posterior ejecucionn
                            if (p.isDestruct()) {//si esta destruido
                                doTransition(executionProcessList, p.getName(), readyProcessList);//envielo a la lista de ejecucion puesto que no se destruye inmediatamente porque esta boqueado                       
                            }
                        } else {
                            doTransition(expiredProcessList, p.getName(), executionProcessList);//envielo a la lista de expirados
                        }
                        if (p.isDoesComunicate() && (!comunicatedProcessList.contains(p))) {//si se comunica, y si no esta contenido en la lista de comunicacion
                            doTransition(comunicatedProcessList, p.getName(), executionProcessList);//agregar a la lista de comunicados
                        }
                    } else {//si no ha terminado
                        if (!p.isDestruct()) {//si no es un proceso destruido
                            doTransition(outputProcessList, p.getName(), executionProcessList);//enviarlo a la lista de salida
                        }
                    }
                    if (p.isDestruct()) {//si esta destruido
                        doTransition(destroyedProcessList, p.getName(), executionProcessList);//enviarlo a la lista de destruidos
                        executionProcessList.remove(executionProcessList.size() - 1);//remuevalo de la tabla de ejecucion
                    }
                }
            }
        }
    }

    /**
     * metodo que copia los procesos de la lista de entrada a una nueva lista,
     * alli los organiza por prioridad.
     */
    private void sortProcessList() {
        for (Process process : inputProcessList) {
            inputSortedProcessList.add(process);
        }
        Collections.sort(inputSortedProcessList);
    }

    /**
     *
     * @param destinationList Lista de origen
     * @param name Nombre del proceso
     * @param originList Lista de destino
     */
    public void doTransition(ArrayList destinationList, String name, ArrayList originList) {
        destinationList.add(searchProcess(name, originList));
    }

    /**
     * Busca el proceso con el nombre especificado dentro de la lista
     * especifica- da
     *
     * @param name Nombre del proceso
     * @param list Lista en la cual debe buscar el proceso
     * @return El proceso con el nombre especificado, null si no lo encontró
     */
    private Process searchProcess(String name, ArrayList<Process> list) {
        for (Process process : list) {
            if (process.getName().equals(name)) {
                return process;
            }
        }
        return null;
    }

    /**
     *
     * @param name El nombre el proceso
     * @param executionTime El tiempo de ejecución del proceso
     * @param priority La prioridad que tiene el proceso
     * @param islock Indica si está bloqueado
     * @param doesComunicate Indica si el proceso se comunica con otro proceso
     * @param doesDestruct Indica si el proceso se debe destruir
     * @return Una nueva instancia de la clase Proceso con los datos ingresados
     */
    public static Process createProcess(String name, double executionTime, int priority, boolean islock, boolean doesComunicate, boolean doesDestruct) {
        return new Process(name, executionTime, priority, islock, doesComunicate, doesDestruct);
    }

    /**
     * Evalua una lista y retorna el numero de elementos que no tienen la
     * caracteristica de destruccion
     *
     * @param list lista que sera evaluada
     * @return
     */
    public int returnNumberOfUndestroyed(ArrayList<Process> list) {
        int counter = 0;
        for (Process process : list) {
            if (!process.isDestruct()) {
                counter++;
            }
        }
        return counter;
    }

    //----------------Getters & setters-----------------------------------------
    public ArrayList<Process> getInputProcessList() {
        return inputProcessList;
    }

    public ArrayList<Process> getInputSortedProcessList() {
        return inputSortedProcessList;
    }

    public ArrayList<Process> getReadyProcessList() {
        return readyProcessList;
    }

    public ArrayList<Process> getExecutionProcessList() {
        return executionProcessList;
    }

    public ArrayList<Process> getLockedProcessList() {
        return lockedProcessList;
    }

    public ArrayList<Process> getDestroyedProcessList() {
        return destroyedProcessList;
    }

    public ArrayList<Process> getCommunicatedProcessList() {
        return comunicatedProcessList;
    }

    public ArrayList<Process> getOutputProcessList() {
        return outputProcessList;
    }

    public ArrayList<Process> getExpiredProcessList() {
        return expiredProcessList;
    }

    public ArrayList<Process> getAwakenProcessList() {
        return awakenProcessList;
    }

    public double getQuantum() {
        return quantum;
    }

    public void setQuantum(double quantum) {
        this.quantum = quantum;
    }
}
