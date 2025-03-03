package pcd.lab02.lost_updates.fixed;

public class TestSafeCounter {

    public static void main(String[] args) throws Exception {

        int nTimes = 10000;

        if (args.length > 0) {
            nTimes = Integer.parseInt(args[0]);
        }

        final SafeCounter counter = new SafeCounter(0);
        final SafeWorker worker1 = new SafeWorker("Worker-A", counter, nTimes);
        final SafeWorker worker2 = new SafeWorker("Worker-B", counter, nTimes);

        final Cron cron = new Cron();
        cron.start();

        worker1.start();
        worker2.start();

        worker1.join();
        worker2.join();

        cron.stop();

        System.out.println("Counter final value: " + counter.getValue() + " in " + cron.getTime()+"ms.");
    }
}
