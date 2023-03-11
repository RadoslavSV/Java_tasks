package user.data;

import java.util.Random;
import javafx.scene.control.*;

public class Barber implements Runnable {
    private Semaphore clients;
    private Semaphore barbers;
    private Semaphore mutex;
    private WaitingCustomers waitingCustomers;
    private TextArea txaBarberOutput;
    private static int cnt;
    private static final Random RAND = new Random(62528);

    public Barber(Semaphore clients, Semaphore barbers, Semaphore mutex, WaitingCustomers waitingCustomers, TextArea txaBarberOutput) {
        this.clients = clients;
        this.barbers = barbers;
        this.mutex = mutex;
        this.waitingCustomers = waitingCustomers;
        this.txaBarberOutput = txaBarberOutput;
    }

    @Override
    public void run() {
        while (true) {
            this.clients.sleep();
            this.mutex.sleep();
            this.waitingCustomers.decrement();
            this.barbers.wakeUp();
            this.mutex.wakeUp();
            this.cnt++;

            this.txaBarberOutput.appendText(String.format("%s start haircut: %d %d",
                    Thread.currentThread().getName(), this.cnt, this.waitingCustomers.getWaiting()));

            try {
                Thread.sleep(this.RAND.nextInt(0, 1001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.txaBarberOutput.appendText(String.format("%s finished haircut: %d %d",
                    Thread.currentThread().getName(), this.cnt, this.waitingCustomers.getWaiting()));
        }
    }
}
