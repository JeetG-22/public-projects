package practiceProjects;

import java.util.Scanner;

public class AscendingOrder {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Number 1: ");
		int num1 = kbd.nextInt();
		System.out.println("Number 2: ");
		int num2 = kbd.nextInt();
		System.out.println("Number 3: ");
		int num3 = kbd.nextInt();
		
		int min = Math.min(num1, Math.min(num2, num3));
		int between = Math.max(num1, Math.min(num2, num3));
		int max = Math.max(num1, Math.max(num2, num3));
		System.out.println("Ascending Order: " + min + "," + between + "," + max);
		kbd.close();
	}

}
