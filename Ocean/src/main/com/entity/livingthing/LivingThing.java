package main.com.entity.livingthing;

import main.com.entity.Entity;
import main.com.ocean.Ocean;

public abstract class LivingThing extends Entity{

// Fields
	// int
		protected int size;
		protected int caloricValuePerSize;
		protected int age;
		protected int lifeSpan;
		protected int health;
	// boolean
		protected boolean alive;
		
//Constructors
	/**
	 * 
	 * 
	 * @param code
	 * @param caloricValue
	 */
	public LivingThing(String code, int caloricValue, Ocean ocean)
	{
		super(code, ocean);
		alive = true;
		health = 80;
	}
	
// Methods
	/**
	 * 
	 */
	public int getCaloricValuePerSize()
	{
		return caloricValuePerSize * size;
	}
	
	/**
	 * 
	 */
	public boolean isAlive()
	{
		return alive;
	}
	
	
	
	/**
	 * 
	 */
	public void die()
	{
		alive = false;
	}
	
	
	
	
	
}
