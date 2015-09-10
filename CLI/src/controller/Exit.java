package controller;

public class Exit extends CommonCommand {

	public Exit(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String param) {
		controller.exit();

	}

}
