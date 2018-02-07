package main.com.ocean;

import main.com.utilities.RNG;
import java.util.ArrayList;

import main.com.entity.Entity;


public class Ocean {

	private ArrayList<Entity>[][] layout;
	
	public Ocean(int dimensions, ArrayList<Entity> entities)
	{
		this.layout = new ArrayList[dimensions][dimensions];
		for(int y = 0; y < dimensions; y++) {
			for(int x = 0; x < dimensions; x++) {
				layout[y][x] = new ArrayList<Entity>();
			}
		}
		
		for(Entity e : entities) {
			layout[RNG.randomInt(0, dimensions)][RNG.randomInt(0, dimensions)].add(e);
		}
	}
	
	public ArrayList<Entity>[][] getLayout()
	{
		return layout;
	}
	
}
