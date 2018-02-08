package main.com.ocean;

import main.com.utilities.RNG;
import java.util.ArrayList;
import java.util.Iterator;

import main.com.entity.animal.Animal;
import main.com.entity.Entity;


public class Ocean {

	private ArrayList<Entity>[][] layout;
	
	private int dimensions;
	
	public Ocean(int dimensions, ArrayList<Entity> entities)
	{
		this.dimensions = dimensions;
		this.layout = new ArrayList[dimensions][dimensions];
		for(int y = 0; y < dimensions; y++) {
			for(int x = 0; x < dimensions; x++) {
				layout[y][x] = new ArrayList<Entity>();
			}
		}
		
		for(Entity e : entities) {
			int x = RNG.randomInt(0, dimensions);
			int y = RNG.randomInt(0, dimensions);
			layout[y][x].add(e);
			e.setOcean(this);
			e.setCoords(new int[] {x,y});
		}
	}
	
	public ArrayList<Entity>[][] getLayout()
	{
		return layout;
	}
	
	public void turn()
	{
		for(int y = 0; y < dimensions; y++) {
			for(int x = 0; x < dimensions; x++) {
				for(Entity e : layout[y][x]) {
					e.turn();
				}
			}
		}
		for(int y = 0; y < dimensions; y++) {
			for(int x = 0; x < dimensions; x++) {
				Iterator<Entity> iter = layout[y][x].iterator(); 
				while(iter.hasNext()) {
					Entity e = iter.next();
					switch(e.getDirection()) {
						case "UP":
							iter.remove();
							layout[y+1][x].add(e);
							e.setCoords(new int[] {x,y+1});
							e.clearDirection();
							break;
						case "DOWN":
							iter.remove();
							layout[y-1][x].add(e);
							e.setCoords(new int[] {x,y-1});
							e.clearDirection();
							break;
						case "LEFT":
							iter.remove();
							layout[y][x-1].add(e);
							e.setCoords(new int[] {x-1,y});
							e.clearDirection();
							break;
						case "RIGHT":
							iter.remove();
							layout[y][x+1].add(e);
							e.setCoords(new int[] {x+1,y});
							e.clearDirection();
							break;	
						
					}	
				}
			}
		}
	}
	
}
