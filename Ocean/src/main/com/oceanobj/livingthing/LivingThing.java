package main.com.oceanobj.livingthing;

import java.util.ArrayList;
import main.com.oceanobj.OceanObj;
import main.com.ocean.*;
public abstract class LivingThing extends OceanObj{

	protected ArrayList<String> threats;
	protected ArrayList<String> food;
	protected String species;
	protected int age;
	protected int lifeSpan;
	
	public LivingThing(Ocean ocean, int lifeSpan, ArrayList<String> threats, ArrayList<String> food, String species, String code)
	{
		super(code, ocean);
		this.species = species;
		this.threats = threats;
		this.food = food;
		this.age = 0;
		this.lifeSpan = lifeSpan;
	}
	
}
