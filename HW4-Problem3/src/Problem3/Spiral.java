package Problem3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Spiral extends Application {
    private void drawRedLine(Group grp, double v, double v1, double v2, double v3){
        Line line = new Line(v,v1,v2,v3);
        line.setStroke(Color.RED);
        grp.getChildren().add(line);
    }
    private void drawRedSpiral(Group group) {
        drawRedLine(group,450,50,50,50);
        drawRedLine(group,50,50,50,450);
        drawRedLine(group,50,450,400,450);
        drawRedLine(group,400,450,400,100);
        drawRedLine(group,400,100,100,100);
        drawRedLine(group,100,100,100,400);
        drawRedLine(group,100,400,350,400);
        drawRedLine(group,350,400,350,150);
        drawRedLine(group,350,150,150,150);
        drawRedLine(group,150,150,150,350);
        drawRedLine(group,150,350,300,350);
        drawRedLine(group,300,350,300,200);
        drawRedLine(group,300,200,200,200);
        drawRedLine(group,200,200,200,300);
        drawRedLine(group,200,300,250,300);
        drawRedLine(group,250,300,250,250);
    }
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);

        drawRedSpiral(group);

        primaryStage.setTitle("Draw square shaped spiral");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}