package main.com;

import java.util.ArrayList;

import main.com.ocean.Ocean;

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
	
	public void run()
	{
		running = true;
		while(running) {
			for(Ocean ocean : oceans) {
				ocean.turn();
			}
		}
	}
	
}
