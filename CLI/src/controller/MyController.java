package controller;

import java.util.HashMap;

import model.Model;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class MyController.
 */
public class MyController extends CommonController {

	
	/** The command map. */
	private HashMap<String, Command> commandMap;
	
	/**
	 * Instantiates a new my controller.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public MyController(Model model , View view) {
		super(model,view);
		
		this.commandMap = new HashMap<String , Command>();
		commandMap.put("test", new TestCommand());
		commandMap.put("dir", new Dir(this));
		commandMap.put("generate", new Generate(this));
		commandMap.put("display", new Display(this));
		commandMap.put("save", new Save(this));
		commandMap.put("load", new Load(this));
		commandMap.put("maze", new Size(this));
		commandMap.put("file", new FileSize(this));
		commandMap.put("solve", new Solve(this));
		commandMap.put("exit", new Exit(this));

		view.setCommands(commandMap);
	}

	/* (non-Javadoc)
	 * @see controller.CommonController#generate(java.lang.String, int, int, int)
	 */
	@Override
	public void generate(String name, int x, int y, int z) {
		model.generate(name, x, y, z);
		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#displayCrossSectionByX(int, java.lang.String)
	 */
	@Override
	public void displayCrossSectionByX(int index, String name) {
		model.displayCrossSectionByY( index,  name);
		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#displayCrossSectionByY(int, java.lang.String)
	 */
	@Override
	public void displayCrossSectionByY(int index, String name) {
		model.displayCrossSectionByY( index,  name);
		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#displayCrossSectionByZ(int, java.lang.String)
	 */
	@Override
	public void displayCrossSectionByZ(int index, String name) {
		model.displayCrossSectionByY( index,  name);
		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#save(java.lang.String, java.lang.String)
	 */
	@Override
	public void save(String name, String fileName) {
		model.save(name,fileName);
		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#load(java.lang.String, java.lang.String)
	 */
	@Override
	public void load(String fileName, String name) {
		model.load(fileName,name);
		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#size(java.lang.String)
	 */
	@Override
	public void size(String name) {
		model.size(name);
		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#fileSize(java.lang.String)
	 */
	@Override
	public void fileSize(String name) {
		model.fileSize(name);
	}

	/* (non-Javadoc)
	 * @see controller.Controller#solve(java.lang.String, java.lang.String)
	 */
	@Override
	public void solve(String name, String algorithm) {
		model.solve(name , algorithm);
		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#displaySolution(java.lang.String)
	 */
	@Override
	public void displaySolution(String name) {
		model.displaySolution( name);
		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#exit()
	 */
	@Override
	public void exit() {
		model.exit();
		view.exit();
		
	}

	

}
