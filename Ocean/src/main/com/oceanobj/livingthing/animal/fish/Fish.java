package main.com.oceanobj.livingthing.animal.fish;

import java.util.ArrayList;

import main.com.oceanobj.livingthing.animal.Animal;

import main.com.ocean.*;

public abstract class Fish extends Animal{

// Fields
	// String
		protected String species;
	// int
		protected int speed;
	
	public Fish(Ocean ocean, String species, int maxHunger, int speed, int lifeSpan, String code)
	{
		super(ocean, speed, maxHunger, lifeSpan, new ArrayList<String>(), new ArrayList<String>(), species, code);
	}

}
