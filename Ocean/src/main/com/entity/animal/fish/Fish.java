package main.com.entity.animal.fish;

import java.util.ArrayList;
import main.com.ocean.Ocean;

import main.com.entity.Entity;
import main.com.entity.animal.Animal;;
/**
 * For inheritance of Fish, entities that can swim eat chase etc.
 * 
 * @author Matthew Schofield
 * @version 2.7.18
 */
public abstract class Fish extends Animal {

	public Fish(String species, String code, Ocean ocean, ArrayList<String> threats, ArrayList<String> food)
	{
		super(species, code, ocean, threats, food);
	}
	
}
