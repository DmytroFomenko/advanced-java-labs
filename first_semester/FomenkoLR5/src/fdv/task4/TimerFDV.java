package fdv.task4;



public class TimerFDV {

    public static int seconds = 0;
    public static int periodMs = 200;
    private Thread thread;
    private volatile boolean isPaused = false;
    public static volatile boolean isStopped = false;
    private final Object lockObject = new Object();


    public static String periodsToTime(int periods) {
        StringBuilder sb = new StringBuilder();
        int sec = periods * periodMs / 1000;

        if (sec < 10) {
            sb.append("0:0").append(sec);
        } else if (sec >= 10 && sec < 60) {
            sb.append("0:").append(sec);
        } else if (sec > 60) {
            sb.append(sec / 60).append(":").append(sec % 60);
        }
        return sb.toString();
    }

    private void sleepMs(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.printf("Thread has been interrupted\n");
        }
    }

    public void reset() {
        seconds = 0;
    }

    public void pause() {
        isPaused = true;
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        isStopped = true;
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        isPaused = false;
        isStopped = false;

        Runnable startTask = () -> {
            synchronized (lockObject) {
                while (!isPaused && !isStopped) {
                    sleepMs(periodMs - 1);
                    seconds++;
                }
            }
        };

        thread = new Thread(startTask);
        thread.start();
    }

}
