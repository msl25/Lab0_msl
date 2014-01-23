package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import message.Message;
import messagepasser.MessagePasser;

public class application {

	
	public static void main(String[] args) throws IOException {
		
		String configName;
		String processName;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter configuration file name:");
		configName = in.nextLine();	
		
		System.out.println("Enter process name:");
		processName = in.nextLine();
		
		/* Create a message */
		Message msg = new Message("192.168.1.52", "Ack", "Hello World");
		//msg.setSeq_Num();
		//msg.setDuplicate(false);
		//msg.setSrc(process);
		
		//Message parser
		MessagePasser msgpasser = new MessagePasser(configName, processName);
		
		msgpasser.send(msg);
	}

}
