package controller;

import model.Model;
import view.View;

public class Generate implements Command {

	private Model model;
	private View view;
	
	public Generate(Model model , View view) {
		this.model = model;
		this.view = view;
	}
	
	
	@Override
	public void doCommand(String param) {
		String[] s = param.split(" ");
		if(s[0].equals("3d") && s[1].equals("maze") && s.length > 5)
		{
			try {
				model.generate(s[2],Integer.parseInt(s[3]),Integer.parseInt(s[4]),Integer.parseInt(s[5]));
			} catch (NumberFormatException e) {
				
				view.display("Invalid parameters.");
			}
		}
		else
		{
			view.display("Missing parameters.");
		}
		

	}

}
