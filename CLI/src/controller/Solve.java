package controller;

public class Solve extends CommonCommand {

	public Solve(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String param) {
		
		String s[] = param.split(" ");
		
		if(s.length > 1)
		{
			controller.solve(s[0],s[1]);
		}
		else
		{
			controller.display("Missing parameters.");
		}
	}

}
