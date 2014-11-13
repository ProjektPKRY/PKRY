import java.net.*;
import java.util.Scanner;
import java.io.*;
 
public class Server {
    public static void main(String[] args) throws IOException { 
     	
    	System.out.print("Podaj port: ");
    	Scanner scanner = new Scanner(System.in);
    	int portNumber = scanner.nextInt();
    	
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