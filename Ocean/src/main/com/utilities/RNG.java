package main.com.utilities;

import java.util.Random;

public class RNG {

	public static int randomInt(int min, int max)
	{
		return (new Random()).nextInt(max) + min;
	}
	
}
