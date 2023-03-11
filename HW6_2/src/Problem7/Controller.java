package Problem7;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

public class Controller {
    private static Task<Boolean> copyWorker;
    private final int numFiles = 30;
    private ExecutorService threadPool;
    
    private Task<Boolean> createWorker(final int numFiles) {
        return new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                for (int i = 0; i < numFiles; i++) {
                    long elapsedTime = System.currentTimeMillis();
                    copyFile("some file", "some dest file");
                    elapsedTime = System.currentTimeMillis() - elapsedTime;
                    String status = elapsedTime + " milliseconds";
                    // queue up status
                    updateMessage(status);
                    updateProgress(i + 1, numFiles); // (progress, max)
                }
                return true;
            }
        };
    }
    private void copyFile(String src, String dest) throws InterruptedException {
        // simulate a long time
        Random rnd = new Random(System.currentTimeMillis());
        long millis = rnd.nextInt(1000);
        Thread.sleep(millis);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelButton;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private Button startButton;

    @FXML
    private TextArea textArea;

    @FXML
    void clickCancel(ActionEvent event) {
        startButton.setDisable(false);
        cancelButton.setDisable(true);
        copyWorker.cancel(true);
        // reset
        progressBar.progressProperty().unbind();
        progressBar.setProgress(0);
        progressIndicator.progressProperty().unbind();
        progressIndicator.setProgress(0);
        textArea.appendText("File transfer was cancelled.");
    }

    @FXML
    void clickStart(ActionEvent event) {
        startButton.setDisable(true);
        progressBar.setProgress(0);
        progressIndicator.setProgress(0);
        textArea.setText("");
        cancelButton.setDisable(false);
        copyWorker = createWorker(numFiles);
        // wire up progress bar
        progressBar.progressProperty().unbind();
        progressBar.progressProperty().bind(copyWorker.progressProperty());
        progressIndicator.progressProperty().unbind();
        progressIndicator.progressProperty().bind(copyWorker.progressProperty());
        // append to text area box
        copyWorker.messageProperty().addListener((ObservableValue<? extends String>
                                                          observable, String oldValue, String newValue) -> {
            textArea.appendText(newValue + "\n");
        });
        threadPool.submit(copyWorker);
    }

    @FXML
    void initialize() {
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'file.fxml'.";
        assert progressBar != null : "fx:id=\"progressBar\" was not injected: check your FXML file 'file.fxml'.";
        assert progressIndicator != null : "fx:id=\"progressIndicator\" was not injected: check your FXML file 'file.fxml'.";
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'file.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'file.fxml'.";

//        Scene scene = startButton.getScene();
//        BorderPane mainPane = (BorderPane)scene.getRoot();
//        scene.getWindow().setOnCloseRequest();
    }

}
