package main.com;

import java.util.ArrayList;

import main.com.entity.Entity;
import main.com.entity.livingthing.animal.fish.Tuna;
import main.com.ocean.Ocean;

/**
 * Entrance point for the project
 * 
 *@author Matthew Schofield
 *@version 2.18.18
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
		pacificStartingEntities.add(new Tuna());
		
		// Initialization of Oceans
		Ocean pacific = new Ocean(Interget.parseString(args[0]), pacificStartingEntities);
		
		// Adds Oceans into an ArrayList
		ArrayList<Ocean> oceans = new ArrayList<>();
		oceans.add(pacific);
		
		// Initializes and runs the simulation
		Simulation sim = new Simulation(oceans);
		sim.run();
	}
	
}
