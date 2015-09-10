package model;

public interface Model {

	void generate(String name, int x, int y, int z);

	void mazeDisplay(String param);

	void displayCrossSectionByX(int index, String name);

	void displayCrossSectionByY(int index, String name);
	
	void displayCrossSectionByZ(int index, String name);

	void save(String name, String fileName);

	void load(String fileName, String name);

	
}
