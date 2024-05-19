package org.example;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private String gameId;
    private Board board;
    private Map<String, Player> players;
    private String currentPlayer;
    private long startTime;
    private static final long TIME_LIMIT = 300000;

    public Game(String gameId) {
        this.gameId = gameId;
        this.board = new Board();
        this.players = new HashMap<>();
        this.startTime = System.currentTimeMillis();
    }

    public synchronized String addPlayer(String playerName) {
        if (players.size() < 2) {
            players.put(playerName, new Player(playerName, TIME_LIMIT));
            if (players.size() == 1) {
                currentPlayer = playerName;
            }
            return playerName + " joined the game " + gameId;
        } else {
            return "Game is full.";
        }
    }

    public synchronized String submitMove(String playerName, String move) {
        if (!players.containsKey(playerName)) {
            return "Player not found in this game.";
        }
        if (!playerName.equals(currentPlayer)) {
            return "It's not your turn.";
        }

        Player player = players.get(playerName);
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;

        if (player.getTimeLeft() < elapsedTime) {
            return playerName + " ran out of time and loses the game.";
        }

        player.reduceTime(elapsedTime);
        startTime = currentTime;

        boolean hit = board.makeMove(move);
        String result = hit ? "Hit!" : "Miss!";
        board.printBoard();

        if (board.isGameOver()) {
            return playerName + " wins the game!";
        }

        switchPlayer();
        return result;
    }

    private void switchPlayer() {
        for (String playerName : players.keySet()) {
            if (!playerName.equals(currentPlayer)) {
                currentPlayer = playerName;
                break;
            }
        }
    }
}