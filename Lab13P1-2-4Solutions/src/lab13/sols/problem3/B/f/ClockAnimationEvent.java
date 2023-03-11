package lab13.sols.problem3.B.f;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import lab13.sols.problem3.ClockPane;

public class ClockAnimationEvent extends ClockPane {

    public ClockAnimationEvent() {
       
        // Create an animation for a running clock
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        setCurrentTime();
        animation.play(); // Start animation

    }

// Create a handler for animation
    private EventHandler<ActionEvent> eventHandler = e -> {
        setCurrentTime(); // Set a new clock time
    };


}
