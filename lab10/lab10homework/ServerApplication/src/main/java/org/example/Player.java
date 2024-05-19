package org.example;

public class Player {
    private String name;
    private long timeLeft;

    public Player(String name, long timeLeft) {
        this.name = name;
        this.timeLeft = timeLeft;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public void reduceTime(long elapsedTime) {
        timeLeft -= elapsedTime;
    }

    public String getName() {
        return name;
    }
}