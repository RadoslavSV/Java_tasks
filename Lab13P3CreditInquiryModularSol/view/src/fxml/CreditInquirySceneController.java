package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public class CreditInquirySceneController {

    private CreditInquiry ci;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem mnuCreditBalance;

    @FXML
    private Menu mnuOptions;

    @FXML
    private MenuItem mnuZeroBalance;

    @FXML
    private MenuItem mnuDebitBalance;

    @FXML
    private MenuItem mnuExit;

    @FXML
    private TextArea txaOutput;

    @FXML
    void mnuCreditBalanceOnAction(ActionEvent event) {
        txaOutput.appendText("\nAccounts with credit balances:\n");
        txaOutput.appendText(ci.processRequests(MenuOption.CREDIT_BALANCE));
    }

    @FXML
    void mnuDebitBalanceOnAction(ActionEvent event) {
        txaOutput.appendText("\nAccounts with debit balances:\n");
        txaOutput.appendText(ci.processRequests(MenuOption.DEBIT_BALANCE));
    }

    @FXML
    void mnuExitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void mnuZeroBalanceOnAction(ActionEvent event) {
        txaOutput.appendText("\nAccounts with zero balances:\n");
        txaOutput.appendText(ci.processRequests(MenuOption.ZERO_BALANCE));
    }

    @FXML
    void initialize() {
        ci = new CreditInquiry();

    }
}
