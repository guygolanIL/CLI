package controller;

/**
 * Defines what every Controller type must implement.
 * @author Guy Golan & Amit Sandak
 *
 */
public interface Controller {

	/**
	 * Displaying the given string using the View.
	 * @param string
	 */
	public void display(String string);
	/**
	 * Displaying the Strings using the View.
	 * @param strings
	 */
	public void display(String[] strings);
	/**
	 * Displaying the maze3d using its name.
	 * @param name - the maze's name.
	 */
	public void mazeDisplay(String name);
	/**
	 * Generating a new 3d maze using the Model & View.
	 * @param name - the maze's name.
	 * @param x - its X dimension.
	 * @param y	- its Y dimension.
	 * @param z - its Z dimension.
	 */
	public void generate(String name ,int x , int y , int z);
	/**
	 * Displaying a plain of the maze according to X.
	 * @param index - which X index to be displayed.
	 * @param name - the maze's name.
	 */
	public void displayCrossSectionByX(int index,String name);
	/**
	 * Displaying a plain of the maze according to Y.
	 * @param index - which Y index to be displayed.
	 * @param name - the maze's name.
	 */
	public void displayCrossSectionByY(int index,String name);
	/**
	 * Displaying a plain of the maze according to Z.
	 * @param index - which Z index to be displayed.
	 * @param name - the maze's name.
	 */
	public void displayCrossSectionByZ(int index,String name);
	/**
	 * Saves a Maze3d to a file.
	 * (the method uses MyCompressorOutputStream)
	 * @param name - the name of the desired saveable maze.
	 * @param fileName - a new file to save the Maze3d to.
	 */
	public void save(String name, String fileName);
	/**
	 * Loading data from a file using MyDecompressorInputStream and 
	 * creates a Maze3d accordingly.
	 * @param fileName - the source file to read the data from.
	 * @param name - the desired name for the loaded Maze3d.
	 */
	public void load(String fileName, String name);
	/**
	 *Checks the size (in memory) for a given Maze3d's name.
	 * @param name - name of the Maze3d.
	 */
	public void size(String name);
	/**
	 * Using a MyCompressorOutputStream to determine a Maze3d size in a file.
	 * @param name - the Maze3d's name. 
	 */
	public void fileSize(String name);
	/**
	 * Solving a Searchable problem.
	 * @param name - the Maze3d's name.
	 * @param algorithm - the algorithm's name to solve the Maze3d by.
	 */
	public void solve(String name, String algorithm);
	/**
	 * Displaying the Solution using the Model & View.
	 * @param name - the Maze3d's name.
	 */
	public void displaySolution(String name);
	/**
	 * Safely exits the program.
	 */
	public void exit();
	
}
