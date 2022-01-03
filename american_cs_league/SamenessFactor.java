package american_cs_league;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SamenessFactor {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		System.out.println("String: ");
		String input = kbd.nextLine();

		ArrayList<Character> word1 = new ArrayList<>();
		ArrayList<Character> word2 = new ArrayList<>();

		// Init Array Lists
		for (int i = 0; i < input.length(); i++) {
			if (i < input.indexOf(' ')) {
				word1.add(input.charAt(i));
			}
			if (input.indexOf(' ') < i) {
				word2.add(input.charAt(i));
			}
		}

		System.out.println("Original Word1: " + Arrays.toString(word1.toArray()));
		System.out.println("Original Word2: " + Arrays.toString(word2.toArray()));

		for (int i = 0; i < Math.min(word1.size(), word2.size()); i++) {
			int j = i;
			while (j < Math.min(word1.size(), word2.size())) {
				if (word1.get(j) == word2.get(j)) {
					word1.remove(j);
					word2.remove(j);
					j--;
				}
				j++;
			}
			if (i + 1 < word2.size() && word2.get(i + 1) == word1.get(i)) {
				word2.remove(i);
				word2.remove(i);
				word1.remove(i);
				i--;
			} else if (i + 1 < word1.size() && word1.get(i + 1) == word2.get(i)) {
				word1.remove(i);
				// Deleting the adjacent char which moved to the position of the previous
				// deleted element
				word1.remove(i);
				word2.remove(i);
				i--;
			}
		}

		// Calculating Sameness Factor
		int sum = (int) (Math.max(word1.size(), word2.size()) - Math.min(word1.size(), word2.size()));
		for (int i = 0; i < Math.min(word1.size(), word2.size()); i++) {
			sum += word1.get(i).compareTo(word2.get(i));
		}

		System.out.println("Final Word1: " + Arrays.toString(word1.toArray()));
		System.out.println("Final Word2: " + Arrays.toString(word2.toArray()));
		System.out.println("ACSL Sameness Factor: " + sum);
		kbd.close();
	}

}
