package view;

import java.util.HashMap;

import controller.Command;

public interface View {

	void start();
	void display();
	void setCommands(HashMap<String, Command> commandMap);

}
