package fdv.task3;


public class Reader {
    private final String name;
    private Thread thread;
    private StringBuffer lastReadMessage;
    private volatile boolean needToStopReading;
    private final int meanTimeToSleep = 300;

    public Reader(String name) {
        this.name = name;
        lastReadMessage = new StringBuffer();
    }

    public Reader() {
        this("");
    }

    public StringBuffer getLastReadMessage() {
        return lastReadMessage;
    }

    private void sleepRandomTime() {
        try {
            Thread.sleep(RandomPoisson.getPoissonRandom(meanTimeToSleep));
        } catch (InterruptedException e) {
            System.out.printf("MessageReader %s has been interrupted\n", name);
        }
    }

    private void sleepMs(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.printf("MessageReader %s has been interrupted\n", name);
        }
    }

    public void startReading(StringBuffer message) {
        Runnable readTask = () -> {
            while (!needToStopReading) {
                sleepRandomTime();
                synchronized (message) {
                    if (message.compareTo(lastReadMessage) != 0) {
                        lastReadMessage.setLength(0);
                        lastReadMessage.append(message);
                        System.out.printf("MessageReader %s received message: %s\n", name, message);
                    }
                }
            }
            //System.out.printf("MessageReader %s stopped.\n", name);
        };

        if (thread == null) {
            thread = new Thread(readTask);
        } else {
            stopReading();
        }

        thread.start();
        //System.out.printf("MessageReader %s started.\n", name);
    }

    synchronized public void stopReading() {
        if ((thread != null) && (thread.isAlive())) {
            needToStopReading = true;
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            needToStopReading = false;
        }
    }
}
