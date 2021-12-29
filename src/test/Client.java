package test;

import server.Interface;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) {
        try {
            String name = "rmi://localhost:1099/reverse";
            System.out.println("Creating the RemoteObject ...");
            Interface remoteObject = (Interface) Naming.lookup(name);

            //reserver
            String str = "hello";
            System.out.println("l'inverse de "+str+" est : "+remoteObject.reverse(str));

        }
        catch(RemoteException | NotBoundException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.exit(0);
    }
}
