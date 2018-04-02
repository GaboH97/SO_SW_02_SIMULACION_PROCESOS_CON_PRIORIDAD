package logic;

import java.util.Comparator;

/**
 *
 * @author Cesar Cardozo
 */
public class Process implements Comparable<Process> {

    private String name;
    private double executionTime;
    private int priority;
    private int oldPriority;
    private boolean islock;
    private boolean doesComunicate;
    private boolean destruct;

    public Process(String name, double executionTime, int priority, boolean islock, boolean doesComunicate, boolean destruct) {
        this.name = name;
        this.executionTime = executionTime;
        this.priority = priority;
        this.oldPriority = this.priority;
        this.islock = islock;
        this.doesComunicate = doesComunicate;
        this.destruct = destruct;
    }

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

    public void setOldPriority(int oldPriority) {
        this.oldPriority = oldPriority;
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

    @Override
    public int compareTo(Process o) {
        if (this.getPriority() >= o.getPriority()) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Process{" + "name=" + name + ", executionTime=" + executionTime + ", priority=" + priority + ", islock=" + islock + ", doesComunicate=" + doesComunicate + ", destruct=" + destruct + '\n';
    }
}