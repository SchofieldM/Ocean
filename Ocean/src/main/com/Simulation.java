package main.com;

import java.util.ArrayList;
import java.util.Scanner;

import main.com.ocean.Ocean;
import main.com.entity.Entity;

/**
 * Simulation handler to simulate Oceans
 * 
 * @author Matthew Schofield
 * @version 2.14.17
 */
public class Simulation {

// Fields
	// ArrayList
		private ArrayList<Ocean> oceans;
	// Boolean
		private boolean running;
		
	public Simulation(ArrayList<Ocean> oceans)
	{
		this.oceans = oceans;
		running = false;
	}
	
	/**
	 * Prints to screen the current layout of the Oceans being simulated
	 */
	public void showOceans()
	{
		for(Ocean ocean : oceans) {
			Entity[][] layout = ocean.getLayout();
			for(int y = layout.length -1; y >= 0; y--) {
				for(int x = layout[y].length -1; x >= 0; x--) {
					Entity e = layout[y][x];
					if(e != null) {
						System.out.print(e.getCode());
					}else {
						System.out.print("    ");
					}
					System.out.print("|");
				}
				System.out.println();
			}			
		}
	}
	
	public void run()
	{
		showOceans();
		running = true;
		while(running) {
			for(Ocean ocean : oceans) {
				ocean.turn();
			}
			showOceans();
			(new Scanner(System.in)).nextLine();
		}
	}
	
}
