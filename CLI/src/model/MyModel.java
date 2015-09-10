package model;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
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
Maze3d  tmpMaze = mazeMap.get(name);

			try {
				FileInputStream file = new FileInputStream(fileName);
				MyDecompressorInputStream tmpDecompressor = new MyDecompressorInputStream(file);
				byte [] b = new byte [file.available()];
				tmpDecompressor.read(b);
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

}
