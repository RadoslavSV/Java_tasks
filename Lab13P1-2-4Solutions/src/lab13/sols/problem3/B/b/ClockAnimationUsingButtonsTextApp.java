/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13.sols.problem3.B.b;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author echrk
 */
public class ClockAnimationUsingButtonsTextApp extends Application {

    public void start(Stage primaryStage) {

        VBox vb = new VBox();
        ClockAnimationUsingButtonsText root = new ClockAnimationUsingButtonsText();
        root.setPrefSize(200, 300);
        Button btnStart = new Button("Start");
        btnStart.setOnAction(value -> root.resume());
        Button btnStop = new Button("Stop");
        btnStop.setOnAction(value -> root.suspend());
        vb.getChildren().addAll(root, btnStart, btnStop);

        Scene scene = new Scene(vb, 300, 250);
        // close the file !!
        primaryStage.setOnCloseRequest(value-> root.closeFile());
        primaryStage.setTitle("Clock writing to file");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
