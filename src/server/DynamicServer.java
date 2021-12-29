package server;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;

public class DynamicServer {
    public static void main(String[] args) {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        System.setProperty("java.rmi.server.hostname","localhost");
        System.setProperty("java.rmi.server.useCodebaseOnly","false");
        System.setProperty("java.rmi.server.codebase","http://localhost/rmi/");

        String url = System.getProperties().getProperty("java.rmi.server.codebase");

        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");

        } catch (Exception e) {
            System.out.println("Exception starting RMI registry:");
            e.printStackTrace();
        }

        try{

            Class<?> ClassServer = RMIClassLoader.loadClass(url,"server.ServerLogic");
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("rmi://localhost:1099/reverse", (Remote)ClassServer.newInstance());
            System.err.println("Server ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

    }

}

