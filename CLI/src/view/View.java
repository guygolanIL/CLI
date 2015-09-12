package view;

import java.util.HashMap;

import controller.Command;

/**
 * Defines what every View can do.
 * @author Guy Golan & Amit Sandak
 *
 */
public interface View {

	/**
	 * Starting the user interface.
	 */
	void start();
	/**
	 * Displaying a string to the output.
	 * @param string
	 */
	void display(String string);
	/**
	 * Displaying strings to the output.
	 * @param string
	 */
	void display(String[] strings);
	/**
	 * Setting the commands map.
	 * @param commandMap - a HashMap containing every Command the Controller stated.
	 */
	void setCommands(HashMap<String, Command> commandMap);
	/**
	 * Safely exits and closing resources.
	 */
	void exit();

}
