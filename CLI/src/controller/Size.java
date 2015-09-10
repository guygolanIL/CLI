package controller;

public class Size extends CommonCommand {

	public Size(Controller controller) {
		super(controller);
		
	}

	@Override
	public void doCommand(String name) {
		
		String s[] = name.split(" ");
		
		if(s.length > 1)
		{
			controller.size(s[1]);
		}
		else
		{
			controller.display("Missing parameters.");
		}

	}

}
