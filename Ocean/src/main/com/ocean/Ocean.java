package main.com.ocean;

import main.com.utilities.RNG;
import java.util.ArrayList;
import java.util.Iterator;

import main.com.entity.livingthing.animal.Animal;
import main.com.entity.Entity;


public class Ocean {

	private Entity[][] layout;
	
	private int dimensions;
	
	public Ocean(int dimensions, ArrayList<Entity> entities)
	{
		this.dimensions = dimensions;
		this.layout = new Entity[dimensions][dimensions];
		
		for(Entity e : entities) {
			int x = RNG.randomInt(0, dimensions);
			int y = RNG.randomInt(0, dimensions);
			layout[y][x] = e;
			e.setOcean(this);
			e.setCoords(new int[] {x,y});
		}
	}
	
	public Entity[][] getLayout()
	{
		return layout;
	}
	
	public void turn()
	{
		for(int y = 0; y < dimensions; y++) {
			for(int x = 0; x < dimensions; x++) {
				if(layout[y][x] != null) {
					layout[y][x].turn();
				}
			}
		}
	}
	
}
