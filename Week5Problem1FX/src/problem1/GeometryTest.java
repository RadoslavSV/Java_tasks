package problem1;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class GeometryTest extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);

        Random rand = new Random();
        double xRand = rand.nextInt(40_001)/100.0;

        Point sPoint = new Point(new double[]{xRand, 30});
        Rectangle rectangle1 = new Rectangle(sPoint, 20, 30);

        Point ePoint = new Point(new double[]{sPoint.getCoords()[0]+rectangle1.getWidth(),
                                              sPoint.getCoords()[1]+rectangle1.getHeight()});
        Line line = new Line(sPoint, ePoint);

        rectangle1.draw(group);
        line.draw(group);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
