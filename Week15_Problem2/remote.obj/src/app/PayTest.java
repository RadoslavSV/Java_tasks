package app;

import com.Payable;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PayTest {
    public static void main(String[] args) {
        String remoteObjName = "Payment";

        Payable o;
        try {
            o = new Payment();

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind(remoteObjName, o);
            System.out.printf("Remote object named: %s is registered. Registry is running...%n", remoteObjName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
