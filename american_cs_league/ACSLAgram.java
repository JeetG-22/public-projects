package american_cs_league;

import java.util.Arrays;
import java.util.Scanner;

public class ACSLAgram {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int j = 0;
		while(j<5) {
			System.out.println("Input: ");
			String input = kbd.nextLine();
			System.out.println(Arrays.toString(cardSuit(input)));
			System.out.println(Arrays.toString(cardNum(input)));
			
			if(hasSuit(cardSuit(input))==true) {
				output(cardSuit(input),cardNum(input));			
			}
			else {
				System.out.println("NONE");
			}
			j++;
		}
		kbd.close();
	}

	public static String[] cardSuit(String input) { //Returns all the suits as a string array
		String suit[] = new String[6];
		for(int i = 3, j = 0;i <= 34; i += 6,j++) {
			suit[j] = input.substring(i,i+1);
		}
		return suit;
	}
	public static int[] cardNum(String input) { //returns all the numbers as a int array
		int num[] = new int[6];
		for(int i = 0, j = 0;i <= 31; i += 6,j++) {
			num[j] = Integer.parseInt(input.substring(i,i+1));
		}
		return num;
	}
	public static boolean hasSuit(String suit[]) { //Checks if the dealer has the same suit as the opponent
		boolean dealerHasSuit = false;
		for(int i = 1; i < suit.length; i++) {
			if(suit[0].equals(suit[i])) {
				dealerHasSuit = true;
			}
		}
		return dealerHasSuit;
	}
	public static void output(String suit[], int num[]) { 
		int greaterMin = 25, smallerMin = 25; 
		for(int i = 1; i < suit.length; i++) {
			if(suit[0].equals(suit[i])) {
				if(num[0]<num[i]) { //Minimum value that greater than the opponents card
					greaterMin = Math.min(greaterMin, num[i]);
				}
				else { //Smallest value of that suit
					smallerMin = Math.min(smallerMin, num[i]);
				}
			} 
		}
		if(num[0]<greaterMin && greaterMin !=25) 
			System.out.println(greaterMin + ", " + suit[0]);
		else 
			System.out.println(smallerMin + ", " + suit[0]);
	}
	
}
