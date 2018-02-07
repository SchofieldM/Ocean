package main.com;

import java.util.ArrayList;

import main.com.ocean.Ocean;

/**
 * Entrance point for the project
 * 
 *@author Matthew Schofield
 *@version 2.6.18
 */
public class Start {

	/**
	 * Entrance point of the program
	 * 
	 * @param args, (for now) unused
	 */
	public static void main(String[] args)
	{
		// Initialization of Oceans
		Ocean pacific = new Ocean();
		
		// Adds Oceans into an ArrayList
		ArrayList<Ocean> oceans = new ArrayList<>();
		oceans.add(pacific);
		
		// Initializes and runs the simulation
		Simulation sim = new Simulation(oceans);
		sim.run();
	}
	
}
