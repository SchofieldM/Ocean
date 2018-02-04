package main.com.oceanobj.livingthing.animal.fish;

import java.util.ArrayList;

import main.com.oceanobj.livingthing.animal.Animal;

public abstract class Fish extends Animal{

// Fields
	// String
		protected String species;
	// int
		protected int speed;
	
	public Fish(String species, ArrayList<String> threats, ArrayList<String> food, int maxHunger, int speed, int lifeSpan)
	{
		super(speed, maxHunger, lifeSpan, threats, food, species);
	}

}
