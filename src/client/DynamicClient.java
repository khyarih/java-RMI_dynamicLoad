package client;

import java.lang.reflect.Constructor;
import java.util.Properties;
import java.rmi.server.RMIClassLoader;

public class DynamicClient {
    public DynamicClient (String str) throws Exception {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        Properties p = System.getProperties();
        System.setProperty("java.rmi.server.useCodebaseOnly","false");
        System.setProperty("java.rmi.server.codebase","http://localhost/rmi/");

        String url = p.getProperty("java.rmi.server.codebase");
        Class<?> ClasseClient = RMIClassLoader.loadClass(url,"client.ReverseClient");

        //lunch the java.client
        Constructor<?>[] C = ClasseClient.getConstructors();
        System.out.println(C[0].getName());
        C[0].newInstance(str);
    }
    public static void main(String[] args) {
        try {
            String str = "hello";
//            DynamicClient dynamicClient = new DynamicClient(str);
            new DynamicClient(str);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
