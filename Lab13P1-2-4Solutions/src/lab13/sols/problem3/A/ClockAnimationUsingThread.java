package lab13.sols.problem3.A;

import javafx.application.Platform;
import lab13.sols.problem3.ClockPane;


public class ClockAnimationUsingThread extends ClockPane
                                              implements Runnable {

    public ClockAnimationUsingThread() {
      Thread t = new Thread(this);
      t.setDaemon(true);// stop the thread when JavaFX exits
      t.start();
    }

    public void run() {
        while (true) {
            // run on the UI thread etCurrentTime()
            Platform.runLater(() -> setCurrentTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

}
