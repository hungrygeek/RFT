package uk.ac.cam.ss2099.fjava.tick5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import uk.ac.cam.cl.fjava.messages.ChangeNickMessage;
import uk.ac.cam.cl.fjava.messages.ChatMessage;
import uk.ac.cam.cl.fjava.messages.Message;
import uk.ac.cam.cl.fjava.messages.RelayMessage;
import uk.ac.cam.cl.fjava.messages.StatusMessage;

public class ClientHandler {
	private Socket socket;
	private MultiQueue<Message> multiQueue;
	private String nickname;
	private MessageQueue<Message> clientMessages;
	private Database database;

	public ClientHandler(final Socket s, MultiQueue<Message> q, Database d) throws SQLException {
		socket = s;
		multiQueue = q;
		database = d;

		clientMessages = new SafeMessageQueue<Message>();
		multiQueue.register(clientMessages);
		nickname = "Anonymous" + (new Random().nextInt(90000) + 10000);
		StatusMessage status_msg = new StatusMessage(nickname + " connected from " + socket.getInetAddress().getHostName());
		multiQueue.put(status_msg);
		try {
			database.incrementLogins();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}


		Thread thread_in = new Thread() {
			@Override
			public void run(){
				try{
					ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());
					while(true){
						Object MyObject = stream.readObject();
						if (MyObject instanceof ChangeNickMessage){
							String tmp = nickname;
							nickname = ((ChangeNickMessage) MyObject).name;
							StatusMessage status = new StatusMessage(tmp + " is now known as " + nickname + ".");
							multiQueue.put(status);
						}
						if (MyObject instanceof ChatMessage){
							RelayMessage relay = new RelayMessage(nickname,((ChatMessage) MyObject));
							multiQueue.put(relay);
							database.addMessage(relay);
						}
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					multiQueue.deregister(clientMessages);
					StatusMessage quit = new StatusMessage(nickname + " has disconnected.");
					multiQueue.put(quit);
					return;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		};
		thread_in.setDaemon(true); 
		thread_in.start();

		Thread thread_out = new Thread() {
			@Override
			public void run(){
				try{
					ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());

					//receive 10 recent messages
					try{
						List<RelayMessage> list = database.getRecent();
						for (int i = 0; i <= list.size()-1; i++) {
							stream.writeObject(list.get(i));
						}
					} catch (SQLException e){
						e.printStackTrace();
					}
					while(true){
						Message msg = clientMessages.take();
						stream.writeObject(msg);
						stream.flush();
					}
				}catch (IOException e) {
					multiQueue.deregister(clientMessages);
					StatusMessage quit = new StatusMessage(nickname + " has disconnected.");
					multiQueue.put(quit);
					return;
				}
			}
		};
		thread_out.setDaemon(true);
		thread_out.start();
	}
}

