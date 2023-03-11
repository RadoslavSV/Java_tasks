/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13.sols.problem3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ClockPaneApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
              
        ClockPane root = new ClockPane();
         
        Scene scene = new Scene(root, 300, 250);
         
        primaryStage.setTitle("Clock!");
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
