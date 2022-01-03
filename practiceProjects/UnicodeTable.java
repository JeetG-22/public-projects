package practiceProjects;

import java.util.Scanner;

public class UnicodeTable {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		for(char i = ' '; i < '{'; i++) {
			System.out.print(i + "\t");
			if(i % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.print("Type the character you want the unicode value of: ");
		char input = kbd.next().charAt(0);
		
		System.out.println((int)input);
		kbd.close();

	}

}
