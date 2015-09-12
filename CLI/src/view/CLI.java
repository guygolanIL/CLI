package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

/**
 * Defines what the user interface CLI can do.
 * @author Guy Golan & Amit Sandak
 *
 */
public class CLI {

	private BufferedReader in ;
	private PrintWriter out;
	private HashMap<String, Command> commandMap;
	
	public CLI(BufferedReader in , PrintWriter out , HashMap<String, Command> commandMap) {		//Ctor
		this.in = in ;
		this.out = out;
		this.commandMap = commandMap;
	}
	
	/**
	 * Starting the run of the CLI.
	 */
	public void start() {
		
		
		new Thread(new Runnable() {					//the user interface runs in an independant thread.
			
			@Override
			public void run() {
				
				try {
					Command c = null;
					String buffer = in.readLine();
					
					while(!buffer.equals("exit")){

						
							c = commandMap.get(buffer.split(" ")[0]);
								
							if(c != null)
							{
								if(buffer.split(" ").length > 1)
								{
									c.doCommand(buffer.substring(buffer.indexOf(' ')+1));			//executing the command.
								}
								else
								{
									out.println("Missing parameters.");
									out.flush();
								}
							}
							else
							{
								
								out.println(buffer+" is not a valid command.");
								out.flush();
								
							}
							
							buffer = in.readLine();
					}
					commandMap.get("exit").doCommand("");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}).start();

	}
	
}
