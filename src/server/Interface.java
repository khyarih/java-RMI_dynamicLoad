package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    String reverse(String str) throws RemoteException;
}