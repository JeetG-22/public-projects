package practiceProjects;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		int n, count = 0;
			
		System.out.println("enter a number");
		n = read.nextInt();
		read.close();
		
		for(int i = 2; i<=n; i++) {
			if(efficientCheckPrime(i)) {
				count++;
			}
		}	
		
		System.out.println(count);
	}
	
	public static boolean checkPrime(int n) {
		//simply tests if divisible by any number before n
		//cannot find number of primes up to 10,000,000 in under a minute
		
		boolean isPrime = true;
		
		for(int i = 2; i<n; i++) {
			if(n%i==0) {
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}
	
	public static boolean efficientCheckPrime(int n) {
		/* How this works:
		 * For every factor of n, there is a corresponding factor (e.g. for n=100, 5 has a corresponding factor of 20)
		 * This means that it is redundant to check factors after the square root of n, since their corresponding factor 
		 * would be less than the square root of n. This algorithm can be made more efficient by knowing that all prime
		 * numbers are in the form 6k +- 1. This means, instead of checking if n is divisible by any number from 2 to the
		 * square root of n, it's more efficient to check if n is divisible by any numbers in the form 6k +- 1 to the square
		 * root of n.
		 */
	
		if(n <= 3) {				//2 and 3 are prime
			return n>1;				//but 1 is not
		}
		if(n%2 == 0 || n%3 == 0) {	//checks if number is divisible by 2 or 3 first
			return false;			//because the proceeding algorithm does not
		}
		
		int i = 5; 		//5 is a prime in the form (6k-1) for k = 1;
		
		while(i*i <= n) {		//this ensures that we're only checking for values less than the square root of n	
			if(n%i == 0 || n%(i+2) == 0) {		//since i is in the form 6k-1, i+2 would be in the form 6k+1
				return false;					//returns false if divisible by either forms
			}
			i += 6;			 //increments the k value by 1
		}
		return true;							//if only all tests have been found to be false
		
		//can find number of primes up to 10,000,000 in 1.27 seconds
		//can find number of primes up to 100,000,000 in 31.84 seconds

	}
}