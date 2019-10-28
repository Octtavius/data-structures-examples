package ie.home.threads;

/**
 * Threads that waste CPU cycles
 */

// a simple thread that wastes CPU cycles forever
class CPUWaster extends Thread {
    public void run() {
        while (true) {}
    }
}

public class ThreadProcessDemo {
    public static void main(String args[]) throws InterruptedException {

        // display current information about this process
        Runtime rt = Runtime.getRuntime();
        long usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024 ;
        // Java 9
//        System.out.format("  Process ID: %d\n", ProcessHandle.current().pid());
        
        System.out.format("  Process ID: %d\n", getPID());
        System.out.format("Thread Count: %d\n", Thread.activeCount());
        System.out.format("Memory Usage: %d KB\n", usedKB);

        // start 6 new threads
        System.out.println("\nStarting 6 CPUWaster threads...\n");
        for (int i=0; i<6; i++) {        	
        	new CPUWaster().start();
        }

        // display current information about this process
        usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024 ;
        System.out.format("  Process ID: %d\n", getPID());
        System.out.format("Thread Count: %d\n", Thread.activeCount());
        System.out.format("Memory Usage: %d KB\n", usedKB);
        

    }
    
    public static long getPID() {
        String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        if (processName != null && processName.length() > 0) {
            try {
                return Long.parseLong(processName.split("@")[0]);
            }
            catch (Exception e) {
                return 0;
            }
        }

        return 0;
    }
}