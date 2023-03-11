import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClockApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Clock clock = new Clock();

        Scene scene = new Scene(clock);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Clock");
        primaryStage.show();
    }
}
