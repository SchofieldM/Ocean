package main.com;

import java.util.ArrayList;
import java.util.Scanner;

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
			ArrayList<Entity>[][] layout = ocean.getLayout();
			for(int y = layout.length -1; y >= 0; y--) {
				for(int x = layout[y].length -1; x >= 0; x--) {
					for(Entity e : layout[y][x]) {
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
