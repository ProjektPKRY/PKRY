import java.io.*;
import java.net.*;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String serwer = "localhost";
		
		int port = 20001;

		try (
				Socket socket = new Socket(InetAddress.getByAddress(new byte[] {10, 1, 8, 39}), port);
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                new InputStreamReader(socket.getInputStream()));
				){
            
			out.println("test");
            String fromServer;
            String fromUser;
            fromUser = null;
            while ((fromServer = in.readLine()) != null) {
            	
            	System.out.println(fromServer);
            	
                if (fromServer.equals("Bye."))
                    break;
                 
               
                if (fromUser != null) {
                    
                    out.println(fromUser);
                    fromUser = null ;
                }                    
            }
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host " + serwer);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to " +
	                serwer);
	            System.exit(1);
	        }
	}
}