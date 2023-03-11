package server.com;

import client.data.ClientHandler;
import model.com.ITradeService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedServer implements Runnable {

    private ITradeService trade;
    private ServerSocket serverSocket;
    private ExecutorService executor;

    public MultithreadedServer(ITradeService trade) {
        this.trade = trade;
        executor = Executors.newCachedThreadPool();
        try {
            serverSocket = new ServerSocket(12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                executor.execute(new ClientHandler(client, trade));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}