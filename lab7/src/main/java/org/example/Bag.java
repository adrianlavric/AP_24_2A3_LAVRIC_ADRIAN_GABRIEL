package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {
    private final List<Tile> tiles;

    public Bag(int numTiles) {
        tiles = new ArrayList<>();
        for (int i = 1; i <= numTiles; i++) {
            for (int j = 1; j <= numTiles; j++) {
                if (i != j) {
                    tiles.add(new Tile(i, j));
                }
            }
        }
        Collections.shuffle(tiles);
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany && i < tiles.size(); i++) {
            extracted.add(tiles.remove(0));
        }
        return extracted;
    }

    public synchronized boolean isEmpty() {
        return tiles.isEmpty();
    }
}
