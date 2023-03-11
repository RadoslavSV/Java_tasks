package user.data;

import javafx.scene.control.*;

public class RunnableOutput implements Runnable {
    private String msg;
    private TextArea txtArea;

    public RunnableOutput(String data, TextArea textArea) {
        this.msg = data;
        this.txtArea = textArea;
    }

    @Override
    public void run() {
        this.txtArea.appendText(this.msg);
    }
}

