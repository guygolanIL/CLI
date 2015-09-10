package controller;

public class FileSize extends CommonCommand {

	public FileSize(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String name) {

		String s[] = name.split(" ");
		
		if(s.length > 1)
		{
			controller.fileSize(s[1]);
		}
		else
		{
			controller.display("Missing parameters.");
		}

	}

	

}
