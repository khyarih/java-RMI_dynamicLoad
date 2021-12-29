### Project
this project is like the "Hello world" for a java RMI project with `DynamicLoad`, it is composed of two main folders `src/server` and `src/client`

## Run the code
run the following commands from the `src` folder 

### compile, copy and launch the server code
```shell
path/src# sh compileServer.sh
```
will generate the `.class` files for server side code
```shell
path/src# sh copyServer.sh
```
copy `Interface.class` and `ServerLogic.class` files to `/var/www/html/rmi/server/`, assuming that you have this folder or create a new one
```shell
path/src# sh lanchServer.sh
```
launch the server

### compile, copy and launch the client code
same procedure but the `.sh` files have names with `*Client.sh` instead of `*Server.sh`
```shell
path/src# sh copyServer.sh
```
copy `ReverseClient.class` file to `/var/www/html/rmi/client/`, assuming that you have this folder or create a new one

the test is in `main` method in the `client`, 
```java
 public static void main(String[] args) {
        try {
            String str = "hello"; //the string to inverse
            new DynamicClient(str);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
```