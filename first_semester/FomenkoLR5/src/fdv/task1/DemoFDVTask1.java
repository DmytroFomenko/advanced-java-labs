package fdv.task1;


public class DemoFDVTask1 {
    public static void main(String[] args) {

        ThreadNamePrinter t1 = new ThreadNamePrinter("ThreadFDV");
        t1.start();
        // Causes the main thread to wait for the child to complete
        try{t1.join();} catch(InterruptedException e){}


        Thread t2 = new Thread(new RunnableNamePrinter(),"RunnableFDV");
        t2.start();
        try{t2.join();} catch(InterruptedException e){}

    }
}
