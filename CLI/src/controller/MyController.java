package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public class MyController implements Controller {

	private Model model;
	private View view;
	private HashMap<String, Command> commandMap;
	
	public MyController(Model model , View view) {
		this.model = model ;
		this.view = view;
		this.commandMap = new HashMap<String , Command>();
		commandMap.put("test", new TestCommand());
		view.setCommands(commandMap);
		commandMap.put("dir", new Dir(view));
	}


	public Model getModel() {
		return model;
	}


	public void setModel(Model model) {
		this.model = model;
	}


	public View getView() {
		return view;
	}


	public void setView(View view) {
		this.view = view;
	}



}
