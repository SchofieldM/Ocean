package main.com.entity.livingthing.animal.fish;

import java.util.HashMap;

import main.com.ocean.Ocean;

/**
 * A Shark, an apex predator inherits from Fish
 * 
 * @author Matthew Schofield
 * @version 2.16.18
 */
public class Shark extends Fish {

	public Shark(Ocean ocean)
	{
		super("SHRK", 20, 100, ocean);
		
	}
	
	public Shark(Ocean ocean, HashMap<String, Integer> interestInOthers)
	{
		super("Shrk", 20, 100, ocean, interestInOthers);
	}
	
	public void turn() {}
}
