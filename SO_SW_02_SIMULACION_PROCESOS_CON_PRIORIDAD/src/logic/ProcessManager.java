package logic;

import java.util.ArrayList;

/**
 * Clase que representa el manejador de procesos. Se encarga de crear, agregar y
 * atender cada uno de los procesos de acuerdo a sus características. Su modo de
 * atención es FIFO (First Input, First Output), teniendo prelación sobre
 * aquellos procesos que no están bloqueados.
 *
 * @author Cesar Cardozo & Gabriel Amaya
 */
public class ProcessManager {

    //------------------------ Atributos -----------------------------
    /**
     * Variable estática que representa el quantum por defecto
     */
    public static final double DEFAULT_QUANTUM = 5;

    /**
     * Representa la lista de los procesos de entrada
     */
    private ArrayList<Process> inputProcessList;

    /**
     * Representa la lista de los procesos de salida
     */
    private ArrayList<Process> outputProcessList;

    /**
     * Representa la lista de los procesos listos
     */
    private ArrayList<Process> readyProcessList;

    /**
     * Representa la lista de los procesos en ejecución
     */
    private ArrayList<Process> executionProcessList;

    /**
     * Representa la lista de los procesos bloqueados
     */
    private ArrayList<Process> lockedProcessList;

    /**
     * Representa la lista de los procesos expirados
     */
    private ArrayList<Process> expiredProcessList;

    /**
     * Representa la lista de los procesos que han sido despertados
     */
    private ArrayList<Process> awakenProcessList;

    /**
     * Variable que representa el Quantum (modificable)
     */
    private double quantum;

    //------------------------ Constructores -----------------------------
    public ProcessManager() {
        this.quantum = DEFAULT_QUANTUM;
        this.inputProcessList = new ArrayList<>();
        this.outputProcessList = new ArrayList<>();
        this.readyProcessList = new ArrayList<>();
        this.executionProcessList = new ArrayList<>();
        this.lockedProcessList = new ArrayList<>();
        this.expiredProcessList = new ArrayList<>();
        this.awakenProcessList = new ArrayList<>();
    }

    //------------------------ Métodos -----------------------------
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
        //Busca en la lista de procesos de entrada si existe un proceso con el 
        //mismo nombre, si no, lo agrega a la lista de procesos de entrada, lista
        //procesos listos y hace la transisiónde despachado
        if (searchProcess(p.getName(), inputProcessList) == null) {
            inputProcessList.add(p);
            readyProcessList.add(p);
            doTransition(executionProcessList, p.getName(), readyProcessList);
            //dispatch(p.getName());
            if (p.getIslock()) {
                doTransition(lockedProcessList, p.getName(), executionProcessList);
                //lock(p.getName());
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param name El nombre el proceso
     * @param executionTime El tiempo de ejecución del proceso
     * @param islock Indica si está bloqueado
     * @return Una nueva instancia de la clase Proceso con los datos ingresados
     */
    public static Process createProcess(String name, double executionTime,
            boolean islock) {
        return new Process(name, executionTime, islock);
    }

    /**
     * Método que procesa los procesos
     */
    public void processProcesses() {
        processProcessesUnlocked();
        processProcesseslocked();
    }

    /**
     * Método que procesa los procesos desbloqueados
     */
    private void processProcessesUnlocked() {
        //
        while (inputProcessList.size() - lockedProcessList.size() != outputProcessList.size()) {
            //Recorre lista de procesos de entrada
            for (Process p : inputProcessList) {
                //Si el proceso no está bloqueado, pasa a mirar si su tiempo de
                //ejecución es mayor a cero, si es así, atiende el proceso por
                // el tiempo proporcionado por el procesador (quantum)
                if (!p.getIslock()) {
                    if (p.getExecutionTime() > 0) {
                        attendProcess(p);
                        //Revisa que si luego de atender el proceso ya no hay
                        //remanentes de tiempo, lo agrega a la lista de procesos
                        //de salida, de lo contrario, se agrega a la lista de
                        //procesos expirados, hace la transición de expiración
                        // y luego es despachado
                        if (p.getExecutionTime() <= 0) {
                            outputProcessList.add(p);
                        } else {
                            expiredProcessList.add(p);
                            doTransition(readyProcessList, p.getName(), executionProcessList);
                            //expire(p.getName());
                            doTransition(executionProcessList, p.getName(), readyProcessList);
                            //dispatch(p.getName());
                        }
                    }
                }
            }
        }
    }

    /**
     * Método que procesa los procesos bloqueados
     */
    private void processProcesseslocked() {
        //Condición de salida del bucle indica que todos los procesos en la lista 
        //de entrada deben estar en la lista de procesos de salida (no necesariamente)
        //en el mismo orden 
        while (inputProcessList.size() != outputProcessList.size()) {
            //Recorre la lista de procesos bloqueados, desbloquea dichos procesos
            //y los agrega a la lista de procesos despertados si aun no están
            //en dicha lista
            for (Process p : lockedProcessList) {
                p.setIslock(false);
                if (!awakenProcessList.contains(p)) {
                    awakenProcessList.add(p);
                }
                //Revisa si hay remanentes de tiempo de ejecución en el proceso
                //si es así,  hace la transición de despertar, atiende el proceso,
                //y luego hace la transición de despachar
                if (p.getExecutionTime() > 0) {
                    doTransition(readyProcessList, p.getName(),
                            lockedProcessList);
                    //awake(p.getName());
                    attendProcess(p);
                    //dispatch(p.getName());
                    doTransition(executionProcessList, p.getName(),
                            readyProcessList);
                    //Revisa que si luego de atender el proceso ya no hay
                    //remanentes de tiempo, lo agrega a la lista de procesos
                    //de salida, de lo contrario, se agrega a la lista de
                    //procesos expirados, hace la transición de expiración
                    // y luego es despachado
                    if (p.getExecutionTime() <= 0) {
                        outputProcessList.add(p);
                    } else {
                        expiredProcessList.add(p);
                    }
                }
            }
        }
    }

    /**
     *
     * @param p El proceso a atender
     * @return El proceso atendido
     */
    public Process attendProcess(Process p) {
        p.setExecutionTime(p.getExecutionTime() - quantum);
        return p;
    }

    /**
     *
     * @param originList Lista de origen
     * @param name Nombre del proceso
     * @param destinationList Lista de destino
     */
    public void doTransition(ArrayList originList, String name,
            ArrayList destinationList) {
        originList.add(searchProcess(name, destinationList));
    }

    /*public void dispatch(String name) {
        executionProcessList.add(searchProcess(name, readyProcessList));
    }

    public void expire(String name) {
        readyProcessList.add(searchProcess(name, executionProcessList));
    }

    public void lock(String name) {
        lockedProcessList.add(searchProcess(name, executionProcessList));
    }

    public void awake(String name) {
        readyProcessList.add(searchProcess(name, lockedProcessList));
    }*/
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

    //---------------- Getters & Setters -----------------------
    
    public ArrayList<Process> getInputProcessList() {
        return inputProcessList;
    }

    public ArrayList<Process> getOutputProcessList() {
        return outputProcessList;
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

    public ArrayList<Process> getExpiredProcessList() {
        return expiredProcessList;
    }

    public ArrayList<Process> getAwakenProcessList() {
        return awakenProcessList;
    }

    public void setQuantum(double quantum) {
        this.quantum = quantum;
    }

    //------------------- To String ------------------------------
    @Override
    public String toString() {
        return "ProcessManager{" + "\ninputProcessList=" + inputProcessList
                + "\noutputProcessList=" + outputProcessList
                + "\nreadyProcessList=" + readyProcessList
                + "\nexcecutionProcessList=" + executionProcessList
                + "\nlockedProcessList=" + lockedProcessList
                + "\nexpiredProcessList=" + expiredProcessList
                + "\nawakenProcessList=" + awakenProcessList + '}';
    }
}
