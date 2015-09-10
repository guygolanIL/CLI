package controller;


public class Display extends CommonCommand {

	
	
	public Display(Controller controller) {
		super(controller);
	}
	
	@Override
	public void doCommand(String name) {
		String[] s = name.split(" ");
		if ((s[0].equals("cross"))&&(s.length > 5))
		{
			try{
			switch (s[3])
			{
			case "x":
			case "X":
				controller.displayCrossSectionByX(Integer.parseInt(s[4]),s[6]);
				break;
			case "y":
			case "Y":
				controller.displayCrossSectionByY(Integer.parseInt(s[4]),s[6]);
				break;
			case "z":		
			case "Z":
				controller.displayCrossSectionByZ(Integer.parseInt(s[4]),s[6]);
				break;
			default:
				controller.display("Invalid parameter");
			}
			}catch (NumberFormatException e) {
				
				controller.display("Invalid parameters.");

			}
				 
		}
		else if ((s[0].equals("solution"))&&(s.length > 1))
		{
			controller.displaySolution(s[1]);
		}
		else
		controller.mazeDisplay(name);
	}

}
