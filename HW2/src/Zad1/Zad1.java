package Zad1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Zad1 extends Application {

    private final int sceneWidth = 300;
    private final int sceneHeight = 300;
    private void drawMesh(Group group) {
        double v2 = 280, v3 = 20;
        for(int i=0; i<15; i++) {
            Line line = new Line(0, 0, v2, v3);
            line.setStroke(Color.BLUE);
            group.getChildren().add(line);
            v2 -= 20;
            v3 += 20;
        }
    }
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();

        drawMesh(group);
        Scene scene = new Scene(group, sceneWidth, sceneHeight);

        primaryStage.setTitle("Draw a mesh of lines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
