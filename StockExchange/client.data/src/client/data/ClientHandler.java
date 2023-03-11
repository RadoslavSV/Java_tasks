package client.data;

import model.com.ITradeService;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket client;
    private ITradeService trade;

    public ClientHandler(Socket client, ITradeService trade) {
        this.client = client;
        this.trade = trade;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.writeObject(trade);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}