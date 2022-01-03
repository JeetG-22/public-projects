package practiceProjects;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Num: ");
		int num = kbd.nextInt();
		long startTime = System.nanoTime();
		int count = 0;
		for(int i = 1; i <= num; i++) {
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j==0) {
					count++;
					break;
				}
			}

		}
		System.out.println("Number of Primes: " + (num-count-1));
		long endTime = System.nanoTime();
		System.out.println("Elapsed: " + ((endTime-startTime)/1000000000));
		kbd.close();

	}

}
