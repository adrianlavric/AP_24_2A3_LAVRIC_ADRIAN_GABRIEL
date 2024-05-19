package org.example;

import java.util.Arrays;

public class Board {
    private char[][] board;
    private static final int SIZE = 10;

    public Board() {
        board = new char[SIZE][SIZE];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        placeShips();
    }

    private void placeShips() {
        // Place a ship for testing
        for (int i = 0; i < 5; i++) {
            board[0][i] = 'S';
        }
    }

    public boolean makeMove(String move) {
        int row = move.charAt(0) - 'A';
        int col = Integer.parseInt(move.substring(1)) - 1;

        if (board[row][col] == 'S') {
            board[row][col] = 'X';
            return true;
        } else {
            board[row][col] = 'O';
            return false;
        }
    }

    public boolean isGameOver() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'S') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}