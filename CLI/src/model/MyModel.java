package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.MazeDomain;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

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
			try {
				MyCompressorOutputStream tmpCompressor = new MyCompressorOutputStream(new FileOutputStream(fileName));
				tmpCompressor.write(tmpMaze.toByteArray());
				tmpCompressor.close();
				controller.display(name + " maze saved to " + fileName + ".");
			} catch (FileNotFoundException e) {
				controller.display("wrong file path");
			} catch (IOException e)
			{
				controller.display("general error");
			}
		}
		else
		{
			controller.display("Unavailable maze!");
		}				
	}

	@Override
	public void load(String fileName, String name) {
			try {
				MyDecompressorInputStream tmpDecompressor = new MyDecompressorInputStream(new FileInputStream(fileName));
				byte [] b = new byte [tmpDecompressor.available()];
				tmpDecompressor.read(b);
				Maze3d  tmpMaze = new Maze3d(b);
				mazeMap.put(name, tmpMaze);
				controller.display(name + " maze loaded.");
				tmpDecompressor.close();
			} catch (FileNotFoundException e) {
				controller.display("wrong file path");
			} catch (IOException e)
			{
				controller.display("general error");
			}
	}

	@Override
	public void size(String name) {
		
		
		Maze3d tempMaze = mazeMap.get(name);
		if(tempMaze!=null)
		{
			controller.display("the size of " + name  + " maze in the memory is: "+(tempMaze.getxAxis()* tempMaze.getyAxis()*tempMaze.getzAxis()+9)+".");
		}
		else
		{
			controller.display(name+" is Unavailable!");
		}
		
	}

	@Override
	public void fileSize(String name) {
		Maze3d  tmpMaze = mazeMap.get(name);
		
		if(tmpMaze != null)
		{
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			MyCompressorOutputStream compress = new MyCompressorOutputStream(buffer);
			try {
				compress.write(tmpMaze.toByteArray());
				controller.display("the size of " + name + " maze in file is: " + buffer.size());
			} catch (IOException e) {
				controller.display("general error");
			}
		}
		else
		{
			controller.display("Unavailable maze!");
		}						
	}

	@Override
	public void solve(String name, String algorithm) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				Maze3d tmpMaze = mazeMap.get(name);
				if(tmpMaze!=null)
				{
					Searcher<Position> alg;
					switch(algorithm)
					{
					case "BFS":
							alg = new BFS<Position>();
						break;
					case "AstarManhattan":
						alg = new BFS<Position>();
						break;
					case "AstarAirDistance":
						alg = new BFS<Position>();
						break;
						
						default :
							controller.display(algorithm+" is not a valid algorithm! \nValid algorithms are : <BFS>, <AstarManhattan>, <AstarAirDistance>.");
							return;
					}
					solutionMap.put(name,alg.search(new MazeDomain(tmpMaze)));
					controller.display("solution for " +name+ " is ready");
				}
				else
				{
					controller.display(name+ " maze is unavailable!");
				}
				
							
			}
		}).start();
	}

	@Override
	public void displaySolution(String name) {
		Solution<Position>  tmp = solutionMap.get(name);
		
		if(tmp != null)
		{
			controller.display("the solution of " +name+ " maze is:\n" +(tmp.toString()));	
		}
		else
		{
			controller.display("Unavailable solution!");
		}
	

		
	}
}
