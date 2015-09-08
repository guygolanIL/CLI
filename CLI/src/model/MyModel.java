package model;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class MyModel extends CommonModel {


	public MyModel() {
		super();
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

	@Override
	public void displayCrossSectionByX(int index, String name) {
		Maze3d  tmpMaze = mazeMap.get(name);
		
		if(tmpMaze != null)
		{
			controller.display(arrIntToString(tmpMaze.getCrossSectionByX(index)));	
		}
		else
		{
			controller.display("Unavailable maze!");
		}		
	}


	@Override
	public void displayCrossSectionByY(int index, String name) {
		Maze3d  tmpMaze = mazeMap.get(name);
		
		if(tmpMaze != null)
		{
			controller.display(arrIntToString(tmpMaze.getCrossSectionByY(index)));	
		}
		else
		{
			controller.display("Unavailable maze!");
		}		
		
	}

	@Override
	public void displayCrossSectionByZ(int index, String name) {
		Maze3d  tmpMaze = mazeMap.get(name);
		
		if(tmpMaze != null)
		{
			controller.display(arrIntToString(tmpMaze.getCrossSectionByZ(index)));	
		}
		else
		{
			controller.display("Unavailable maze!");
		}		
		
	}
	
	private String arrIntToString(int[][] arr) {
		String s = "";
		
		for (int[] i : arr)
		{
			for(int j : i)
			{
				s = s + j + " ";
				
			}
			s = s+ "\n";
		}
		
		return s;
	}

	@Override
	public void save(String name, String fileName) {
		Maze3d  tmpMaze = mazeMap.get(name);
		
		if(tmpMaze != null)
		{
			
			//TODO //////////////////////////////////
				
		}
		else
		{
			controller.display("Unavailable maze!");
		}				
	}

}
