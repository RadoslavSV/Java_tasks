package Problem1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AccountsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField txtField;

    @FXML
    void bntQuitClicked(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void writeInField(ActionEvent event) {
        System.out.println(txtField.getCharacters());
    }

    @FXML
    void initialize() {
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sceneAccounts.fxml'.";
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'sceneAccounts.fxml'.";

    }

}
