package main.com.entity.livingthing.animal.fish;

import main.com.entity.livingthing.animal.fish.Fish;
import main.com.ocean.Ocean;

import java.util.HashMap;

/**
 * A Tuna
 * 
 * @author Matthew Schofield
 * @version 2.16.18
 */
public class Tuna extends Fish {

	/**
	 * A Tuna
	 * 
	 * @param ocean, the ocean the Tuna is in
	 */
	public Tuna(Ocean ocean)
	{
		super("TUNA", 10, 100, ocean);
		interestInOthers = new HashMap<>();
		interestInOthers.put("TUNA", 10);
		interestInOthers.put("SHRK", -100);
	}
	
	/**
	 * A Tuna
	 * 
	 * @param ocean, the ocean the Tuna is in
	 * @param interestInOthers, the point values
	 */
	public Tuna(Ocean ocean, HashMap<String, Integer> interestInOthers)
	{
		super("TUNA", 10, 100, ocean, interestInOthers);
	}
	
	
}
