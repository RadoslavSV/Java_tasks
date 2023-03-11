package Zad2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Zad2 extends Application {

    private int sceneWidth;
    private int sceneHeight;
    private void drawMesh(Group group) {
        Line line;
        int increments = 15;
        int xWidth = sceneWidth / increments;
        int yHeight = sceneHeight / increments;
        for (int count = 0; count < increments; count++) {
            line = new Line(0, count * yHeight, (count + 1) * xWidth, sceneHeight);
            line.setStroke(Color.BLUE);
            group.getChildren().add(line);
        }
    }
    private static String inputDialog(String infoMessage, String titleBar, String headerMessage) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titleBar);
        dialog.setHeaderText(headerMessage);
        dialog.setContentText(infoMessage);
        return dialog.showAndWait().get();
    }
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();

        sceneWidth = Integer.parseInt(inputDialog("x = ", "Scene Width", null));
        sceneHeight = Integer.parseInt(inputDialog("y = ", "Scene Height", null));

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
