package main.com.entity.livingthing;

import main.com.entity.Entity;

public abstract class LivingThing extends Entity{

// Fields
	// int
		protected int caloricValue;
		protected int age;
		protected int lifeSpan;
	// boolean
		protected boolean alive;
//Constructors
	/**
	 * 
	 * 
	 * @param code
	 * @param caloricValue
	 */
	public LivingThing(String code, int caloricValue)
	{
		super(code);
		alive = true;
	}
	
// Methods
	/**
	 * 
	 */
	public int getCaloricValue()
	{
		return caloricValue;
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
	
	/**
	 * 
	 * @param amountToChange
	 */
	public void changeCaloric(int amountToChange)
	{
		caloricValue += amountToChange;
	}
	
	
}
