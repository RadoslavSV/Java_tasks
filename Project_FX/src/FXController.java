import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEnter;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void clickEnter(ActionEvent event) {
        System.out.printf("Username: %s\nPassword: %s", usernameField.getCharacters(), passwordField.getCharacters());
    }

    @FXML
    void initialize() {
        assert btnEnter != null : "fx:id=\"btnEnter\" was not injected: check your FXML file 'project.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'project.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'project.fxml'.";

    }

}
