package view.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.com.*;

public class FXController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txaOutput;
    private StockExchangeController controller;
    private ITradeService trade = new TradeProduct();
    private Alert mbox;

    @FXML
    void initialize() {
        assert txaOutput != null : "fx:id=\"txaOutput\" was not injected: check your FXML file 'file.fxml'.";

        mbox = new Alert(Alert.AlertType.CONFIRMATION);
        controller = new StockExchangeController(txaOutput);

        readTable();

        controller.setTraders(this::updateCurrency);

        controller.onTraders();
    }

    public void readTable() {
        try (Socket socket = new Socket("localhost", 12345)) {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            trade = (ITradeService) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Currency[] updateCurrency() {
        return trade.getTrade();
    }
}
