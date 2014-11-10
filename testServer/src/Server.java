import java.net.*;
import java.io.*;
 
public class Server {
    public static void main(String[] args) throws IOException { 
 
        int portNumber = Integer.parseInt("20001");
        boolean listening = true;
         
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
            while (listening) {
                new ServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}