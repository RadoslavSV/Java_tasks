package lab13.sols.problem3.B.b;

import java.io.FileNotFoundException;
import java.util.Formatter;
import javafx.application.Platform;
import lab13.sols.problem3.ClockPane;

public class ClockAnimationUsingButtonsText extends ClockPane
        implements Runnable {

    private boolean suspended = true;
    private Formatter f;
    private StringBuilder sb;

    public ClockAnimationUsingButtonsText()  {
        try {
            f  = new Formatter("ticks.txt");
        } catch (FileNotFoundException ex) {
             
        }
        sb = new StringBuilder();
        Thread t = new Thread(this);
        t.setDaemon(true);// stop the thread when JavaFX exits
        t.start();
    }

    public void run() {
        while (true) {
            // run on the UI thread etCurrentTime()
            Platform.runLater(() -> setCurrentTime());
            sb.append(String.format("[%02d:%02d:%02d]%n", 
                                        getHour(), getMinute(), getSecond()));
            try {
                Thread.sleep(1000);
                waitIfSuspended();
            } catch (InterruptedException ex) {

            }
        }
    }
    public void closeFile(){
        if(f!= null) f.close();
    }
    public synchronized void suspend() {
        suspended = true;
        f.format("%s%nClock Stopped%n", sb.toString());
        sb.setLength(0);// clear stringBuilder
    }

    public synchronized void resume() {
        f.format("%nClock started%n", sb.toString());
       
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
