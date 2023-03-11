package lab13.sols.problem3.B.c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import lab13.sols.problem3.ClockPane;

public class ClockAnimation extends ClockPane {

    ScheduledExecutorService execService;

    public ClockAnimation() {
        // Create a Scheduled service with delay 1000 ms

        execService = Executors.newSingleThreadScheduledExecutor();
        execService.scheduleAtFixedRate(() -> {
            //The repetitive task, updates the clock GUI
            Platform.runLater(() -> setCurrentTime());
        }, 0, 1000L, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        // shutdown the service
        execService.shutdownNow();
    }

}
