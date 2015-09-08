package controller;

public class Generate extends CommonCommand {

	public Generate(Controller controller) {
		super(controller);
	}
	
	
	@Override
	public void doCommand(String param) {
		String[] s = param.split(" ");
		if(s[0].equals("3d") && s[1].equals("maze") && s.length > 5)
		{
			try {
				controller.generate(s[2],Integer.parseInt(s[3]),Integer.parseInt(s[4]),Integer.parseInt(s[5]));
			} catch (NumberFormatException e) {
				
				controller.display("Invalid parameters.");
			}
		}
		else
		{
			controller.display("Missing parameters.");
		}
		

	}

}
