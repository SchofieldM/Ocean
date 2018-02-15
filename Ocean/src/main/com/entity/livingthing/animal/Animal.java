package main.com.entity.livingthing.animal;

import main.com.entity.Entity;
import main.com.ocean.Ocean;
import main.com.utilities.RNG;
import main.com.entity.livingthing.LivingThing;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Animal extends LivingThing {

// Fields
	// ArrayList
		protected ArrayList<String> threats;
		protected ArrayList<String> food;
	// Ocean
		protected Ocean ocean;
	// Boolean
		protected boolean male;
		
	public Animal(String species, String code, int caloricValue, Ocean ocean, ArrayList<String> threats, ArrayList<String> food)
	{
		super(code, caloricValue);
		this.ocean = ocean;
		this.threats = threats;
		this.food = food;
	}	
	
	public void setOcean(Ocean ocean)
	{
		this.ocean = ocean;
	}
	
}
