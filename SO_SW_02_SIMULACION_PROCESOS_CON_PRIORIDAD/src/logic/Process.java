package logic;

/**
 * 
 * @author Cesar Cardozo & Gabriel Amaya
 */
public class Process{
    
    //-------------------- Atributos -------------------------
    
    /**
    * Nombre del proceso, actúa como identificador
    */
    
    private String name;
    
    /**
    * Tiempo total que demora el proceso en ejecutarse
    */
    private double executionTime;
    
    /**
     * Bandera que indica si el proceso está bloqueado o no 
     */
    private boolean islock;
    
    //------------------- Constructores ----------------------
    
    /**
     * 
     * @param name El nombre el proceso
     * @param executionTime El tiempo de ejecución del proceso
     * @param islock Indica si está bloqueado
     */
    public Process(String name, double executionTime, boolean islock) {
        this.name = name;
        this.executionTime = executionTime;
        this.islock = islock;
    }

    //------------------- Getters & Setters --------------------------
    
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

    public boolean getIslock() {
        return islock;
    }

    public void setIslock(boolean islock) {
        this.islock = islock;
    }
    
    // ------------------------ To String --------------------------------
    
    @Override
    public String toString() {
        return "-P{" + "-N: " + name + ", -T: " + executionTime + ", -B: " + islock + "}\n";
    }
}