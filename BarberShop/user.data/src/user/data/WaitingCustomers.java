package user.data;

public class WaitingCustomers {
    private Semaphore semaphore;
    private int waiting;

    public WaitingCustomers(Semaphore s) {
        this.semaphore = s;
    }

    public int getWaiting() {
        return this.waiting;
    }

    public void waitingCustomersPlus() {
        this.semaphore.sleep();
        this.waiting++;
        this.semaphore.wakeUp();
    }

    public void waitingCustomersMinus() {
        this.semaphore.sleep();
        this.waiting--;
        this.semaphore.wakeUp();
    }

    public void increment() {
        this.waiting++;
    }

    public void decrement() {
        this.waiting--;
    }
}
