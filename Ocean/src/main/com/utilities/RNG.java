package main.com.utilities;

import java.util.Random;

/**
 * For random number generation
 * 
 * @author Matthew Schofield
 * @version 2.7.18
*/
public class RNG {

	public static int randomInt(int min, int max)
	{
		return (new Random()).nextInt(max) + min;
	}
	
}
