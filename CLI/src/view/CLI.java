package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI {

	private BufferedReader in ;
	private PrintWriter out;
	private HashMap<String, Command> commandMap;
	
	public CLI(BufferedReader in , PrintWriter out , HashMap<String, Command> commandMap) {
		this.in = in ;
		this.out = out;
		this.commandMap = commandMap;
	}
	
	
	public void start() {
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					Command c = null;
					String buffer = in.readLine();
					
					while(!buffer.equals("exit")){
						
							
							c = commandMap.get(buffer);
							if(c != null)
							{
								c.doCommand();
							}
							else
							{
								out.println(buffer+" is not a valid command.");
							}
						
					}
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
			
			
		
	}
	
}
