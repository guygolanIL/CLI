package controller;

public class TestCommand implements Command {

	@Override
	public void doCommand(String param) {
		System.out.println("tested");

	}

}
