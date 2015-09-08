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
		view.setCommands(commandMap);
	}

	@Override
	public void generate(String name, int x, int y, int z) {
		model.generate(name, x, y, z);
		
	}

	

}
