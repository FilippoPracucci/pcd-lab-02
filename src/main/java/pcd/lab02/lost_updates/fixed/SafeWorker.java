package pcd.lab02.lost_updates.fixed;

public class SafeWorker extends Thread {

    private final SafeCounter counter;
    private int nTimes;

    public SafeWorker(final String name, final SafeCounter counter, final int nTimes) {
        super(name);
        this.counter = counter;
        this.nTimes = nTimes;
    }

    @Override
    public void run() {
        log("started");
        for (int i = 0; i < this.nTimes; i++) {
            /* To assign the responsibility to the active component (not very correct)
            synchronized(this.counter) {
                this.counter.inc();
            }
            */
            this.counter.inc();
        }
        log("completed");
    }

    private void log(final String message) {
        System.out.println("[ " + this.getName() + "] " + message);
    }
}
