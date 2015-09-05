package model;

import controller.Controller;

public class MyModel implements Model {

	private Controller controller;
	
	public MyModel() {
		
	}
	
	
	
	public Controller getController(){
		return controller;
	}



	public void setController(Controller controller) {
		this.controller = controller;
	}

}
