package javafxTest;

import java.net.URL;
import java.util.ResourceBundle;

import Cipher.CipherMethod;
import Cipher.Encryption;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MonoalphabeticController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDecrypt;

    @FXML
    private Button btnEncrypt;

    @FXML
    private Button btnQuit;

    @FXML
    private Label lblCypher;

    @FXML
    private Label lblDecrypt;

    @FXML
    private Label lblEncrypt;

    @FXML
    private TextField txtCypher;

    @FXML
    private TextField txtDecrypt;

    @FXML
    private TextField txtEncrypt;

    @FXML
    void bntQuitClicked(ActionEvent event) {
        Platform.exit();
    }

    private CipherMethod cipherMethod = new CipherMethod();

    @FXML
    void btnDecryptClicked(ActionEvent event) {
        String cypher = txtCypher.getText();
        String decrypt = txtDecrypt.getText();
        txtEncrypt.setText(cipherMethod.decryptText(decrypt, cypher));
    }

    @FXML
    void btnEncryptClicked(ActionEvent event) {
        String cypher = txtCypher.getText();
        String encrypt = txtEncrypt.getText();
        txtDecrypt.setText(cipherMethod.encryptText(encrypt, cypher));
    }

    @FXML
    void initialize() {
        Encryption encryption = new Encryption();

        assert btnDecrypt != null : "fx:id=\"btnDecrypt\" was not injected: check your FXML file 'monoalphabetic.fxml'.";
        assert btnEncrypt != null : "fx:id=\"btnEncrypt\" was not injected: check your FXML file 'monoalphabetic.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'monoalphabetic.fxml'.";
        assert lblCypher != null : "fx:id=\"lblCypher\" was not injected: check your FXML file 'monoalphabetic.fxml'.";
        assert lblDecrypt != null : "fx:id=\"lblDecrypt\" was not injected: check your FXML file 'monoalphabetic.fxml'.";
        assert lblEncrypt != null : "fx:id=\"lblEncrypt\" was not injected: check your FXML file 'monoalphabetic.fxml'.";
        assert txtCypher != null : "fx:id=\"txtCypher\" was not injected: check your FXML file 'monoalphabetic.fxml'.";
        assert txtDecrypt != null : "fx:id=\"txtDecrypt\" was not injected: check your FXML file 'monoalphabetic.fxml'.";
        assert txtEncrypt != null : "fx:id=\"txtEncrypt\" was not injected: check your FXML file 'monoalphabetic.fxml'.";

    }

}
