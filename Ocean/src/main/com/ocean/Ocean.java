package main.com.ocean;

import java.util.ArrayList;

import main.com.entity.Entity;

public class Ocean {

	private ArrayList<Entity>[][] layout;
	
	public Ocean(int dimensions)
	{
		this.layout = new ArrayList[dimensions][dimensions];
	}
	
}
