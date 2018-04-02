package logic;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Cesar Cardozo
 */
public class ProcessManager {

    public static final double DEFAULT_QUANTUM = 5;
    private ArrayList<Process> inputProcessList;
    private ArrayList<Process> inputSortedProcessList;
    private ArrayList<Process> readyProcessList;
    private ArrayList<Process> executionProcessList;
    private ArrayList<Process> lockedProcessList;
    private ArrayList<Process> destroyedProcessList;
    private ArrayList<Process> comunicatedProcessList;
    private ArrayList<Process> outputProcessList;
    private ArrayList<Process> expiredProcessList;
    private ArrayList<Process> awakenProcessList;
    private double quantum;

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
     * Agregar un nuevo proceso al manejador de procesos. En un principio, lo
     * agrega a la lista de procesos de entrada, luego a la lista de procesos
     * listos y por último lo despacha (lo que indica que también lo agrega a la
     * lista de procesos en ejecución). Adicionalmente revisa si el proceso está
     * bloqueado y si lo está, lo agrega a la lista de procesos bloqueados
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
     *
     */
    public void processProcesses() {
        sortProcessList();
        while (outputProcessList.size() != returnNumberOfUndestroyed(inputSortedProcessList)) {
            for (Process p : inputSortedProcessList) {//recorrer la lista de procesos
                if (!outputProcessList.contains(p) && !destroyedProcessList.contains(p)) {//si aun no ha salido el proceso continue
                    readyProcessList.add(p);//despachar
                    executionProcessList.add(p);//envielo a la lista de ejecucion
                    p.setExecutionTime(p.getExecutionTime() - quantum);//restarle un ciclo de procesador
                    if (p.isDestruct()) {
                        executionProcessList.remove(executionProcessList.size() - 1);
                        destroyedProcessList.add(p);
                    }
                    if (p.getExecutionTime() > 0) {//si ya termino
                        if (p.isIsLock()) {//si esta bloqueado
                            lockedProcessList.add(p);//envielo a la lista de bloqueos
                            awakenProcessList.add(p);//envielo a la lista de despertar
                            if (p.isDestruct()) {
                                executionProcessList.add(p);//envielo a la lista de ejecucion
                            }
                        } else {
                            expiredProcessList.add(p);//envielo a la lista de expirados
                        }
                        if (p.isDoesComunicate() && (!comunicatedProcessList.contains(p))) {
                            comunicatedProcessList.add(p);
                        }
                    } else {
                        if (!p.isDestruct()) {
                            outputProcessList.add(p);//enviarlo a la lista de salida
                        }
                    }
                }
            }
        }
    }

    private void sortProcessList() {
        for (Process process : inputProcessList) {
            inputSortedProcessList.add(process);
        }
        Collections.sort(inputSortedProcessList);
    }

    /**
     *
     * @param originList Lista de origen
     * @param name Nombre del proceso
     * @param destinationList Lista de destino
     */
    public void doTransition(ArrayList originList, String name, ArrayList destinationList) {
        originList.add(searchProcess(name, destinationList));
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
