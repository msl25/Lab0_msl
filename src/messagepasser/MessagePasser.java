package messagepasser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import message.Message;


public class MessagePasser {
	
	public static Queue<Message> recvBuffer = null;
	public static Queue<Message> sendBuffer = null;
	String processName;
	
	parser parser = new parser();
	public int port = Integer.parseInt(parser.config.get(processName).get(1));
	
	public MessagePasser(String confName, String processName) throws IOException {
		
		parser.parseConfig(confName);
		this.processName = processName;
		
		recvBuffer = new LinkedList<Message>();
		sendBuffer = new LinkedList<Message>();
		
		new serverListening(port, recvBuffer).run(); 
	}
	
	
	public void send(Message msg) throws IOException {
		
		//Check rules
		sendBuffer.add(msg);
		
		//send on socket
		
	}
	
	public Message receive() {
		
		Message msg;
		synchronized (recvBuffer) {
			msg = recvBuffer.remove();
		}
		return msg;
	}
}
