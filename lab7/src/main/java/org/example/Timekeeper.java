package org.example;

public class Timekeeper extends Thread {
    private final int timeLimit;
    private final long startTime;

    public Timekeeper(int timeLimit) {
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
        setDaemon(true);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeLimit * 1000);
            System.out.println("Game ended, time limit exceeded.");
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getElapsedTime() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return (int) (elapsedTime / 1000);
    }
}
