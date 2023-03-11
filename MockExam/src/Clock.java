import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Clock extends Pane {
    private Time time;////////////////////
    private Label lblClockDisplay;
    private Button btnStop;
    private Button btnStart;
    private boolean isRunning;

    public Clock() {////////////////////
        this.time = new Time();////////////////////

        this.lblClockDisplay = new Label();
        this.btnStop = new Button("Stop");
        this.btnStart = new Button("Start");
        this.isRunning = true;

        // Add the label and buttons to the Pane layout
        this.getChildren().addAll(lblClockDisplay, btnStop, btnStart);

        // Set up event handlers for the buttons
        btnStop.setOnAction(e -> stop());
        btnStart.setOnAction(e -> start());

        // Update the clock display every second
        new Thread(() -> {
            while (true) {
                if (isRunning) {
                    update();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }////////////////////

    public void update() {
        lblClockDisplay.setText(time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds());
    }

    public void stop() {
        isRunning = false;
    }

    public void start() {
        isRunning = true;
    }

    public void setClock(Time newTime) {////////////////////
        Time t = new Time();////////////////////
        t.setTime(newTime);////////////////////

        this.time = t;////////////////////
    }////////////////////
}
