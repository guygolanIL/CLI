package controller;

import model.Model;
import view.View;

public abstract class CommonController implements Controller {


	protected Model model;
	protected View view;
	
	public CommonController(Model model , View view) {
		this.model = model;
		this.view = view;
	}
	
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}


	public View getView() {
		return view;
	}


	public void setView(View view) {
		this.view = view;
	}

	
	@Override
	public void display(String string) {
		view.display(string);
	}
	
	@Override
	public void display(String[] strings)
	{
		view.display(strings);
	}
	
	@Override
	public void mazeDisplay(String name) {
		model.mazeDisplay(name);
		
	}
	
	@Override
	public abstract void generate(String name ,int x , int y , int z);
	
	
	
}

