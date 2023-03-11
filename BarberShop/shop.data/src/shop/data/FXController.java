package shop.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.scene.control.*;
import user.data.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

public class FXController {
    private Semaphore barbers;
    private Semaphore clients;
    private Semaphore mutex;
    private WaitingCustomers waitingCustomers;
    private Customer[] customers;
    private Barber barby;

    @FXML
    private TextArea txaBarberReport;

    @FXML
    private TextArea txaClientReport;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnStart;

    @FXML
    private TextField fieldClients;

    @FXML
    private TitledPane pane;

    @FXML
    private AnchorPane paneClient;

    @FXML
    void clickCopy(ActionEvent event) throws IOException {
        String msg = txaBarberReport.getText();
        String fileName = "semaphores.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(msg);
        bufferedWriter.close();
    }

    @FXML
    void clickQuit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void clickStart(ActionEvent event) {
        int total = Integer.parseInt(this.fieldClients.getText());
        this.customers = new Customer[total];

        String clientR = this.txaClientReport.getText();

        ExecutorService runCustomers = Executors.newFixedThreadPool(total);

        for (int i = 0; i < total; i++) {
            this.customers[i] = new Customer(this.clients, this.barbers, this.mutex, this.waitingCustomers, this.txaBarberReport, clientR);
            runCustomers.execute(this.customers[i]);
        }

        runCustomers.shutdown();
    }

    @FXML
    void initialize() {
        assert btnCopy != null : "fx:id=\"btnCopy\" was not injected: check your FXML file 'file.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'file.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'file.fxml'.";
        assert fieldClients != null : "fx:id=\"fieldClients\" was not injected: check your FXML file 'file.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'file.fxml'.";
        assert paneClient != null : "fx:id=\"paneClient\" was not injected: check your FXML file 'file.fxml'.";
        assert txaBarberReport != null : "fx:id=\"txaBarberReport\" was not injected: check your FXML file 'file.fxml'.";
        assert txaClientReport != null : "fx:id=\"txaClientReport\" was not injected: check your FXML file 'file.fxml'.";

        this.waitingCustomers = new WaitingCustomers(new Semaphore(0));
        this.barbers = new Semaphore(0);
        this.clients = new Semaphore(0);
        this.mutex = new Semaphore(1);

        this.barby = new Barber(this.clients, this.barbers, this.mutex, this.waitingCustomers, this.txaBarberReport);

        Thread Barber = new Thread(this.barby, "Barber");
        Barber.start();
    }

}

