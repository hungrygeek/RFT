package uk.ac.cam.ss2099.fjava.tick1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.server.ServerNotActiveException;

public class StringReceive {
	public static void main(String[] args) throws IOException {
			String server_name = null;
			int port = 0;
			Socket mySocket = null;
		try{
			server_name = args[0];
			port = Integer.parseInt(args[1]);
		}catch(ArrayIndexOutOfBoundsException e1){
			System.err.println("This application requires two arguments: <machine> <port>");
			return;
		}catch(NumberFormatException e2){
			System.err.println("This application requires two arguments: <machine> <port>");
			return;
		}
		
		try{
			mySocket = new Socket(server_name, port);
		}catch(ConnectException e){
			System.err.println("Cannot connect to "+ server_name +" on port "+ port);
			return;
		}
			InputStream stream;
			String contents;
		while(true){
			stream = mySocket.getInputStream();
			byte[] buffer = new byte[1024];
			stream.read(buffer);
			contents = new String(buffer);
			System.out.println(contents);
		}
	}
}
