package controller;

import java.io.File;


public class Dir extends CommonCommand{

	//private View view;
	

	/*public Dir(View view) {
		this.view = view;
	}*/
	
	public Dir(	Controller controller) {
		super(controller);
		
	}
	
	@Override
	public void doCommand(String param) {

		if(param != null)
		{
			controller.display(new File(param).list());
		}
		else
		{
			controller.display("Missing parameters");
		}
		
	}

}
