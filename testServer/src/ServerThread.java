import java.net.*;
import java.io.*;
 

public class ServerThread extends Thread {
    private Socket socket = null;
 
    public ServerThread(Socket socket) {
        super("ServerThread");
        this.socket = socket;
    }
     
    public void run() {
 
        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        ) {
            String outputLine;
            outputLine = "CONNECTED";
            out.println(outputLine);
            
            String inputLine;
            while (true) {
            	inputLine = in.readLine();
            	if (inputLine == "" || inputLine == null) {
            		break;
            	}
            	
            	else if (inputLine.equals("samochod")) {
            		out.println("Porsche 911");
            	}
            	else if (inputLine.equals("close")) {
            		System.out.println("Próbowa³ zakoñczyæ");
            		out.println("Dupa, nie wyjdziesz");
            		socket.close();
            	}
            	else {
            		System.out.println(socket.getInetAddress() + ": " + inputLine);
            	}
            }
 
            socket.close();
        } catch (IOException e) {
         //   e.printStackTrace();
        	System.out.println("Zerwano po³¹czenie");
        }
    }
}