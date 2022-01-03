package practiceProjects;

import java.util.Scanner;

public class CheckSum {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int index = 0;
		int sum = 0;
		int count = 10;
		System.out.println("Give me a 9 digit ISBN number: ");
		String isbnNum = kbd.next();
		for(int i = 9; i >=1; i--) {
			int digit = Integer.parseInt(isbnNum.substring(index, index+1));
			sum+=(count*digit);
			index++;
			count--;
		}
		int remainder = sum%11;
		if(remainder == 0) {
			System.out.println("Checksum Digit: 0");
		}
		else {
			int checkSumDigit = 11-remainder;
			System.out.println("Checksum Digit: " + checkSumDigit);
		}
		kbd.close();

	}

}
