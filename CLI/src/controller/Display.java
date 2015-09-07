package controller;

import model.Model;

public class Display implements Command {

	private Model model;
	
	public Display(Model model) {
		this.model = model;
	}
	@Override
	public void doCommand(String param) {
		
		model.mazeDisplay(param);
	}

}
