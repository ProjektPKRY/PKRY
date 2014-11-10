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
                new InputStreamReader(
                    socket.getInputStream()));
        ) {
            String outputLine;
            outputLine = "CONNECTED";
            out.println(outputLine);
            System.out.println(socket.getInetAddress() + " - " + in.readLine());
 
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}