package lab13.sols.problem3.B.d;

import java.time.LocalTime;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClockWithTaskApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ClockPaneWithProperty root = new ClockPaneWithProperty();
        Task task = new Task<Void>() {
            protected Void call() throws Exception {
                while (true) {
                    LocalTime now = LocalTime.now();
                    Platform.runLater(() -> {
                        root.setHourProperty(now.getHour());
                        root.setMinuteProperty(now.getMinute());
                        root.setSecondProperty(now.getSecond());
                    });
                    if (isCancelled()) {
                        System.out.println("Cancelled");
                        break;
                    }

                    // Now block the thread for a short time, but be sure
                    // to check the interrupted exception for cancellation!
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException interrupted) {
                        if (isCancelled()) {
                            System.out.println("Cancelled");
                            break;
                        }

                    }
                }
                return null;
            }
        };

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setOnCloseRequest(value -> task.cancel());
        primaryStage.setTitle("Clock demo with Task");
        primaryStage.setScene(scene);

        primaryStage.show();
        new Thread(task).start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
