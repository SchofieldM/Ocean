package main.com.utilities;

import java.util.Random;

/**
 * For random number generation
 * 
 * @author Matthew Schofield
 * @version 2.14.18
*/
public class RNG {

// int
	/**
	 * Generates a random int
	 * 
	 * @param min, minimum int inclusive
	 * @param max, maximum int inclusive
	 * @return returns an int inclusively between min and max
	 */
	public static int randomInt(int min, int max)
	{
		return (new Random()).nextInt(max) + min;
	}
	
}
