package rutgersIntroProjects;

import java.util.Scanner;

public class RandomWalk {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		int randomNum;
		int positionX = 0, positionY = 0;
		System.out.println("(" + positionX + "," + positionY + ")");
		for (int i = 0; i < n; i++) {
			randomNum = (int) (Math.random() * 4) + 1;
			switch (randomNum) {
			case 1:
				positionX++;
				break;
			case 2:
				positionY++;
				break;
			case 3:
				positionX--;
				break;
			case 4:
				positionY--;
				break;
			}
			System.out.println("(" + positionX + "," + positionY + ")");
		}
		double distance = Math.pow(positionX, 2) + Math.pow(positionY, 2);
		System.out.println("Squared distance = " + distance);
		kbd.close();

	}

}
