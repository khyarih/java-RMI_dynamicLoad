package client;

import server.Interface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ReverseClient {
    public ReverseClient(String str){
        try
        {
            System.out.println("ReverseClient");
//            ReverseInterface rev = (ReverseInterface) Naming.lookup("rmi://localhost:1099/reverse");
//            String result = rev.reverseString(args[0]);
//            System.out.println ("Inverse of "+args[0]+" est "+result);

            Registry registry = LocateRegistry.getRegistry();
            Interface stub = (Interface) registry.lookup("rmi://localhost:1099/reverse");
            String response = stub.reverse(str);
            System.out.println ("Inverse of "+str+" est "+response);
        }
        catch (Exception e)
        {
            System.out.println ("error d'accès à l'objet distant ");
            e.printStackTrace();
        }
    }
}
