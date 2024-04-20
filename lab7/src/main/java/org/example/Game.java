package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag;
    private final List<Player> players = new ArrayList<>();
    private final int n;
    private final Timekeeper timekeeper;
    private int currentPlayerIndex = 0;

    public Game(int numPlayers, int numTiles, int timeLimit) {
        bag = new Bag(numTiles);
        n = numPlayers;
        timekeeper = new Timekeeper(timeLimit);
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        timekeeper.start();
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public Bag getBag() {
        return bag;
    }

    public int getN() {
        return n;
    }
    public boolean isPlayerTurn(Player player) {
        synchronized (this) {
            return players.indexOf(player) == currentPlayerIndex;
        }
    }

    public void nextPlayerTurn() {
        synchronized (this) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    public void endGame() {
        timekeeper.interrupt();
        int maxSequenceLength = 0;
        Player winner = null;
        for (Player player : players) {
            int playerMaxSequenceLength = player.getMaxSequenceLength();
            if (playerMaxSequenceLength >= n) {
                winner = player;
                break;
            }
        }
        if (winner != null) {
            System.out.println("Game Over! Winner: " + winner.getName());
        } else {
            System.out.println("Game Over! No winner.");
        }
        System.exit(0);
    }

    public static void main(String args[]) {
        int numPlayers = 3;
        int numTiles = 10;
        int timeLimit = 500;
        Game game = new Game(numPlayers, numTiles, timeLimit);
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }
}
