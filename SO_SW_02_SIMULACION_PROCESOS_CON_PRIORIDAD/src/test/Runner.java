package test;

import logic.ProcessManager;
import controller.Controller;

/**
 * Clase que ejecuta el programa
 * 
 * @author Cesar Cardozo y Gabriel Amaya
 */
public class Runner {

    public static void main(String[] args) {

        ProcessManager pm = new ProcessManager();
//
//        pm.addProcess(ProcessManager.createProcess("1", 30, false));
//        pm.addProcess(ProcessManager.createProcess("2", 15, true));
//        pm.addProcess(ProcessManager.createProcess("3", 10, true));
//        pm.addProcess(ProcessManager.createProcess("4", 40, false));
//        pm.addProcess(ProcessManager.createProcess("5", 30, false));
//        pm.addProcess(ProcessManager.createProcess("6", 15, true));
//        pm.addProcess(ProcessManager.createProcess("7", 10, true));
//        pm.addProcess(ProcessManager.createProcess("8", 40, false));
//        pm.addProcess(ProcessManager.createProcess("9", 30, false));
//        pm.addProcess(ProcessManager.createProcess("10", 15, true));
//        pm.addProcess(ProcessManager.createProcess("11", 10, true));
//        pm.addProcess(ProcessManager.createProcess("12", 40, false));
//        pm.addProcess(ProcessManager.createProcess("13", 30, false));
//        pm.addProcess(ProcessManager.createProcess("14", 15, true));
//        pm.addProcess(ProcessManager.createProcess("15", 10, true));
//        pm.addProcess(ProcessManager.createProcess("16", 40, false));
        // pm.processProcesses();*/
        new Controller(pm);

    }

}
