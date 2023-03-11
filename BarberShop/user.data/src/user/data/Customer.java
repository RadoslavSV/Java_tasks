package user.data;

import java.util.Random;

import javafx.application.Platform;
import javafx.scene.control.*;

public class Customer implements Runnable {
    private Semaphore clients;
    private Semaphore barbers;
    private Semaphore mutex;
    private WaitingCustomers waitingCustomers;
    private TextArea txaCustomerOutput;
    private String CUSTOMER_NAME;
    private static final Random RAND = new Random(62528);
    private static final int CHAIRS = 10;

    public Customer(Semaphore clients, Semaphore barbers, Semaphore mutex, WaitingCustomers waitingCustomers, TextArea txaCustomerOutput, String CUSTOMER_NAME) {
        this.clients = clients;
        this.barbers = barbers;
        this.mutex = mutex;
        this.waitingCustomers = waitingCustomers;
        this.txaCustomerOutput = txaCustomerOutput;
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    public void run() {
        mutex.sleep();
        if (this.waitingCustomers.getWaiting() < this.CHAIRS) {
            this.waitingCustomers.increment();
            Platform.runLater(new RunnableOutput(this.CUSTOMER_NAME + " got a chair and waits. Total waiting: " + this.waitingCustomers.getWaiting(), this.txaCustomerOutput));
            this.clients.wakeUp();
            this.mutex.wakeUp();
            this.barbers.sleep();
            Platform.runLater(new RunnableOutput(this.CUSTOMER_NAME + " starts his haircut.", this.txaCustomerOutput));
            try {
                Thread.sleep(this.RAND.nextInt(0, 1001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(new RunnableOutput(this.CUSTOMER_NAME + " pays and leaves the Barber shop.", this.txaCustomerOutput));
        } else {
            this.mutex.wakeUp();
            Platform.runLater(new RunnableOutput(this.CUSTOMER_NAME + " no chairs are available- customer leaving the Barber shop", this.txaCustomerOutput));
        }
    }
}

