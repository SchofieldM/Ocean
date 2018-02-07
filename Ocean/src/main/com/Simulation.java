package main.com;

import java.util.ArrayList;

import main.com.ocean.Ocean;
import main.com.entity.Entity;

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
	
	public void showOceans()
	{
		for(Ocean ocean : oceans) {
			for(ArrayList<Entity>[] layer : ocean.getLayout()) {
				for(ArrayList<Entity> cell : layer) {
					for(Entity e : cell) {
						System.out.print(e.getCode() + " ");
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
		/**
		 * 
		running = true;
		while(running) {
			for(Ocean ocean : oceans) {
				ocean.turn();
			}
		}
		*/
	}
	
}
