package practiceProjects;

import java.util.Scanner;

public class ColorConversions {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Red Value: ");
		double red = kbd.nextDouble();
		System.out.println("Green Value: ");
		double green = kbd.nextDouble();
		System.out.println("Blue Value: ");
		double blue = kbd.nextDouble();
		
		double w = Math.max(red/255, Math.max(green/255, blue/255));
		double c = (w-(red/255))/w;
		System.out.println("Cyan Value: " + c);
		double m = (w-(green/255))/w;
		System.out.println("Magenta Value: " + m);
		double y =  (w-(blue/255))/w;
		System.out.println("Yellow Value: " + y);
		double k = 1-w;
		System.out.println("Black Value: " + k);
		kbd.close();
	}

}
