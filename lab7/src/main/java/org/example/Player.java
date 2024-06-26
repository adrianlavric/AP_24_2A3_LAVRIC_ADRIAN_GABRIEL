package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private List<Tile> tiles = new ArrayList<>();
    private int maxSequenceLength = 0;

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void run() {
        running = true;
        while (running) {
            synchronized (game) {
                while (!game.isPlayerTurn(this)) {
                    try {
                        game.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!game.getBag().isEmpty()) {
                    List<Tile> extractedTiles = game.getBag().extractTiles(1);
                    if (!extractedTiles.isEmpty()) {
                        Tile extractedTile = extractedTiles.get(0);
                        System.out.println(name + " extracted tile: (" + extractedTile.getNumber1() + "," + extractedTile.getNumber2() + ")");
                        tiles.addAll(extractedTiles);
                    }
                    List<List<Tile>> sequences = findSequences(tiles);
                    printSequences(sequences);
                    if (sequences.stream().anyMatch(seq -> seq.size() >= game.getN())) {
                        game.endGame();
                        break;
                    }
                } else {
                    game.endGame();
                    break;
                }
                game.nextPlayerTurn();
                game.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private List<List<Tile>> findSequences(List<Tile> tiles) {
        List<List<Tile>> sequences = new ArrayList<>();
        for (Tile tile : tiles) {
            List<Tile> sequence = new ArrayList<>();
            sequence.add(tile);
            Tile nextTile = tile;
            while (true) {
                nextTile = findNextTile(nextTile);
                if (nextTile != null && !sequence.contains(nextTile)) {
                    sequence.add(nextTile);
                    if (nextTile.getNumber2() == tile.getNumber1()) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (sequence.size() >= 3 && sequence.get(sequence.size() - 1).getNumber2() == tile.getNumber1()) {
                sequences.add(sequence);
            }
            if(sequence.size() > maxSequenceLength) {
                maxSequenceLength = sequence.size();
            }
        }
        return sequences;
    }

    public String getName() {
        return name;
    }

    private Tile findNextTile(Tile currentTile) {
        for (Tile tile : tiles) {
            if (tile.getNumber1() == currentTile.getNumber2()) {
                return tile;
            }
        }
        return null;
    }

    private void printSequences(List<List<Tile>> sequences) {
        if (!sequences.isEmpty()) {
            System.out.println(name + " found sequences:");
            for (List<Tile> sequence : sequences) {
                System.out.print("[");
                for (int i = 0; i < sequence.size(); i++) {
                    Tile tile = sequence.get(i);
                    System.out.print("(" + tile.getNumber1() + "," + tile.getNumber2() + ")");
                    if (i < sequence.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }
        }
    }

    public void stopPlayer() {
        running = false;
    }

    public synchronized int getMaxSequenceLength() {
        return maxSequenceLength;
    }

    private void checkEndGame() {
        if (game.getBag().isEmpty()) {
            game.endGame();
        }
    }
}

