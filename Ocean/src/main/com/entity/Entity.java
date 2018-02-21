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
		/**
		 * Lets the Entity know what Ocean it is in
		 * 
		 * @param ocean, the Ocean the Entity is in
		 */
		public void setOcean(Ocean ocean)
		{
			this.ocean = ocean;
		}
		
		/**
		 * Lets the Entity know where it is in terms of x,y
		 * 
		 * @param coords, the x,y coordinates the Entity is at
		 */
		public void setCoords(int[] coords)
		{
			this.coords = coords;
		}
		
	// Ocean
		/**
		 * Accesor method for the Ocean the Entity is in
		 * 
		 * @return
		 */
		public Ocean getOcean()
		{
			return ocean;
		}
		
	// int[]
		/**
		 * x,y
		 * 
		 * @return coords x,y
		 */
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
