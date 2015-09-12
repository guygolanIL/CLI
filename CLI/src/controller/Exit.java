package controller;

/**
 * Defines what the Command Exit should do.
 * @author Guy Golan & Amit Sandak
 *
 */
public class Exit extends CommonCommand {

	public Exit(Controller controller) {	//Ctor
		super(controller);
	}

	/**
	 * Activates a chain of safe exit using the Controller.
	 */
	@Override
	public void doCommand(String param) {
		controller.exit();
		
	}

}
