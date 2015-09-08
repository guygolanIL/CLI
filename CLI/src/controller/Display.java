package controller;


public class Display extends CommonCommand {

	
	
	public Display(Controller controller) {
		super(controller);
	}
	@Override
	public void doCommand(String name) {
		
		controller.mazeDisplay(name);
	}

}
