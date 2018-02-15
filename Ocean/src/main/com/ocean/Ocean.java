package main.com.ocean;

import main.com.utilities.RNG;
import java.util.ArrayList;
import java.util.Iterator;

import main.com.entity.livingthing.animal.Animal;
import main.com.entity.Entity;

/**
 * An Ocean which to simulate
 * 
 * @author Matthew Schofield
 * @version 2.14.18
 */
public class Ocean {

// Fields
	// Entity[][]
		private Entity[][] layout;
	// ArrayList
		private ArrayList<Entity> entities;
	// int
		private int turnNumber;
		private int everyThisTurnPrint;
		
// Constructor
	/**
	 * Creates an Ocean
	 * 
	 * @param dimensions, creates the layout with dimensions of: dimensions x dimensions
	 * @param entities, entities to start in the Ocean
	 */
	public Ocean(int dimensions, ArrayList<Entity> entities)
	{
		this.layout = new Entity[dimensions][dimensions];
		this.entities = entities;
		this.turnNumber = 0;
		this.everyThisTurnPrint = 1;
		
		// Disperses the entities into the Ocean
		for(Entity e : entities) {
			int x = RNG.randomInt(0, dimensions);
			int y = RNG.randomInt(0, dimensions);
			layout[y][x] = e;
			e.setOcean(this);
			e.setCoords(new int[] {x,y});
		}
	}
	
// Methods
	// ArrayList<Entity>
	/**
	 * Accessor method for the entities within the Ocean
	 * 
	 * @return The entities within the Ocean
	 */
	public ArrayList<Entity> getEntities()
	{
		return entities;
	}
	
	// Entity[][]
	/**
	 * Accessor method for the layout of the Ocean
	 * 
	 * @return, the layout of the Ocean
	 */
	public Entity[][] getLayout()
	{
		return layout;
	}
	
	// int
	/**
	 * Accessor method for the turn number
	 * 
	 * @return the turn number
	 */
	public int getTurnNumber()
	{
		return turnNumber;
	}
	
	
	// boolean
	/**
	 * Moves a unit if it is a valid move
	 * 
	 * @return, true: valid move, false: invalid move
	 */
	public boolean moveCell(int curX, int curY, int newX, int newY)
	{
		try {
			layout[newY][newX] = layout[curY][curX];
			layout[curY][curX] = null;
			return true;
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
	}
	
	/**
	 * Has the Ocean process a turn
	 */
	public boolean turn()
	{
		for(Entity entity : entities) {
			entity.turn();
		}
		if(turnNumber % everyThisTurnPrint == 0) {
			return true;
		}
		turnNumber++;
		return false;
	}
}
