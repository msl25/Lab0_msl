package messagepasser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;

import message.Message;

public class serverListening implements Runnable {

	int port;
	public Queue<Message> recvBuffer;
	ServerSocket ListeningSocket = null;

	public serverListening(int port, Queue<Message> recvBuffer) throws IOException {

		this.port = port;
		this.recvBuffer = recvBuffer;

		ListeningSocket = new ServerSocket(port);
	}
	@Override
	public void run() {

		while(true) {
			Socket peerSocket = null;
			try {
				peerSocket = ListeningSocket.accept();
				new serverReceive(peerSocket, recvBuffer).run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}

}
