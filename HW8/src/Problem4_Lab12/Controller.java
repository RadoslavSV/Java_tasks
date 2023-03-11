package Problem4_Lab12;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private RegistrationForm regForm;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField confPassField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button quitBtn;

    @FXML
    private Button regBtn;

    @FXML
    private TextField usernameField;

    @FXML
    private Label confPassWrong;
    @FXML
    private Label emailWrong;
    @FXML
    private Label phoneWrong;
    @FXML
    private Label usernameWrong;

    @FXML
    void writeUsernameField(ActionEvent event) {

    }

    @FXML
    void writePhoneField(ActionEvent event) {

    }

    @FXML
    void writeEmailField(ActionEvent event) {

    }

    @FXML
    void writePasswordField(ActionEvent event) {

    }

    @FXML
    void writeConfPassField(ActionEvent event) {

    }

    @FXML
    void clickQuitBtn(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void clickRegBtn(ActionEvent event) {
        boolean wrongUsername = true, wrongPhone = true, wrongEmail = true, wrongPassword = true;

        Pattern usernameRegex = Pattern.compile("^[a-zA-Z]{2,}$");
        Matcher usernameMatcher = usernameRegex.matcher(usernameField.getText());
        if(usernameMatcher.find()) {
            usernameWrong.setVisible(false);
            regForm.setUsername(usernameField.getText());
            wrongUsername = false;
        } else {
            usernameWrong.setVisible(true);
        }

        Pattern phoneRegex = Pattern.compile("^\\([0-9]{4}\\)\s\\([0-9]{7}\\)$");
        Matcher phoneMatcher = phoneRegex.matcher(phoneField.getText());
        if(phoneMatcher.find()) {
            phoneWrong.setVisible(false);
            regForm.setPhone(phoneField.getText());
            wrongPhone = false;
        } else {
            phoneWrong.setVisible(true);
        }

        Pattern emailRegex = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher emailMatcher = emailRegex.matcher(emailField.getText());
        if(emailMatcher.find()) {
            emailWrong.setVisible(false);
            regForm.setEmail(emailField.getText());
            wrongEmail = false;
        } else {
            emailWrong.setVisible(true);
        }

        if(passwordField.getText().equals(confPassField.getText()) && passwordField.getText().length()!=0) {
            confPassWrong.setVisible(false);
            regForm.setPassword(passwordField.getText());
            wrongPassword = false;
        } else {
            confPassWrong.setVisible(true);
        }

        if(!wrongUsername && !wrongPhone && !wrongEmail && !wrongPassword)  System.out.println(regForm);
    }

    @FXML
    void initialize() {
        assert confPassField != null : "fx:id=\"confPassField\" was not injected: check your FXML file 'regForm.fxml'.";
        assert confPassWrong != null : "fx:id=\"confPassWrong\" was not injected: check your FXML file 'regForm.fxml'.";
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'regForm.fxml'.";
        assert emailWrong != null : "fx:id=\"emailWrong\" was not injected: check your FXML file 'regForm.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'regForm.fxml'.";
        assert phoneField != null : "fx:id=\"phoneField\" was not injected: check your FXML file 'regForm.fxml'.";
        assert phoneWrong != null : "fx:id=\"phoneWrong\" was not injected: check your FXML file 'regForm.fxml'.";
        assert quitBtn != null : "fx:id=\"quitBtn\" was not injected: check your FXML file 'regForm.fxml'.";
        assert regBtn != null : "fx:id=\"regBtn\" was not injected: check your FXML file 'regForm.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'regForm.fxml'.";
        assert usernameWrong != null : "fx:id=\"usernameWrong\" was not injected: check your FXML file 'regForm.fxml'.";

        regForm = new RegistrationForm();
        usernameWrong.setVisible(false);
        phoneWrong.setVisible(false);
        emailWrong.setVisible(false);
        confPassWrong.setVisible(false);
    }

}
