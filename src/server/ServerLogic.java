package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerLogic extends UnicastRemoteObject implements Interface{
    public ServerLogic() throws RemoteException {
        super();
    }

    @Override
    public String reverse(String str) throws RemoteException{
        String result = "";
        char[] chars = str.toCharArray();
        int i  = chars.length;
        while(--i >= 0){
            result += chars[i];
        }

        return result;
    }
}
