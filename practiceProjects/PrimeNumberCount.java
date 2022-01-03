package practiceProjects;

import java.util.Scanner;

public class PrimeNumberCount {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Num: ");
		int num = kbd.nextInt();
		int count = 0;
		for(int i = 1; i <= num; i++) {
			for(int j = 2; j <= i/2; j++) {
				if(i%j==0) {
					count++;
					break;
				}
			}
		}
		System.out.println("Number of Primes: " + (num-count-1));
		kbd.close();

	}

}
