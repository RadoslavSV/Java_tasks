package lab13.sols.problem3.B.a;

import javafx.application.Platform;
import lab13.sols.problem3.ClockPane;

public class ClockAnimationUsingButtons extends ClockPane
                                       implements Runnable {

    private boolean suspended;
     

    public ClockAnimationUsingButtons() {
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
                waitIfSuspended();
            } catch (InterruptedException ex) {

            }
        }
    }

    public synchronized void suspend() {
        suspended = true;
    }

    public synchronized void resume() {
        if (suspended) {
            suspended = false;
            notifyAll();
        }
    }

    private synchronized void waitIfSuspended()
            throws InterruptedException {
        while (suspended) {
            wait();
        }
    }

}
