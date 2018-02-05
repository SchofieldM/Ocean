package main.com.oceanobj.livingthing.animal.fish;

import java.util.ArrayList;

import main.com.ocean.Ocean;

public class Tuna extends Fish{
	
	public Tuna(Ocean ocean)
	{
		super(ocean, "Tuna", 100, 1, 100, "Tuna");
		threats.add("Shrk");
		
	}
	
	@Override
	public void makeDirectionChoice()
	{
		setDirection("");
	}

}
