package main.com.entity.livingthing.animal;

import main.com.Simulation;
import main.com.entity.Entity;
import main.com.ocean.Ocean;
import main.com.utilities.RNG;
import main.com.entity.livingthing.LivingThing;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Animal extends LivingThing {

// Fields
	// ArrayList
		protected HashMap<String, Integer> interestInOthers;
	// Boolean
		protected boolean male;
	// int
		protected int stomachCapacity;
		protected int amountInStomach;
	//String
		protected String moveChoice;
	// HashMap
		protected HashMap<String, Integer> pointsToEachMove;
		
	public Animal(String code, int caloricValue, Ocean ocean, HashMap<String, Integer> interestInOthers)
	{
		super(code, caloricValue, ocean);
		this.interestInOthers = interestInOthers;
		initializeMoveFields();
		stomachCapacity = 1000;
	}	
	
	public Animal(String code, int caloricValue, Ocean ocean)
	{
		super(code, caloricValue, ocean);
		this.interestInOthers = new HashMap<>();
		for(String speciesCode : Simulation.ALLSPECIESCODES) {
			interestInOthers.put(speciesCode, 0);
		}
		initializeMoveFields();
		stomachCapacity = 1000;
	}	
	
	public void turn()
		{
		requestMove();	
	}
	
	public void requestMove()
	{
		String move = decideMove();
		int newX = coords[0];
		int newY = coords[1];
		if(move.contains("UP")) {
			newY++;
		}else if(move.contains("DOWN")) {
			newY--;
		}
		if(move.contains("RIGHT")) {
			newX++;
		}else if(move.contains("LEFT")) {
			newX--;
		}		
		ocean.moveCell(coords[0], coords[1], newX, newY);
	}
	
	public void eat(LivingThing toEat)
	{
		amountInStomach += toEat.getCaloricValuePerSize();
		if(amountInStomach > stomachCapacity) {
			amountInStomach = stomachCapacity;
		}	
	}
	
	public void initializeMoveFields()
	{
		moveChoice = "";
		pointsToEachMove = new HashMap<>();
		resetPointsToEachMove();
	}
	
	public void resetPointsToEachMove()
	{
		pointsToEachMove.put("UP", 0);
		pointsToEachMove.put("DOWN", 0);
		pointsToEachMove.put("LEFT", 0);
		pointsToEachMove.put("RIGHT", 0);
		pointsToEachMove.put("UPRIGHT", 0);
		pointsToEachMove.put("DOWNRIGHT", 0);
		pointsToEachMove.put("UPLEFT", 0);
		pointsToEachMove.put("DOWNLEFT", 0);
	}
	
	public void calculateMoveValues()
	{
		// Directly above
		Entity cell = ocean.getLayout()[coords[1] + 3][coords[0]]; 
		if(cell != null) {
			pointsToEachMove.put("UP", pointsToEachMove.get("UP") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPRIGHT", pointsToEachMove.get("UPRIGHT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPLEFT", pointsToEachMove.get("UPLEFT") + 5 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] + 2][coords[0]]; 
		if(cell != null) {
			pointsToEachMove.put("UP", pointsToEachMove.get("UP") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPRIGHT", pointsToEachMove.get("UPRIGHT") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPLEFT", pointsToEachMove.get("UPLEFT") + 25 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] + 1][coords[0]]; 
		if(cell != null) {
			pointsToEachMove.put("UP", pointsToEachMove.get("UP") + 125 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPRIGHT", pointsToEachMove.get("UPRIGHT") + 125 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPLEFT", pointsToEachMove.get("UPLEFT") + 125 * interestInOthers.get(cell.getCode()));
		}
		
		// Above right
		cell = ocean.getLayout()[coords[1] + 2][coords[0] + 1]; 
		if(cell != null) {
			pointsToEachMove.put("UP", pointsToEachMove.get("UP") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPRIGHT", pointsToEachMove.get("UPRIGHT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("RIGHT", pointsToEachMove.get("RIGHT") + 5 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] + 1][coords[0] + 1]; 
		if(cell != null) {
			pointsToEachMove.put("UP", pointsToEachMove.get("UP") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPRIGHT", pointsToEachMove.get("UPRIGHT") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("RIGHT", pointsToEachMove.get("RIGHT") + 25 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] + 1][coords[0] + 2]; 
		if(cell != null) {
			pointsToEachMove.put("UP", pointsToEachMove.get("UP") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPRIGHT", pointsToEachMove.get("UPRIGHT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("RIGHT", pointsToEachMove.get("RIGHT") + 5 * interestInOthers.get(cell.getCode()));
		}
		
		// Above LEFT
		cell = ocean.getLayout()[coords[1] + 2][coords[0] - 1]; 
		if(cell != null) {
			pointsToEachMove.put("UP", pointsToEachMove.get("UP") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPLEFT", pointsToEachMove.get("UPLEFT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("LEFT", pointsToEachMove.get("LEFT") + 5 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] + 1][coords[0] - 1]; 
		if(cell != null) {
			pointsToEachMove.put("UP", pointsToEachMove.get("UP") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPLEFT", pointsToEachMove.get("UPLEFT") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("LEFT", pointsToEachMove.get("LEFT") + 25 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] + 1][coords[0] - 2]; 
		if(cell != null) {
			pointsToEachMove.put("UP", pointsToEachMove.get("UP") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("UPLEFT", pointsToEachMove.get("UPLEFT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("LEFT", pointsToEachMove.get("LEFT") + 5 * interestInOthers.get(cell.getCode()));
		}
		
		// Below right
		cell = ocean.getLayout()[coords[1] - 2][coords[0] + 1]; 
		if(cell != null) {
			pointsToEachMove.put("DOWN", pointsToEachMove.get("DOWN") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNRIGHT", pointsToEachMove.get("DOWNRIGHT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("RIGHT", pointsToEachMove.get("RIGHT") + 5 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] - 1][coords[0] + 1]; 
		if(cell != null) {
			pointsToEachMove.put("DOWN", pointsToEachMove.get("DOWN") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNRIGHT", pointsToEachMove.get("DOWNRIGHT") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("RIGHT", pointsToEachMove.get("RIGHT") + 25 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] - 1][coords[0] + 2]; 
		if(cell != null) {
			pointsToEachMove.put("DOWN", pointsToEachMove.get("DOWN") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNRIGHT", pointsToEachMove.get("DOWNRIGHT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("RIGHT", pointsToEachMove.get("RIGHT") + 5 * interestInOthers.get(cell.getCode()));
		}
		
		// Below LEFT
		cell = ocean.getLayout()[coords[1] - 2][coords[0] - 1]; 
		if(cell != null) {
			pointsToEachMove.put("DOWN", pointsToEachMove.get("DOWN") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNLEFT", pointsToEachMove.get("DOWNLEFT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("LEFT", pointsToEachMove.get("LEFT") + 5 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] - 1][coords[0] - 1]; 
		if(cell != null) {
			pointsToEachMove.put("DOWN", pointsToEachMove.get("DOWN") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNLEFT", pointsToEachMove.get("DOWNLEFT") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("LEFT", pointsToEachMove.get("LEFT") + 25 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] - 1][coords[0] - 2]; 
		if(cell != null) {
			pointsToEachMove.put("DOWN", pointsToEachMove.get("DOWN") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNLEFT", pointsToEachMove.get("DOWNLEFT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("LEFT", pointsToEachMove.get("LEFT") + 5 * interestInOthers.get(cell.getCode()));
		}		
		
		// Directly below
		cell = ocean.getLayout()[coords[1] - 3][coords[0]]; 
		if(cell != null) {
			pointsToEachMove.put("DOWN", pointsToEachMove.get("DOWN") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNRIGHT", pointsToEachMove.get("DOWNRIGHT") + 5 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNLEFT", pointsToEachMove.get("DOWNLEFT") + 5 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] - 2][coords[0]]; 
		if(cell != null) {
			pointsToEachMove.put("DOWN", pointsToEachMove.get("DOWN") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNRIGHT", pointsToEachMove.get("DOWNRIGHT") + 25 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNLEFT", pointsToEachMove.get("DOWNLEFT") + 25 * interestInOthers.get(cell.getCode()));
		}
		cell = ocean.getLayout()[coords[1] - 1][coords[0]]; 
		if(cell != null) {
			pointsToEachMove.put("DOWN", pointsToEachMove.get("DOWN") + 125 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNRIGHT", pointsToEachMove.get("DOWNRIGHT") + 125 * interestInOthers.get(cell.getCode()));
			pointsToEachMove.put("DOWNLEFT", pointsToEachMove.get("DOWNLEFT") + 125 * interestInOthers.get(cell.getCode()));
		}
	}
	
	public String decideMove()
	{
		String highestKey = "UP";
		int highestValue = Integer.MIN_VALUE;
		for(String key : pointsToEachMove.keySet()) {
			if(pointsToEachMove.get(key) > highestValue) {
				highestKey = key;
				highestValue = pointsToEachMove.get(key);
			}
		}
		return highestKey;
	}
	
}
