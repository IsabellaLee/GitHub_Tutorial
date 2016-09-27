/*
 * Name: Lin Li
 * UFID:loslylee (15573362)
 * Assignment Name: Project 1
 * Date: Sep 15, 2016
 * 
 */


import java.util.Scanner;
import java.lang.Math;

class CaptureCalculator{
	public static void main(String[] args){
		
		//Read in the information about the monster: 
		//Monster Location, Appear Time and Possible Exist Time
		
		System.out.println("Hello and welcome to the Monster Capture Possibility Calculator.");
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the latitude of the monster (1-10): ");
		int x1 = input.nextInt();
		System.out.println("Please enter the longitude of the monster (1-10): ");
		int y1 = input.nextInt();
		System.out.println("Please enter the time of the monster appear (1-1440): ");
		int Ta = input.nextInt();
		System.out.println("Please enter the possible time of the monster will exist (10-59): ");
		int Te = input.nextInt();
		
		//Read in the information about the player: 
		//Player ID, Player Walk Speed, Player Find Time and Location
		
		System.out.println("Please enter the player's ID (8 digits): ");
		int id = input.nextInt();
		System.out.println("Please enter the time of the player noticing monster (1-1440 and greater than the time the monster appears): ");
		int Tn = input.nextInt();
		System.out.println("Please enter the latitude of the player (1-10): ");
		int x2 = input.nextInt();
		System.out.println("Please enter the longitude of the player (1-10): ");
		int y2 = input.nextInt();
		System.out.println("Please enter the player's walking speed (10-200): ");
		int s = input.nextInt();
		
		//Calculate the straight line distance between player and monster
		
		double d = Math.sqrt((x2 - x1) * (x2 - x1) + 
							 (y2 - y1) * (y2 - y1)) * 1000;
		double roundedD = Math.round(d * 10)/10.0;
		
		//Calculate the exact time the player will arrive
		double Tg = Tn + d/s;
		double roundedTg = Math.round(Tg * 10)/10.0;

		// Whether he/she is late or not; if they are late, what percentage it is
		double percent = (Tg - (Ta + Te))/Te;
		String possibility;
		String list;
		
		// What type of player he/she is (“lucky list” vs “normal list”)
		if(0 <= id % 100 && id % 100 <= 49) {
			//Lucky list
			list = "lucky";
			
			if(percent <= 0){
				possibility = "definitely";
			}
			else {
				if(percent <= 0.1 && percent > 0){
					possibility ="highly likely";
				}
				else if(percent <= 0.3 && percent > 0.1){
					possibility = "likely";
				}
				else if(percent <= 0.4 && percent > 0.3){
					possibility = "unsure";
				}
				else if(percent <= 0.5 && percent > 0.4){
					possibility = "unlikely";
				}
				else{
					possibility = "highly unlikely";
				}
			}
		} else {
			//Normal list
			list = "normal";	
			
			if(percent <= 0){
				possibility = "definitely";
			}
			else {
				if(percent <= 0.05 && percent > 0){
					possibility = "highly likely";
				}
				else if(percent <= 0.2 && percent > 0.05){
					possibility = "likely";
				}
				else if(percent <= 0.35 && percent > 0.2){
					possibility = "unsure";
				}
				else if(percent <= 0.4 && percent > 0.35){
					possibility = "unlikely";
				}
				else{
					possibility = "highly unlikely";
				}
			}
		}
		
		//output
		System.out.println();	
		System.out.println("Player " + id + " who is on the " + list + " list,");
		System.out.println("noticed the monster at time " + Tn + ",");
		System.out.println("is " + roundedD + " m away from the monster,");
		System.out.println("and will arrive at time " + roundedTg + ".");
		System.out.println("The monster's disappear time is about " + (Ta + Te) + ".");
		System.out.println("So the player will capture this monster with " + possibility + " possibility.");
	}
}