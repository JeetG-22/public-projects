package practiceProjects;

import java.util.Scanner;

public class DateToDay {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Give me the month, day, and year and I will find"
				+ " and I will find the day of the week that date falls on.");
		System.out.println("Month as a number (1 for January, 2 for February...) : ");
		int m = kbd.nextInt();
		System.out.println("Day: ");
		int d = kbd.nextInt();
		System.out.println("Year: ");
		int y = kbd.nextInt();
		
		int y0 = y-(14-m)/12;
		int x = y0+y0/4-y0/100+y0/400;
		int m0 = m + 12*((14-m)/12)-2;
		System.out.println(m0);
		int d0 = (d+x+(31*m0) /12)%7;
		
		System.out.println(d0);
		kbd.close();

	}

}
