package messagepasser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Queue;

import message.Message;

public class serverReceive implements Runnable{

	public Queue<Message> recvBuffer;
	private ObjectInputStream input = null;
	
	public serverReceive(Socket peersocket, Queue<Message> recvBuffer) {
		this.recvBuffer = recvBuffer;
		try {
		input = new ObjectInputStream(peersocket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Message msg = (Message) input.readObject();
				synchronized (recvBuffer) {
					recvBuffer.add(msg);	
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
