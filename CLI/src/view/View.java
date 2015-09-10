package view;

import java.util.HashMap;

import controller.Command;

public interface View {

	void start();
	void display(String string);
	void display(String[] strings);
	void setCommands(HashMap<String, Command> commandMap);
	void exit();

}
