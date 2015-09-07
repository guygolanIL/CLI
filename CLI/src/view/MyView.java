package view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.xml.bind.helpers.PrintConversionEventImpl;

import controller.Command;
import controller.Controller;

public class MyView implements View {

	private Controller controller;
	private CLI cli;
	private BufferedReader in;
	private PrintWriter out;
	
	public MyView(BufferedReader in , PrintWriter out){
		this.in = in;
		this.out = out;
	}


	public Controller getController() {
		return controller;
	}


	public void setController(Controller controller) {
		this.controller = controller;
	}


	@Override
	public void start() {
		
		cli.start();
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




	


	
	
	
	
	

}
