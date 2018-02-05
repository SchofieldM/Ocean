package main.com.oceanobj.livingthing.animal;


import main.com.oceanobj.livingthing.LivingThing;
import java.util.ArrayList;
import main.com.ocean.Ocean;


/**
 * Animal OceanObj, eats and moves
 * 
 * @author Matthew Schofield
 * @version 2.4.18
 */
public abstract class Animal extends LivingThing {

// Fields
	// int
		protected int hunger;
		protected int maxHunger;
		protected int speed;
	
// Constructors
	public Animal(Ocean ocean, int speed, int maxHunger, int lifeSpan, ArrayList<String> threats, ArrayList<String> food, String species, String code)
	{
		super(ocean, lifeSpan, threats, food, species, code);
		hunger = 0;
		this.maxHunger = maxHunger;
	}
	
}
