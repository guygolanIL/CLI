package controller;

import java.io.File;

import javax.swing.plaf.synth.SynthSeparatorUI;

import view.View;

public class Dir implements Command {

	private View view;
	

	public Dir(View view) {
		this.view = view;
	}
	
	@Override
	public void doCommand(String param) {
		
		
		
		
		if(param != null)
		{
			view.display(new File(param).list());
		}
		else
		{
			view.display("Missing parameters");
		}
		
			
		
	}

}
