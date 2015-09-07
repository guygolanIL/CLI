package model;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import controller.Controller;

public class MyModel implements Model {

	private Controller controller;
	private HashMap<String, Maze3d> mazeMap;
	
	public MyModel() {
		mazeMap = new HashMap<String, Maze3d>();
	}
	
	
	
	public Controller getController(){
		return controller;
	}



	public void setController(Controller controller) {
		this.controller = controller;
	}



	@Override
	public void generate(String name, int x, int y, int z) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Maze3d maze = new MyMaze3dGenerator().generate(x, y, z);
				mazeMap.put(name, maze);
				controller.display("The "+name+" maze is ready.");
			}
		}).start();
		
	}



	@Override
	public void mazeDisplay(String name) {
		Maze3d  temp = mazeMap.get(name);
		
		if(temp != null)
		{
			controller.display(name+ "\n" +temp.toString());	
		}
		else
		{
			controller.display("Unavailable maze!");
		}
	}

}
