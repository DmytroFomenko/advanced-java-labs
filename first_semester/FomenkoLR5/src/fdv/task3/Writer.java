package fdv.task3;


import java.util.ArrayList;
import java.util.Random;

public class Writer {
    private final String name;
    private Thread thread;
    private final StringBuffer message;
    private volatile boolean needToStopWriting;
    private boolean needToWaitReaders;
    private final int meanTimeToSleep = 800;
    private final int messageLength = 10;
    private int messageNumber;
    private int neededMessagesCount;

    private final ArrayList<Reader> readers;

    public Writer(String name) {
        this.name = name;
        message = new StringBuffer();
        readers = new ArrayList<>();
        needToStopWriting = false;
    }

    public Writer() {
        this("");
    }

    public void addReaders(int readersCount) {
        if (readersCount > 0) {
            for (int i = 1; i <= readersCount; i++) {
                String name = Integer.toString(readers.size() + 1);
                Reader reader = new Reader(name);
                readers.add(reader);
                reader.startReading(message);
            }
        }
    }

    public void deleteAllReaders() {
        if (readers.size() > 0) {
            readers.forEach(reader -> reader.stopReading());
            readers.clear();
        }
    }

    public void addReader() {
        this.addReaders(1);
    }

    private void makeRandomMessage(int length) {
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        message.setLength(0);
        message.append(++messageNumber).append(" - ");
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(52);
            message.append(symbols.charAt(number));
        }
    }

    private void sleepRandomTime() {
        try {
            Thread.sleep(RandomPoisson.getPoissonRandom(meanTimeToSleep));
        } catch (InterruptedException e) {
            System.out.printf("MessageWriter %s has been interrupted\n", name);
        }
    }

    private void sleepMs(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.printf("MessageWriter %s has been interrupted\n", name);
        }
    }

    public void startWriting(int neededMessagesCount) {
        Runnable writeTask = () -> {
            messageNumber = 0;
            while (!needToStopWriting && ((neededMessagesCount <= 0) || (messageNumber < this.neededMessagesCount))) {
                sleepRandomTime();
                synchronized (message) {
                    makeRandomMessage(messageLength);
                    System.out.printf("MessageWriter %s send message %s: %s\n", name, messageNumber, message);
                }

                needToWaitReaders = true;
                while (!needToStopWriting && needToWaitReaders) {
                    needToWaitReaders = false;
                    readers.forEach(reader -> needToWaitReaders = needToWaitReaders || (reader.getLastReadMessage().compareTo(message) != 0));
                    if (needToWaitReaders) {
                        sleepMs(100);
                    } else {
                        System.out.printf("MessageWriter %s: message %s has been read by all MessageReaders\n\n", name, messageNumber);
                    }
                }
            }
            deleteAllReaders();
            //System.out.printf("MessageWriter %s stopped.\n", name);
        };

        if (thread == null) {
            thread = new Thread(writeTask);
        } else {
            stopWriting();
        }

        this.neededMessagesCount = neededMessagesCount;

        thread.start();
        //System.out.printf("MessageWriter %s started.\n", name);
    }

    public void stopWriting() {
        if ((thread != null) && (thread.isAlive())) {
            needToStopWriting = true;
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            needToStopWriting = false;

        }
    }
}
