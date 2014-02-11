package uk.ac.cam.ss2099.fjava.tick5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import uk.ac.cam.cl.fjava.messages.Message;

public class ChatServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		int port = 0;
		String path = null;
		try{
			port = Integer.parseInt(args[0]);
			path = args[1];
		} catch (Exception e){
			System.out.println("Usage: java ChatServer <port> <filesystem path prefix>");
			return;
		}
		ServerSocket server_s = null;
		try {
			server_s = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("Cannot use port number <" + port + ">");
			return;
		}

		MultiQueue<Message> mulQ = new MultiQueue<Message>();
		Database database = new Database(path);
		Socket s = null;
		while (true) {
			s = server_s.accept();
			new ClientHandler(s, mulQ, database);
		}
	}
}

