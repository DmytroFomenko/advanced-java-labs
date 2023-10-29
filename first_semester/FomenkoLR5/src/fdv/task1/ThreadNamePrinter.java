package fdv.task1;


public class ThreadNamePrinter extends Thread {
    ThreadNamePrinter(String name){
        super(name);
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(333);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
    }
}
