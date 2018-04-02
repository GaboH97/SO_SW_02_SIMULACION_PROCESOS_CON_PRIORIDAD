package test;

import controller.Controller;
import logic.ProcessManager;

/**
 *
 * @author Cesar Cardozo
 */
public class Runner {

    public static void main(String[] args) {
        ProcessManager pm = new ProcessManager();
        pm.addProcess(ProcessManager.createProcess("p10", 8, 3, false, false, true));
        pm.addProcess(ProcessManager.createProcess("p20", 9, 2, true, false, false));
        pm.addProcess(ProcessManager.createProcess("p30", 7, 6, false, false, false));
        pm.addProcess(ProcessManager.createProcess("p40", 5, 4, false, false, true));
        pm.addProcess(ProcessManager.createProcess("p50", 11, 7, false, true, false));
        pm.addProcess(ProcessManager.createProcess("p60", 13, 5, false, false, false));
        logic.Process p = ProcessManager.createProcess("p70", 18, 8, false, false, false);
        p.setPriority(1);
        pm.addProcess(p);
        pm.addProcess(ProcessManager.createProcess("p80", 14, 9, false, false, false));
        pm.addProcess(ProcessManager.createProcess("p90", 22, 10, true, false, true));
      
        System.out.println("INPUT");
        System.out.println(pm.getInputProcessList().toString());

        System.out.println("SORTED");
        System.out.println(pm.getInputSortedProcessList().toString());

        System.out.println("READY");
        System.out.println(pm.getReadyProcessList().toString());
        System.out.println("EXECUTION");

        System.out.println(pm.getExecutionProcessList().toString());
        System.out.println("LOCKED");

        System.out.println(pm.getLockedProcessList().toString());
        System.out.println("DESTROYED");

        System.out.println(pm.getDestroyedProcessList().toString());
        System.out.println("COMMUNICATED");

        System.out.println(pm.getCommunicatedProcessList().toString());
        System.out.println("OUTPUT");

        System.out.println(pm.getOutputProcessList().toString());
        Controller c = new Controller(pm);
        
    }
}
