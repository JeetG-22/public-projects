package american_cs_league;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Patolli {
	static int[] pos = new int[6];

	public static void main(String[] args) {

		// Input
		Scanner kbd = new Scanner(System.in);
		ArrayList<Integer> input = new ArrayList<Integer>();
		for (String num : kbd.nextLine().split(" ")) {
			input.add(Integer.parseInt(num));
		}
		int[] rolls = new int[input.get(6)];
		int count = 0, count2 = 0;
		for (int i = 0; i < input.size(); i++) {
			if (i < 6) {
				pos[count] = input.get(i);
				count++;
			}
			if (i > 6) {
				rolls[count2] = input.get(i);
				count2++;
			}
		}
//		System.out.println(Arrays.toString(input.toArray()));
//		System.out.println(Arrays.toString(pos));
//		System.out.println(Arrays.toString(rolls));

		// Game Time
		boolean[] canRoll = new boolean[6];
		for(int i = 0; i < rolls.length; i++) {
			int rolledPos = pos[minIndex()] + rolls[i];
			int addToPos = 0;
			if(rolledPos == 52) {
				pos[minIndex()] = rolledPos;
				break;
			}
			if(occupied(rolledPos) || rolledPos > 52) {
				addToPos = 0;
			}
			else if(primeCheck(rolledPos)) {
				
			}
		}
		// Input: 4 14 24 1 8 12 6 6 3 5 1 5 6

	}

	public static int minIndex() {
		int minI = 0;
		for (int i = 1; i < pos.length; i++) {
			if (pos[minI] > pos[i]) {
				minI = i;
			}
		}
		return minI;
	}

	public static boolean occupied(int rolledPos) {
		for (int i = 0; i < pos.length; i++) {
			if (rolledPos == pos[i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean primeCheck(int rolledPos) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
		for (int i = 0; i < prime.length; i++) {
			if (prime[i] == rolledPos) {
				return true;
			}
		}
		return false;
	}
	public static boolean perfectSquareCheck(int rolledPos) {
		for (int i = 3; i < 8; i++) {
			if (Math.pow(i, 2) == rolledPos) {
				return true;
			}
		}
		return false;
	}
//	public static int stopBeforeIndex(int num) { //Finish
//		ArrayList<Integer> values = new ArrayList<Integer>();
//		for(int i = 0; i < pos.length; i++) {
//			if(num != pos[i] && num - 6 < pos[i]) {
//				
//			}
//		}
//	}

}
