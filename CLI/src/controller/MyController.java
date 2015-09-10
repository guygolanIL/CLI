package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public class MyController extends CommonController {

	
	private HashMap<String, Command> commandMap;
	
	public MyController(Model model , View view) {
		super(model,view);
		
		this.commandMap = new HashMap<String , Command>();
		commandMap.put("test", new TestCommand());
		commandMap.put("dir", new Dir(this));
		commandMap.put("generate", new Generate(this));
		commandMap.put("display", new Display(this));
		commandMap.put("save", new Save(this));
		
		view.setCommands(commandMap);
	}

	@Override
	public void generate(String name, int x, int y, int z) {
		model.generate(name, x, y, z);
		
	}

	@Override
	public void displayCrossSectionByX(int index, String name) {
		model.displayCrossSectionByY( index,  name);
		
	}

	@Override
	public void displayCrossSectionByY(int index, String name) {
		model.displayCrossSectionByY( index,  name);
		
	}

	@Override
	public void displayCrossSectionByZ(int index, String name) {
		model.displayCrossSectionByY( index,  name);
		
	}

	@Override
	public void save(String name, String fileName) {
		model.save(name,fileName);
		
	}

	@Override
	public void load(String fileName, String name) {
		model.load(fileName,name);
		
	}

	

}
