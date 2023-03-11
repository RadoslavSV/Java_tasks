/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13.sols.problem2;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *
 * @author echrk
 */
public class TitleBinding extends Application {

    public void start(Stage primaryStage) {
        Pane root = new Pane();
        StringProperty other = new SimpleStringProperty();
       
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Some title");
        primaryStage.titleProperty().bind(Bindings.concat("Title: ").concat(other));
        String v = new TextInputDialog("Enter a new title").showAndWait().get();
        other.setValue(v);// change in other, changes titleProperty value
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
