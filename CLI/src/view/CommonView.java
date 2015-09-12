package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

public abstract class CommonView implements View {

	protected Controller controller;
	protected BufferedReader in;
	protected PrintWriter out;
	
	public CommonView(BufferedReader in , PrintWriter out){		//Ctor
		this.in = in;
		this.out = out;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	
	public abstract void  start();
	public abstract void display(String string);
	public abstract void display(String[] strings);
	public abstract void setCommands(HashMap<String, Command> commandMap);
	
}
