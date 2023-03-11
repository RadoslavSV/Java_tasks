/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13.sols.problem3.B.c;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author echrk
 */
public class ClockAnimationApp extends Application {
    
   
    public void start(Stage primaryStage) {
         
      
        ClockAnimation root = new ClockAnimation();
          
        Scene scene = new Scene(root, 300, 250);
        // shutdown scheduled executoror
        primaryStage.setOnCloseRequest((e)-> root.shutdown());
        
        primaryStage.setTitle("Clock with ThreadPool");
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
