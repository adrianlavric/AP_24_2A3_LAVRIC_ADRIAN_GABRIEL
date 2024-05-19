package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    private ServerSocket serverSocket;
    private boolean isRunning;
    private ExecutorService executorService;
    private ConcurrentHashMap<String, Game> games;

    public GameServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executorService = Executors.newCachedThreadPool();
        games = new ConcurrentHashMap<>();
        isRunning = true;
    }

    public void start() {
        System.out.println("Server started...");
        while (isRunning) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket, this);
                executorService.submit(clientThread);
            } catch (IOException e) {
                if (isRunning) {
                    System.err.println("Error accepting client connection: " + e.getMessage());
                }
            }
        }
        stop();
    }

    public void stop() {
        isRunning = false;
        try {
            executorService.shutdown();
            if (!serverSocket.isClosed()) {
                serverSocket.close();
            }
            System.out.println("Server stopped.");
        } catch (IOException e) {
            System.err.println("Error stopping server: " + e.getMessage());
        }
    }

    public synchronized String createGame() {
        String gameId = "game" + (games.size() + 1);
        games.put(gameId, new Game(gameId));
        return gameId;
    }

    public Game getGame(String gameId) {
        return games.get(gameId);
    }

    public static void main(String[] args) {
        try {
            GameServer server = new GameServer(12345);
            server.start();
        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
    }
}