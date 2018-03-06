package main.com.entity.livingthing.animal;

import main.com.Move;
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
	// Boolean
		protected boolean male;
	// int
		protected int stomachCapacity;
		protected int amountInStomach;
	//String
		protected String moveChoice;
	// HashMap
		protected HashMap<String, Integer> interestInOthers;
		protected HashMap<Move, Integer> pointsToEachMove;
		
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
		Move move = decideMove();
		int newX = coords[0];
		int newY = coords[1];
		newX += move.getXChange();
		newY += move.getYChange();
		ocean.moveCell(coords[0], coords[1], newX, newY);
		coords[0] = newX;
		coords[1] = newY;
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
		pointsToEachMove.put(Move.UP, 0);
		pointsToEachMove.put(Move.DOWN, 0);
		pointsToEachMove.put(Move.LEFT, 0);
		pointsToEachMove.put(Move.RIGHT, 0);
		pointsToEachMove.put(Move.UPRIGHT, 0);
		pointsToEachMove.put(Move.DOWNRIGHT, 0);
		pointsToEachMove.put(Move.UPLEFT, 0);
		pointsToEachMove.put(Move.DOWNLEFT, 0);
	}
	
	public void calculateMoveValues()
	{
		resetPointsToEachMove();
		Entity cell;
		// Directly above/below
		for(int i = -3; i <= 3; i++) {
			if (i > 0) {
				try {
					cell = ocean.getLayout()[coords[1] + i][coords[0]]; 
					if(cell != null) {
						pointsToEachMove.put(Move.UP, pointsToEachMove.get(Move.UP) + ((int) Math.pow(5, 4 - Math.abs(i))) * interestInOthers.get(cell.getCode()));
						pointsToEachMove.put(Move.UPRIGHT, pointsToEachMove.get(Move.UPRIGHT) + ((int) Math.pow(5, 4 - Math.abs(i))) * interestInOthers.get(cell.getCode()));
						pointsToEachMove.put(Move.UPLEFT, pointsToEachMove.get(Move.UPLEFT) + ((int) Math.pow(5, 4 - Math.abs(i))) * interestInOthers.get(cell.getCode()));
					}
				}catch(Exception e) {}
			}else if(i < 0) {
				try {
					cell = ocean.getLayout()[coords[1] + i][coords[0]]; 
					if(cell != null) {
						pointsToEachMove.put(Move.DOWN, pointsToEachMove.get(Move.DOWN) + ((int) Math.pow(5, 4 - Math.abs(i))) * interestInOthers.get(cell.getCode()));
						pointsToEachMove.put(Move.DOWNRIGHT, pointsToEachMove.get(Move.DOWNRIGHT) + ((int) Math.pow(5, 4 - Math.abs(i))) * interestInOthers.get(cell.getCode()));
						pointsToEachMove.put(Move.DOWNLEFT, pointsToEachMove.get(Move.DOWNLEFT) + ((int) Math.pow(5, 4 - Math.abs(i))) * interestInOthers.get(cell.getCode()));
					}
				}catch(Exception e) {}
			}
		}
	
		for(int i = -2; i <= 2; i++) {
			for(int j = -2; j <= 2;  j++) {
				if(i > 0 && j > 0) {
					try {
						cell = ocean.getLayout()[coords[1] + i][coords[0] + j]; 
						if(cell != null) {
							pointsToEachMove.put(Move.UP, pointsToEachMove.get(Move.UP) + ((int) Math.pow(5, 4 - Math.abs(i+j))) * interestInOthers.get(cell.getCode()));
							pointsToEachMove.put(Move.UPRIGHT, pointsToEachMove.get(Move.UPRIGHT) + ((int) Math.pow(5, 4 - Math.abs(i+j))) * interestInOthers.get(cell.getCode()));
							pointsToEachMove.put(Move.RIGHT, pointsToEachMove.get(Move.RIGHT) + ((int) Math.pow(5, 4 - Math.abs(i+j))) * interestInOthers.get(cell.getCode()));
						}
					}catch(Exception e) {}
				}else if(i < 0 && j < 0) {
					try {
						cell = ocean.getLayout()[coords[1] - i][coords[0] - j]; 
						if(cell != null) {
							pointsToEachMove.put(Move.DOWN, pointsToEachMove.get(Move.DOWN) + ((int) Math.pow(5, 4 - Math.abs(i+j))) * interestInOthers.get(cell.getCode()));
							pointsToEachMove.put(Move.DOWNLEFT, pointsToEachMove.get(Move.DOWNLEFT) + ((int) Math.pow(5, 4 - Math.abs(i+j))) * interestInOthers.get(cell.getCode()));
							pointsToEachMove.put(Move.LEFT, pointsToEachMove.get(Move.LEFT) + ((int) Math.pow(5, 4 - Math.abs(i+j))) * interestInOthers.get(cell.getCode()));
						}		
					}catch(Exception e) {}
				}
			}
		}
		
		for(int i = 1; i <= 2; i++) {
			for(int j = -2; j < 0; j++) {
				try{
					cell = ocean.getLayout()[coords[1] + i][coords[0] + j]; 
					if(cell != null) {
						pointsToEachMove.put(Move.UP, pointsToEachMove.get(Move.UP) + ((int) Math.pow(5, 4 - i+Math.abs(j))) * interestInOthers.get(cell.getCode()));
						pointsToEachMove.put(Move.UPLEFT, pointsToEachMove.get(Move.UPLEFT) + ((int) Math.pow(5, 4 - i+Math.abs(j))) * interestInOthers.get(cell.getCode()));
						pointsToEachMove.put(Move.LEFT, pointsToEachMove.get(Move.LEFT) + ((int) Math.pow(5, 4 - i+Math.abs(j))) * interestInOthers.get(cell.getCode()));
					}
				}catch(Exception e) {}
			}
		}

		for(int i = -2; i < 0; i++) {
			for(int j = 1; j <= 2; j++) {
				try{
					cell = ocean.getLayout()[coords[1] + i][coords[0] + j]; 
					if(cell != null) {
						pointsToEachMove.put(Move.DOWN, pointsToEachMove.get(Move.DOWN) + ((int) Math.pow(5, 4 - j+Math.abs(i))) * interestInOthers.get(cell.getCode()));
						pointsToEachMove.put(Move.DOWNRIGHT, pointsToEachMove.get(Move.DOWNRIGHT) + ((int) Math.pow(5, 4 - j+Math.abs(i))) * interestInOthers.get(cell.getCode()));
						pointsToEachMove.put(Move.RIGHT, pointsToEachMove.get(Move.RIGHT) + ((int) Math.pow(5, 4 - j+Math.abs(i))) * interestInOthers.get(cell.getCode()));
					}
				}catch(Exception e) {}
			}
		}
		
	}
		
	
	
	public Move decideMove()
	{
		calculateMoveValues();
		Move highestKey = null;
		int highestValue = Integer.MIN_VALUE;
		for(Move key : pointsToEachMove.keySet()) {
			if(pointsToEachMove.get(key) > highestValue) {
				highestKey = key;
				highestValue = pointsToEachMove.get(key);
			}
		}
		System.out.println(highestKey);
		return highestKey;
	}
	
}
