package Problem1FX;

import Problem1.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class TestFX extends Application {
    private int SEED;
    private int SIZE;

    private TextField txtInputFieldSeed;
    private TextField txtInputFieldSize;
    private Alert messageBox;
    public Button b0, b1, b2;

    @Override
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane(20, 15);
        pane.setAlignment(Pos.CENTER);
        messageBox = new Alert(Alert.AlertType.INFORMATION);
        txtInputFieldSeed = new TextField("Enter the seed");
        txtInputFieldSeed.setPrefWidth(250);
        txtInputFieldSize = new TextField("Enter the size");
        txtInputFieldSize.setPrefWidth(250);

        txtInputFieldSeed.setOnAction(this::onAction);
        txtInputFieldSize.setOnAction(this::onAction);

        b0 = new Button("Generate random A-Z");
        b0.setPrefWidth(150);
        b0.setOnAction(myHandler);
        b1 = new Button("Random sunset A-Z");
        b1.setPrefWidth(150);
        b1.setOnAction(myHandler);
        b2 = new Button("Quit");
        b2.setPrefWidth(150);
        b2.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        pane.getChildren().addAll(txtInputFieldSeed, txtInputFieldSize, b0, b1, b2);

        Scene scene = new Scene(pane, 350, 250);
        primaryStage.setTitle("Generate random sequence");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    final EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>(){
        @Override
        public void handle(final ActionEvent event) {
            String str = txtInputFieldSeed.getText();
            SEED = Integer.parseInt(str);
            String str2 = txtInputFieldSize.getText();
            SIZE = Integer.parseInt(str2);

            Wrapper wr = new Wrapper(SIZE);
            Cipherable cph = null;
            if (event.getSource() == b0) {
                cph = wr.makeFixedRandom();
            }
            else if(event.getSource() == b1) {
                cph = wr.makeFixedSelection();
            }
            Result res = (new CipherGenerator()).countDistinct(cph, SEED);

            messageBox.setTitle("Generate random sequence");
            messageBox.setHeaderText("Count distinct characters out of " + SIZE);
            messageBox.setContentText(String.format("Chars: " + Arrays.toString(res.getChars()) + '\n' +
                                      "Result: " + res.getData()));
            messageBox.showAndWait();
        }
    };

    public void onAction(ActionEvent event) {
        String str = txtInputFieldSeed.getText();
        SEED = Integer.parseInt(str);
        String str2 = txtInputFieldSize.getText();
        SIZE = Integer.parseInt(str2);

        System.out.println(SEED + "\n" + SIZE);

        messageBox.setTitle("Generate random sequence");
        messageBox.setHeaderText("Source of input and text content");
        messageBox.setContentText("ERROR");
        messageBox.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
