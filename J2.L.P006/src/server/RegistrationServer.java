package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import javax.swing.JOptionPane;
import services.RegistrationServerImpl;

/**
 *
 * @author LTD
 */
public class RegistrationServer {

    public static void main(String[] args) {
        String serviceName = "rmi://localhost:1098/RegistrationServerImpl";
        RegistrationServerImpl server;
        try {
            server = new RegistrationServerImpl();
            LocateRegistry.createRegistry(1098);
            //register the name of service
            Naming.rebind(serviceName, server);
            System.out.println("Service " + serviceName + " is running.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "can't connect with rmi");
        }
    }
}
