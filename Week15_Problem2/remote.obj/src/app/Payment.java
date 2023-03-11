package app;

import com.Payable;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Payment extends UnicastRemoteObject implements Payable {
    public Payment() throws RemoteException{

    }

    @Override
    public double monthlyPayment(double rate, double loanAmount) throws RemoteException {
        return rate*loanAmount/12;
    }

    @Override
    public double totalPayment(double rate, double loanAmount, int years) throws RemoteException {
        return rate*loanAmount*years;
    }
}
