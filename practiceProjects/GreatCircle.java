package practiceProjects;

import java.util.Scanner;

public class GreatCircle {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Give me the longitude and latitude of two different locations"
				+ " and I will find the distance between the two places");
		System.out.println("Latitude of first place: ");
		double x1 = kbd.nextDouble();
		x1 = Math.toRadians(x1);
		System.out.println("Longitude of first place: ");
		double y1 = kbd.nextDouble();
		y1 = Math.toRadians(y1);
		System.out.println("Latitude of second place: ");
		double x2 = kbd.nextDouble();
		x2 = Math.toRadians(x2);
		System.out.println("Longitude of second place: ");
		double y2 = kbd.nextDouble();
		y2 = Math.toRadians(y2);
		
		double distance = 3440*Math.acos(Math.sin(x1)*Math.sin(x2)+Math.cos(x1)*Math.cos(x1)*Math.cos(y1-y2));
		//Multiplied by 3440 = radius of the earth in nautical miles
		System.out.println("Nautical Miles: " + distance);
		kbd.close();

	}

}
