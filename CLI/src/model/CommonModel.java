package model;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Controller;

public abstract class CommonModel implements Model {

	protected Controller controller;
	protected HashMap<String, Maze3d> mazeMap;
	
	
	public CommonModel() {
		mazeMap = new HashMap<String, Maze3d>();
	}
	
	public abstract void generate(String name, int x, int y, int z);
	public abstract void mazeDisplay(String name);
	
	public Controller getController() {
		return controller;
	}
	public HashMap<String, Maze3d> getMazeMap() {
		return mazeMap;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public void setMazeMap(HashMap<String, Maze3d> mazeMap) {
		this.mazeMap = mazeMap;
	}
}
