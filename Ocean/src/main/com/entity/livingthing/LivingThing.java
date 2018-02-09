package main.com.entity.livingthing;

import main.com.entity.Entity;

public abstract class LivingThing extends Entity{

// Fields
	// int
		protected int caloricValue;
	
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
	 * @param amountToChange
	 */
	public void changeCaloric(int amountToChange)
	{
		caloricValue += amountToChange;
	}
	
	
}
