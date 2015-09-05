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
	
	public MyView(){
		
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
	public void display() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setCommands(HashMap<String, Command> commandMap) {
		
		try {
			cli = new CLI(new BufferedReader(new FileReader("test1.txt")),new PrintWriter("test2.txt"), commandMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	


	
	
	
	
	

}
