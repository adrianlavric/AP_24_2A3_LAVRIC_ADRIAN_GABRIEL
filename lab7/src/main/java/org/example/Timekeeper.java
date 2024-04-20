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
        while(true) {
            long runningTime = System.currentTimeMillis() - startTime;
            long remainingTime = timeLimit * 1000 - runningTime;

            if (remainingTime <= 0) {
                System.out.println("Game ended, time limit exceeded.");
                System.exit(0);
            }

            System.out.println("Time passed: " + runningTime / 1000 + " seconds");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getElapsedTime() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return (int) (elapsedTime / 1000);
    }
}
