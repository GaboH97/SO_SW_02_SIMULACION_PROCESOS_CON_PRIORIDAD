package logic;

/**
 * 
 * @author Cesar Cardozo & Gabriel Amaya
 */
public class Process implements Comparable<Process> {

    
    //-------------------- Atributos -------------------------

    private String name;//nombre del proceso
    private double executionTime;//tiempo de ejecucion restante del proceso.
    private double oldexecutionTime;//tiempo de ejecucion inicial del proceso
    private int priority;//prioridad final despues de los cambios que puedan ocurrir
    private int oldPriority;//prioridad inicial de un proceso
    private boolean islock;//bloqueo de un proces
    private boolean doesComunicate;//comunicacion de un proceso
    private boolean destruct;//destruccion de un proceso

    //------------------- Constructores ----------------------
    
    /**
     * 
     * @param name nombre del proceso
     * @param executionTime tiempo de ejcucion del proceso
     * @param priority prioridad del proceso
     * @param islock bloqueo de un proceso
     * @param doesComunicate comunicacion de un proceso
     * @param destruct destruccion de un proceso
     */
    public Process(String name, double executionTime, int priority, boolean islock, boolean doesComunicate, boolean destruct) {
        this.name = name;
        this.executionTime = executionTime;
        this.oldexecutionTime = this.executionTime;
        this.priority = priority;
        this.oldPriority = this.priority;
        this.islock = islock;
        this.doesComunicate = doesComunicate;
        this.destruct = destruct;
    }

    //-----------------Getters & Setters----------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(double executionTime) {
        this.executionTime = executionTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getOldPriority() {
        return oldPriority;
    }
    
    public boolean isIsLock() {
        return islock;
    }

    public void setIslock(boolean islock) {
        this.islock = islock;
    }

    public boolean isDoesComunicate() {
        return doesComunicate;
    }

    public void setDoesComunicate(boolean doesComunicate) {
        this.doesComunicate = doesComunicate;
    }

    public boolean isDestruct() {
        return destruct;
    }

    public void setDestruct(boolean destruct) {
        this.destruct = destruct;
    }

    public double getOldexecutionTime() {
        return oldexecutionTime;
    }

    /**
     * Metodo que comparara procesos segun su prioridad
     * @param o proceso con el que se comparara
     * @return 1 o -1 dependiendo de cual es el menor de los 2
     */
    @Override
    public int compareTo(Process o) {
        if (this.getPriority() >= o.getPriority()) {
            return 1;
        }
        return -1;
    }

    //-------------------ToString-----------------------------------------------
    @Override
    public String toString() {
        return "Process{" + "name=" + name + ", executionTime=" + executionTime + ", priority=" + priority + ", islock=" + islock + ", doesComunicate=" + doesComunicate + ", destruct=" + destruct + '\n';
    }
}