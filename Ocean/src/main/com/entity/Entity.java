package main.com.entity;

import main.com.ocean.Ocean;

public abstract class Entity {

// Fields
	// int[]
		private int[] coords;
	// Ocean
		private Ocean ocean;
	// String
		private String code;
		
// Constructor
		public Entity(String code)
		{
			this.code = code;
		}
	
// Methods
		public abstract void turn();
		public abstract String getDirection();
		public abstract void clearDirection();
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
