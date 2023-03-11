package server.com;

import model.com.TradeProduct;

public class ServerApplication {

    private TradeProduct trade;
    private Thread serverThread;

    public ServerApplication() {
        trade = new TradeProduct();
        serverThread = new Thread(new MultithreadedServer(trade));
        serverThread.start();
    }

    public static void main(String[] args) {
        ServerApplication server = new ServerApplication();
        System.out.println("Server started.");
    }
}