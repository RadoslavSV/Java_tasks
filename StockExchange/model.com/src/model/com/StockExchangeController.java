package model.com;

import javafx.application.Platform;
import javafx.scene.control.*;

import java.util.function.*;

public class StockExchangeController implements Runnable {
    private TextArea txaExchange;
    private Currency[] currency;
    private String txtUpdate;
    private Supplier<Currency[]> traders;

    public StockExchangeController(TextArea txaExchange) {
        this.txaExchange = txaExchange;
    }

    public void setTraders(Supplier<Currency[]> traders) {
        this.traders = traders;
    }

    @Override
    public void run() {
        while(true) {
            this.currency = traders.get();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(Currency x : currency) {
                Platform.runLater(() -> {
                    txaExchange.appendText(x.toString() + "\n");
                });
            }
        }
    }

    public void onTraders() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
