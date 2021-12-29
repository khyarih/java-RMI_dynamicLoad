package test;


import server.ServerLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class Server {
    private static void test() throws RemoteException {
        ServerLogic remoteObject = new ServerLogic();
        String str = "hello";
        System.out.println(remoteObject.reverse(str).equals("olleh"));
    }
    public static void main(String[] args) {
        try{
            ServerLogic remoteObject = new ServerLogic();
            System.out.println("RemoteObject Created ");
            LocateRegistry.createRegistry(1099);
            String name = "rmi://localhost:1099/reverse";
            System.out.println("Calling Rebind");
            Naming.rebind(name,remoteObject);
            System.out.println("The Server is Listening  ... ^_^ ... ");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}