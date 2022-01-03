package american_cs_league;

import java.util.Scanner;

public class NumberTransformation {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int j = 0;
		try {
			while (j < 5) {
				// Input
				System.out.print("Integer: ");
				String input = kbd.nextLine();

				int pos = Integer.parseInt(input.substring(input.lastIndexOf(" ") + 1)); // Position of integer

				// Finds how many digits the pth position is
				int numDigPos = input.substring(input.lastIndexOf(" ") + 1).length();

				input = input.replaceAll(" ", "");

				int pIndex = input.length() - pos - numDigPos; // Index of pth digit

				// Array of the integer
				int arr[] = new int[input.length() - numDigPos];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = Integer.parseInt(input.substring(i, i + 1));
				}

				// New Integer String
				String newInt = "";
				int sum = 0;
				int abs = 0;
				for (int i = 0; i < arr.length; i++) {
					if (i < pIndex) { // Manipulating the left side of the pth digit
						sum = (arr[i] + arr[pIndex]) % 10;
						newInt += Integer.toString(sum);
					} else if (i == pIndex) {
						newInt += Integer.toString(arr[pIndex]);
					} else { // Manipulating the right side of the pth digit
						abs = Math.abs(arr[i] - arr[pIndex]);
						newInt += Integer.toString(abs);
					}
				}
				System.out.println("Output: " + newInt);
				System.out.println();
				j++;
			}
		} catch (Exception E) {
			System.out.println("Error! Bad Input");
		}

		kbd.close();

	}
}
