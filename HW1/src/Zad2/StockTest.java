package Zad2;

import static java.lang.Double.parseDouble;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class StockTest extends Application {
    private static TextInputDialog dialog = new TextInputDialog();

    public String inputDialog(String infoMessage, String titleBar, String headerMessage) {
        dialog.setTitle(titleBar);
        dialog.setHeaderText(headerMessage);
        dialog.setContentText(infoMessage);
        return dialog.showAndWait().get();
    }

    @Override
    public void start(Stage primaryStage) {
        String name = inputDialog("Enter the stock's name:", "Stock Name", null);
        dialog.getEditor().clear();
        String symbol = inputDialog("Enter the stock's symbol:", "Stock Symbol", null);
        dialog.getEditor().clear();
        String currPrice = inputDialog("Enter the current price:", "Current Price", null);
        dialog.getEditor().clear();
        String prevPrice = inputDialog("Enter the previous price:", "Previous Price", null);
        Platform.exit();

        Stock stk = new Stock(symbol, name);
        stk.setCurrentPrice(parseDouble(currPrice));
        stk.setPreviousClosingPrice(parseDouble(prevPrice));
        System.out.printf("Stock's name is \"%s\" with symbol \"%s\"\n", stk.getName(), stk.getSymbol());
        System.out.printf("Stock's current price is %.2f\nIts previous price was %.2f\n",
                stk.getCurrentPrice(), stk.getPreviousClosingPrice());
        System.out.printf("The percentage of change is %.2f%%\n", stk.changePercent());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
