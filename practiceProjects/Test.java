package practiceProjects;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		//declare variables
		Scanner kbd = new Scanner(System.in);
		
		//ask user
		System.out.println("Enter your lead opponent's card and your five cards: ");
		String all = kbd.nextLine();
		
		//checks format of entered cards
		while(all.length() != 34) {
		System.out.println("Please enter the cards again in the correct format: ");
		all = kbd.nextLine();
		}
		kbd.close();
		
		//declares & initializes opponent's cards
		String lead = all.substring(0, 4);
		int leadR = Integer.parseInt(lead.substring(0, 1));
		String leadS = lead.substring(3);
		
		//declares & initializes your cards
		String cards = all.substring(6);
		int valueR = 0; //initializes for rank value
		int valueS = 3; //initializes for suit value
		int highestRank = 9;
		int tempHigh;
		int lowestRank = leadR;
		
		//for loop to compute what cards are the same value & the lowest below and above the lead rank
		if(cards.substring(valueS, valueS + 1).equals(leadS)) {
		if(Integer.parseInt(cards.substring(valueR, valueR + 1)) > leadR) {
		tempHigh = Integer.parseInt(cards.substring(valueR, valueR + 1));
		if(tempHigh <= 9) {
		highestRank = tempHigh;
		}
		} else if(Integer.parseInt(cards.substring(valueR, valueR + 1)) < lowestRank) {
		lowestRank = Integer.parseInt(cards.substring(valueR, valueR + 1));
		}
		}
		valueS = valueS + 6;
		valueR = valueR + 6;
		
		//tells user which card to deal
		if(highestRank > leadR) {
		System.out.println(highestRank + ", " + leadS);
		} else if(lowestRank < leadR) {
		System.out.println(lowestRank + ", " + leadS);
		} else{
		System.out.println("NONE");
		
		} 
	


	}

}
