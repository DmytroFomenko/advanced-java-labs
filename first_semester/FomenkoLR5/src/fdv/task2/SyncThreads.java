package fdv.task2;


public class SyncThreads {
    private int counter;
    private int counter2;
    private final int numThreads;
    private final int iterations;
    private final int timeToSleep;
    private final Thread[] threads;
    private final Object lockObject;

    public SyncThreads(int n, int k, int t) {
        numThreads = n;
        iterations = k;
        timeToSleep = t;
        lockObject = new Object();
        threads = new Thread[numThreads];
    }

    public void joinAllThreads() {
        if (threads != null) {
            for (int i = 0; i < numThreads; i++) {
                if (threads[i] != null) {
                    try {
                        threads[i].join();
                    } catch (InterruptedException e) {
                        System.out.printf("Thread %s has been interrupted", threads[i].getName());
                    }
                }
            }
        }
    }

    public void test() {
        Runnable work = () -> {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i < iterations; i++) {
                System.out.printf("%s: %s %s\n", threadName, counter, counter2);
                counter++;
                try {
                    Thread.sleep(timeToSleep);
                } catch (InterruptedException e) {
                    System.out.printf("Thread %s has been interrupted\n", threadName);
                }
                counter2++;
            }
        };

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(work, "T" + (i + 1));
            threads[i].start();
        }
    }

    public void testSync() {
        Runnable workSynced = () -> {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i < iterations; i++) {
                synchronized (lockObject) {
                    System.out.printf("%s: %s %s\n", threadName, counter, counter2);
                    counter++;
                    try {
                        Thread.sleep(timeToSleep);
                    } catch (InterruptedException e) {
                        System.out.printf("Thread %s has been interrupted\n", threadName);
                    }
                    counter2++;
                }
            }
        };

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(workSynced, "T" + (i + 1));
            threads[i].start();
        }
    }

    public void reset() {
        joinAllThreads();
        counter = 0;
        counter2 = 0;
    }


    public static void main(String[] args) {
        SyncThreads p = new SyncThreads(3, 5, 100);

        System.out.printf("\nStart asynchronized:\n");
        p.test();
        p.reset();
        System.out.printf("\nStart synchronized:\n");
        p.testSync();
    }
}
