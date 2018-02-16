package main.com.entity.livingthing.animal.fish;

import java.util.ArrayList;
import java.util.HashMap;
import main.com.ocean.Ocean;

import main.com.entity.Entity;
import main.com.entity.livingthing.animal.Animal;;
/**
 * For inheritance of Fish, entities that can swim eat chase etc.
 * 
 * @author Matthew Schofield
 * @version 2.7.18
 */
public abstract class Fish extends Animal {

	public Fish(String code, int maxSize ,int caloricValue, Ocean ocean, HashMap<String, Integer> interestInOthers)
	{
		super(code, caloricValue, ocean, interestInOthers);
	}
	
	public Fish(String code, int maxSize ,int caloricValue, Ocean ocean)
	{
		super(code, caloricValue, ocean);
	}
	
}
