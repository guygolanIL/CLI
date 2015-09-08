package controller;

public abstract class CommonCommand implements Command {

	protected Controller controller;
	
	public CommonCommand(Controller controller) {
		this.controller = controller;
	}
	
	
	public abstract void doCommand(String param);
		

	

}
