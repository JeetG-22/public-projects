package american_cs_league;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Veitch {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Input: ");
		String input = kbd.nextLine();
		
		String[][] arr = { { "ABcd", "ABCd", "aBCd", "aBcd" }, 
						   { "ABcD", "ABCD", "aBCD", "aBcD" },
				           { "AbcD", "AbCD", "abCD", "abcD" }, 
				           { "Abcd", "AbCd", "abCd", "abcd" } };
		
		ArrayList<String> var = new ArrayList<String>();
		int j = 0;
		for (int i = 0; i < 4; i++) {
			if (input.indexOf('+', j) == -1) {
				var.add(input.substring(j++));
				break;
			}
			var.add(input.substring(j, input.indexOf('+', j)));
			j = input.indexOf('+', j) + 1;
		}

		for (int i = 0; i < var.size(); i++) {
			var.set(i, var.get(i).replace("~C", "c"));
			var.set(i, var.get(i).replace("~D", "d"));
			var.set(i, var.get(i).replace("~A", "a"));
			var.set(i, var.get(i).replace("~B", "b"));
		}
		System.out.println(Arrays.toString(var.toArray()));

		for (String exp : var) {
			for (int row = 0; row < arr.length; row++) {
				for (int column = 0; column < arr[row].length; column++) {
					if (compareString(arr[row][column], exp)) {
						arr[row][column] = "x";
					}
				}
			}
		}
		printArr(arr);
		
		String hex = "";
		for (int row = 0; row < arr.length; row++) {
			int sum = 0;
			int power = 0;
			for (int column = arr[row].length - 1; column >= 0; column--) {
				if (arr[row][column].equals("x")) {
					sum += Math.pow(2, power);
				}
				power++;
			}
			hex += Integer.toHexString(sum);
		}
		System.out.println("Hexidecimal Representation: " + hex.toUpperCase());
		kbd.close();

	}

	public static boolean compareString(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str2.length(); i++) {
			if (str1.contains(String.valueOf(str2.charAt(i)))) {
				count++;
			}
		}
		boolean result = count == str2.length() ? true : false;
		return result;

	}

	public static void printArr(String[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int column = 0; column < arr[row].length; column++) {
				System.out.print(arr[row][column] + "\t");
			}
			System.out.println();
		}
	}
	//INPUT: 
	//AB+~C+~A~D - FD9B
	//AB+~AB+~A~B - FF33
	//AB~C~D+AB~CD+~A~B~CD - 8810
	//AB~C~D+~AB~C~D+A~B~C~D - 9008
	//B~D+~B~D - F00F
	//~A~BD+~A~B~D - 0033
	//B~D+~A~BD+A~B~C - F0B8
	//~B~C+BCD+B~C~D - 9699
	//A~C+ACD+~A~CD - 8DD8
	//AB~D+~ABD+A~BD+~A~B~D - C3C3
	//B~D+~A~CD+~A~B~C~D - F111

}
