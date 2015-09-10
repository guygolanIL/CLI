package model;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Controller;

public abstract class CommonModel implements Model {

	protected Controller controller;
	protected HashMap<String, Maze3d> mazeMap;
	protected HashMap<String, Solution<Position>> solutionMap;
	
	
	public CommonModel() {
		mazeMap = new HashMap<String, Maze3d>();
		solutionMap = new HashMap<String, Solution<Position>>();
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
