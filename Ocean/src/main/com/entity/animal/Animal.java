package main.com.entity.animal;

import main.com.entity.Entity;
import main.com.ocean.Ocean;
import main.com.utilities.RNG;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Animal extends Entity {

// Fields
	// String
		protected String moveChoice;
	// ArrayList
		protected ArrayList<String> threats;
		protected ArrayList<String> food;
	// HashMap
		protected HashMap<String, Integer> moveIndices;
	// Ocean
		protected Ocean ocean;
		
	public Animal(String species, String code, Ocean ocean, ArrayList<String> threats, ArrayList<String> food)
	{
		super(code);
		this.ocean = ocean;
		this.threats = threats;
		this.food = food;
		this.moveIndices = new HashMap<>();
		this.moveChoice = "UP";
	}	
	
	public void indexMoves()
	{
		ArrayList<Entity>[][] layout = ocean.getLayout();
		moveIndices.put("UP", threatsAbove(layout));
		moveIndices.put("LEFT", threatsLeft(layout));
		moveIndices.put("DOWN", threatsBelow(layout));
		moveIndices.put("RIGHT", threatsRight(layout));
	}
	
	public void setOcean(Ocean ocean)
	{
		this.ocean = ocean;
	}
	
	@Override
	public void clearDirection()
	{
		moveChoice = "";
	}
	
	@Override
	public String getDirection()
	{
		return moveChoice;
	}
	
	@Override
	public void turn()
	{
		indexMoves();
		makeMoveChoice();
	}
	
	private int threatsBelow(ArrayList<Entity>[][] layout)
	{
		return 10;
	}
	
	private int threatsRight(ArrayList<Entity>[][] layout)
	{
		return -1;
	}
	
	private int threatsAbove(ArrayList<Entity>[][] layout)
	{
		return -1;
	}
	
	private int threatsLeft(ArrayList<Entity>[][] layout)
	{
		return -1;
	}
	
	private void makeMoveChoice()
	{
		moveChoice = "";
		if(moveIndices.get("UP") > moveIndices.get("DOWN"))
		{
			moveChoice += "UP";
		}else if(moveIndices.get("UP") < moveIndices.get("DOWN"))
		{
			moveChoice += "DOWN";
		}
		
		if(moveIndices.get("LEFT") > moveIndices.get("RIGHT"))
		{
			moveChoice += "LEFT";
		}else if(moveIndices.get("LEFT") < moveIndices.get("RIGHT"))
		{
			moveChoice += "RIGHT";
		}
		
		if(moveChoice.isEmpty()) {
			switch(RNG.randomInt(0, 3)) {
			case 0:
				moveChoice = "UP";
				break;
			case 1:
				moveChoice = "DOWN";
				break;
			case 2:
				moveChoice = "LEFT";
				break;
			case 3:
				moveChoice = "RIGHT";
				break;
			}
		}
		
	}
	
}
