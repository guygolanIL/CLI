package controller;

public class Save extends CommonCommand {

	public Save(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String param) {
		String s[] = param.split(" ");
		
		if(s.length > 2)
		{
			controller.save(s[1],s[2]);
		}
		else
		{
			controller.display("Missing parameters.");
		}
		
		
	}

}
