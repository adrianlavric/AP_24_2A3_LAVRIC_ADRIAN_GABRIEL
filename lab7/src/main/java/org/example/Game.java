package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag;
    private final List<Player> players = new ArrayList<>();
    private final int n;

    public Game(int numPlayers, int numTiles) {
        bag = new Bag(numTiles);
        n = numPlayers;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
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

    public static void main(String args[]) {
        int numPlayers = 3;
        int numTiles = 10;
        Game game = new Game(numPlayers, numTiles);
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }
}
