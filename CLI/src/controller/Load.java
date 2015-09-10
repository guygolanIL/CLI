package controller;

public class Load extends CommonCommand {

	public Load(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String param) {
		String s[] = param.split(" ");
		
		if(s.length > 2)
		{
			controller.load(s[1],s[2]);
		}
		else
		{
			controller.display("Missing parameters.");
		}

	}

}
