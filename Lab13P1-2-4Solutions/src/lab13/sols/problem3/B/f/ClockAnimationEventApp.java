/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13.sols.problem3.B.f;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author echrk
 */
public class ClockAnimationEventApp extends Application {
    
   
    public void start(Stage primaryStage) {
         
      
        ClockAnimationEvent root = new ClockAnimationEvent();
          
        Scene scene = new Scene(root, 300, 250);
        
        
        primaryStage.setTitle("Clock with TimeLine");
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
