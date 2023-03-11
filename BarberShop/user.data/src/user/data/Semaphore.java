package user.data;

import java.util.*;

public class Semaphore {
    private int s;
    private ArrayList<Thread> waitList = new ArrayList<Thread>();

    public Semaphore(int s) {
        this.s = s;
    }

    public synchronized void sleep() {
        while(this.s==0) {
            this.waitList.add(Thread.currentThread());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.s--;
    }

    public synchronized void wakeUp() {
        s++;
        for(Thread x : this.waitList) {
            x.interrupt();
        }
        this.waitList.clear();
    }
}

