package main.com.entity;

import main.com.ocean.Ocean;

public abstract class Entity {

// Fields
	// int[]
		protected int[] coords;
	// Ocean
		protected Ocean ocean;
	// String
		protected String code;

		
// Constructor
		public Entity(String code, Ocean ocean)
		{
			this.code = code;
			this.ocean = ocean;
		}
		
// Abstract Methods	
		public abstract void turn();
		
// Concrete Methods
		
	// void
		public void setOcean(Ocean ocean)
		{
			this.ocean = ocean;
		}
		
		public void setCoords(int[] coords)
		{
			this.coords = coords;
		}
		
	// Ocean
		public Ocean getOcean()
		{
			return ocean;
		}
		
	// int[]
		public int[] getCoords()
		{
			return coords;
		}
		
	// String
		public String getCode()
		{
			return code;
		}
		
}
