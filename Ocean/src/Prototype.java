import java.util.Scanner;
import java.util.Random;

/**
* Quick prototyping, meant to be refactored
*/
public class Prototype {

	// Dimensions of the board, DIMENSIONS x DIMENSIONS
	public static int DIMENSIONS;
	// Coords of the shark [x,y]
	public static int[] shark;
	// Coords of the tuna [x,y]
	public static int[] tuna;
	// If the ai is in control of the tuna, if not the user is
	private static boolean ai;
	
/**
* Entrance point
*
* @param args, unused
*/
	public static void main(String[] args)
	{
		// welcomes the user and configures how the game will run
welcomeAndConfig();

// Initializes the coord arrays
		shark = new int[] {rngInt(1, DIMENSIONS), DIMENSIONS};
		tuna = new int[] {rngInt(1, DIMENSIONS),1};
		
		// The game starts as running
	boolean gameRunning = true;

	// Game loop
		while(gameRunning) {
			
			// Displays to the user what is happening
			coordsOfBoth();
			paintBoard();

			// Tuna moves
			if(ai) {
				tunaMove();
			}else {
				playerMove();
			}
			
			// Shark moves
			sharkMove();
			
			// If the shark and tuna occupy the same cell, end the game
			if(tuna[0] == shark[0] && tuna[1] == shark[1]) {
				gameRunning = false;

				// end of game message
				System.out.println("\n============\n");
				paintBoard();
				System.out.println("Thanks for playing");
			}
			
			// if the ai is in control have the user hit enter 
			if(ai)
				(new Scanner(System.in)).nextLine();
			
		}
	}
	
	public static void sharkMove()
	{
		if(shark[0] < tuna[0]) {
			shark[0]++;
		}else if(shark[0] > tuna[0]) {
			shark[0]--;
		}
		
		if(shark[1] < tuna[1]) {
			shark[1]++;
		}else if(shark[1] > tuna[1]) {
			shark[1]--;
		}
	}

	/** 
* Prints out the tuna and shark’s x and y coordinates 
	*/
	public static void coordsOfBoth()
	{
		System.out.println("Tuna: " + tuna[0] + "," + tuna[1]);
		System.out.println("Shark: " + shark[0] + "," + shark[1]);
	}
	
	/**
 	* Allows the user to input which direction on the grid to move the tuna.
*
 	* @return The string input by the user.
 	*/
public static String userChoice()
	{
		System.out.print("Please pick a direction to move:");
		Scanner s = new Scanner(System.in);	
		return s.nextLine();
	}
	
	/**
	* Used for tuna AI and for initializing the grid dimensions.
	*
	* @return Random integer based on maximum and minimum values.
*/
	public static int rngInt(int min, int max)
	 {
	  Random rng = new Random();
	  return rng.nextInt(max - min + 1) + min;
	 }

	/**
	* Prints a visual representation of the grid with the shark and tuna positions.
	*/
	public static void paintBoard()
	{
		for(int i = DIMENSIONS; i > 0; i--) {
			for(int j = 1; j <= DIMENSIONS; j++) {
				boolean  found = false;

				if(shark[0] == j && shark[1] == i) {
					System.out.print("|S");
					found  = true;
				}
				if(tuna[0] == j && tuna[1] == i) {
					if(!found) {
						System.out.print("|T");
						found = true;
					}
				}
				if(!found) {
					System.out.print("| ");
				}
				
			}
			System.out.println("|");
		}
	}
	
	/**
	* Tuna AI to move the tuna’s position based on the shark’s position.
	*/
	public static void tunaMove()
	{
		int tunax = 0;
		int tunay = 0;
		if(tuna[0] < shark[0]) {
			tunax = -1;
		}else if(tuna[0] < shark[0]) {
			tunax = 1;
		}else {
			tunax = rngInt(-1, 1);
		}
		
		if(tuna[1] < shark[1]) {
			tunay = -1;
		}else if(tuna[1] > shark[1]) {
			tunay = 1;
		}else {

			tunay
			= rngInt(-1, 1);
		}
		
		if(isLegal(tunax, tunay)) {}
		else if(isLegal(tunax, 0)) {}
		else if(isLegal(0, tunay)){}
	}
	
	/**
* Manages player input; called every turn
*/
	public static void playerMove()
	{
	//If the player gives a valid input, this boolean will be set to true and terminate the loop
    	boolean decided = false;
    	while (!decided)
    	{
		//the userChoice prompts the player for the direction and parses it accordingly.  If the input
		//is appropriate, then the loop is broken and the turn is continued.  If not, it cycles back to the top.
        	switch(userChoice())
                	{
                    	case "up":
                        	if(isLegal(0,1))
                        	{
                            	decided = true;
                        	}
                        	break;
                    	case "down":
                        		if(isLegal(0,-1))
                        		{
                            		decided = true;
                        		}
                        		break;
                    	case "left":
                        	if(isLegal(-1,0))
                        	{
                            	decided = true;
                        	}
                        	break;
	                    case "right":
                        	if(isLegal(1,0))
                        	{
                            	decided = true;
                        	}
                        	break;
                    	case "up left":
                        	if(isLegal(-1,1))
                        	{
                            	decided = true;
                        	}
                        	break;
                    	case "up right":
                        	if(isLegal(1,1))
                        	{
                            	decided = true;
                        	}
                        	break;
                    	case "down left":
                        	if(isLegal(-1,-1))
                        	{
                            	decided = true;
                        	}
                        	break;
                    	case "down right":
                        	if(isLegal(1,-1))
                        	{
                            	decided = true;
                        	}
                        	break;
                    	default:
                        	{
					//Blank statement; effectively handled by the !decided conditional
                        	}  	
                        		break;
                    	}
                    	if(!decided)
                    	{
                        	//If the user has not input a valid direction, then it prints this error, reprints the board, and prompts
				//for input once more.
System.out.print("Invalid entry.  Please try again.\n\n");
                        	paintBoard();
                    	}
	
            		}
	}

	//Determines whether or not a hypothetical vector of movement provided by the player
	//is able to be made without falling out of bounds
	public static boolean isLegal(int xmov, int ymov)
	{
		//By default, a move is considered valid and represented in the retval.
		//If the hypothetical move is out of any bounds, this is rendered false.
boolean retVal = true;
		if(tuna[0] + xmov < 1 || tuna[0] + xmov > DIMENSIONS || tuna[1] + ymov < 1 || tuna[1] + ymov > DIMENSIONS)
		{
			retVal = false;
		}
		//If the move is valid, it is enacted
		if (retVal)
		{
			tuna[0] += xmov;
			tuna[1] += ymov;
		}
		//in any case, the returned boolean is used by the playerMove
		//when the boool
		return retVal;
	}

	/**
	* Welcomes the player and gives choices to configure the dimensions and if the game is played by the user or by an AI.
	*/
	public static void welcomeAndConfig()
	{
		System.out.println("Welcome!");
		System.out.println("Dimensions: ");
		String dimen = (new Scanner(System.in)).nextLine();
		DIMENSIONS = Integer.parseInt(dimen);
		System.out.println("AI or USER?: ");
		String controlChoice = (new Scanner(System.in)).nextLine();
		if(controlChoice.equals("AI")) {
			ai = true;
		}else {
			ai = false;
		}
		
	}
	
	
}
