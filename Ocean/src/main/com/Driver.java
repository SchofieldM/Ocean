package main.com;

import java.util.Scanner;

// internal import
	import main.com.ocean.Ocean;
	import main.com.oceanobj.*;
import main.com.oceanobj.livingthing.animal.fish.Tuna;

import main.com.oceanobj.livingthing.animal.fish.Shark;
public class Driver {

	public static void main(String[] args)
	{
		Ocean pacific = new Ocean(10,10);
		pacific.setCell(2, 0, new Tuna(pacific));
		pacific.setCell(8, 8, new Shark(pacific));
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		while(run) {
			paint(pacific);
			pacific.movePieces();
			System.out.println("Keep Going?(Y/N):");
			String keepGoingDecision = scanner.nextLine();
			if(keepGoingDecision.equals("N")) {
				run = false;
			}
		}
	}
	
	public static void paint(Ocean ocean)
	{
		for(OceanObj[] layer : ocean.getBoard()){	
			for(OceanObj oo : layer) {
				if(oo == null) {
					System.out.print("    |");
				}else {
					System.out.print(oo.getCode() + "|");
				}
			}
			System.out.println();
		}
	}
	
}
