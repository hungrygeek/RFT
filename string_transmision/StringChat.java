import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.Thread;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

public class StringChat {
	public static void main(String[] args) throws IOException {

		String server = null;
		int port = 0;
		try{
			server = args[0];
			port = Integer.parseInt(args[1]);
		}catch(ArrayIndexOutOfBoundsException e1){
			System.err.println("This application requires two arguments: <machine> <port>");
			return;
		}catch (NumberFormatException e2){
			System.err.println("This application requires two arguments: <machine> <port>");
			return;
		}
			
		final Socket s ;//once object s is determined, it can never be changed.
		try{
			 s = new Socket(server, port);
		}catch(ConnectException e){
			System.err.println("Cannot connect to "+ server +" on port "+ port);
			return;
		}
		
			Thread output = new Thread() {
				@Override
				public void run() {
					InputStream stream;
					String contents;
					while(true){
						try {
							stream = s.getInputStream();
						} catch (IOException e) {
							System.err.println("IOException");
							return;
						}
						byte[] buffer = new byte[1024];
						try {
							stream.read(buffer);
						} catch (IOException e) {
							System.err.println("IOException");
							return;
						}
						contents = new String(buffer);
						System.out.println(contents);
					}
				}
			};
		
		output.setDaemon(true); //Marked as a daemon thread(The Java Virtual Machine exits when the only threads running are all daemon threads) 
		output.start();

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		OutputStream out = s.getOutputStream();
			while(true) {
				String user_data = r.readLine();
				out.write(user_data.getBytes());
				out.flush();
				}
		}
}
