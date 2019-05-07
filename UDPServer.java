import java.net.*;
import java.io.*;

public class UDPServer {
	public static void main(String args[]) {

    // args give message contents and server hostname
    DatagramSocket aSocket = null;
    
		try {
      // setting the DatagramSocket to the specific port number
      aSocket = new DatagramSocket(6789);
      // buffer for message 
			byte[] buffer = new byte[1000];
      
			while (true) {
        // Creates DatagramPacket containg key information to send a request to client
        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
        // receives the data from the client
        aSocket.receive(request);
        DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
        // echos the message back to the client
				aSocket.send(reply);
      }
      
		} catch (SocketException e) {
			System.out.println("Socket:  " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:  " + e.getMessage());
		}finally {
			if (aSocket != null)
				aSocket.close();
    }
    
	}
}

