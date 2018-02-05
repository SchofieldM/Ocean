package main.com.oceanobj.livingthing.animal.fish;

import main.com.ocean.*;
import main.com.oceanobj.OceanObj;

public class Shark extends Fish {


	public Shark(Ocean ocean)
	{
		super(ocean, "Shark", null, null, 100, 1, 100, "Shrk");
	}
	
	@Override
	public void makeDirectionChoice()
	{
		int[] coordsOfClosestFood = findClosestFood();
		int foodX = coordsOfClosestFood[0];
		int foodY = coordsOfClosestFood[1];
		if(foodX > x) {
			setDirection("RIGHT");
		}else if(foodX < x) {
			setDirection("LEFT");
		}else if(foodY < y) {
			setDirection("UP");
		}else if(foodY > y) {
			setDirection("DOWN");
		}else {
			setDirection("");
		}
	}
	
	public int[] findClosestFood()
	{
		for(int i = 0; i < ocean.getBoard().length; i++) {
			for(int j = 0; j < ocean.getBoard()[i].length; j++) {
				OceanObj oo = ocean.getBoard()[i][j];
				if(oo != null) {
					if(oo.getCode() == "Tuna") {
						return new int[] {j,i};
					}
				}
			}
		}
		return new int[] {5,5};
	}
}
