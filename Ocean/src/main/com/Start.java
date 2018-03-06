package main.com;

import java.util.ArrayList;

import main.com.entity.Entity;
import main.com.entity.livingthing.animal.fish.Shark;
import main.com.entity.livingthing.animal.fish.Tuna;
import main.com.ocean.Ocean;

/**
 * Entrance point for the project
 * 
 *@author Matthew Schofield
 *@version 2.19.18
 */
public class Start {

	/**
	 * Entrance point of the program
	 * 
	 * @param args, (for now) unused
	 */
	public static void main(String[] args)
	{
		// Starting entities
		ArrayList<Entity> pacificStartingEntities = new ArrayList<>();

		pacificStartingEntities = addTuna(10, pacificStartingEntities);
		pacificStartingEntities = addSharks(3, pacificStartingEntities);
		
		// Initialization of Oceans
		Ocean pacific = new Ocean(10, pacificStartingEntities);
		
		// Adds Oceans into an ArrayList
		ArrayList<Ocean> oceans = new ArrayList<>();
		oceans.add(pacific);
		
		// Initializes and runs the simulation
		Simulation sim = new Simulation(oceans,1);
		sim.run();
	}
	
	public static ArrayList<Entity> addTuna(int numberOfTuna, ArrayList<Entity> list)
	{
		for(int i = 0; i < numberOfTuna; i++) {
			list.add(new Tuna(null));
		}
		return list;		
	}
	
	public static ArrayList<Entity> addSharks(int numberOfSharks, ArrayList<Entity> list)
	{
		for(int i = 0; i < numberOfSharks; i++) {
			list.add(new Shark(null));
		}
		return list;		
	}
	
}
