package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import controller.Command;

public class MyView extends CommonView {

	private CLI cli;
	
	public MyView(BufferedReader in , PrintWriter out) {		//Ctor
		super(in , out);
	}


	@Override
	public void start() {
		
		cli.start();			//Initializing the user interface.
	}


	@Override
	public void display(String[] strings) {
		if(strings != null)
		{
			for (String string : strings) {
				out.println(string);
			}
			out.flush();
		}
		else
		{
			out.println("NULL");
			out.flush();
		}
	}

	@Override
	public void display(String string) {
		if(string != null)
		{
			out.println(string);
			out.flush();
		}
		else
		{
			out.println("Error");
			out.flush();
		}
	}

	@Override
	public void setCommands(HashMap<String, Command> commandMap) {	
			cli = new CLI(in,out, commandMap);
	}


	@Override
	public void exit() {
			
			out.println("the program terminated!");
			out.flush();

	}
}
