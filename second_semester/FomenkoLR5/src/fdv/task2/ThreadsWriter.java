package fdv.task2;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsWriter {

    private final Thread[] threads;
    private final Object lockObject;

    public ThreadsWriter(Object lockObject, Thread[] threads) {
        this.threads = threads;
        this.lockObject = lockObject;
    }

    public void mkFile(String strPath) throws IOException {
        File f = new File(strPath);
        Files.deleteIfExists(Path.of(strPath));
        f.createNewFile();
    }

    public void fillFile(RandomAccessFile raf) throws InterruptedException, IOException {
        AtomicInteger num = new AtomicInteger();
        Runnable fillFile = () -> {
            try {
                synchronized (lockObject) {
                    raf.seek(num.get() * 20L + num.get());
                    String symb = String.valueOf(num.get());
                    for (int i = 0; i < 20; i++) {
                        Thread.sleep(2);
                        raf.write(symb.getBytes());
                    }
                    raf.write(System.getProperty("line.separator").getBytes());
                    num.getAndAdd(1);
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(fillFile);
            threads[i].start();
        }
        // Main thread wait all created thread
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public void writeSymbols(RandomAccessFile raf, int row, String s) throws IOException {
        long seek = (row - 1) * 20L + (row - 1);

        raf.seek(seek);
        for (int i = 0; i < 20; i++) {
            raf.write(s.getBytes());
        }
    }

    public List<String> readFromFile(String strPath) {
        try {
            Path path = Paths.get(strPath);
            return Files.lines(path, StandardCharsets.UTF_8).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printList(List<String> list) {
        list.forEach(System.out::println);
    }


}
