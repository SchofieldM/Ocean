package main.com.oceanobj.livingthing.animal;

import main.com.oceanobj.livingthing.LivingThing;

import java.util.ArrayList;

public class Animal extends LivingThing {


	protected int hunger;
	protected int maxHunger;
	protected int speed;
	
	public Animal(int speed, int maxHunger, int lifeSpan, ArrayList<String> threats, ArrayList<String> food, String species)
	{
		super(lifeSpan, threats, food, species);
		hunger = 0;
		this.maxHunger = maxHunger;
	}
	
}
