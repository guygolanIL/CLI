package controller;

import java.io.File;

/**
 * Defines what the Command Dir should do.
 * @author Guy Golan & Amit Sandak
 *
 */
public class Dir extends CommonCommand{

	public Dir(	Controller controller) {		//Ctor
		super(controller);
	}
	
	/**
	 * Using type File to display the files in the path given
	 * @param param - the file path.
	 */
	@Override
	public void doCommand(String param) {

		if(param != null)
		{
			controller.display(new File(param).list());
		}
		else
		{
			controller.display("Missing parameters");
		}
		
	}

}
