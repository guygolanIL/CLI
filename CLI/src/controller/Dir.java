package controller;

import java.io.File;

import view.View;

public class Dir implements Command {

	private View view;
	

	public Dir(View view) {
		this.view = view;
	}
	
	@Override
	public void doCommand(String param) {
		
		view.display(new File(param.split("dir ")[1]).list());

	}

}
