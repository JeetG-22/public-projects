package rutgersIntroProjects;

import java.util.Scanner;

public class RottenTomatoes {

	public static void main(String[] args) {
		String input [] = {"4", "2", "8", "2", "3", "3", "4", "1", "2" , "6"};
		int rows = Integer.parseInt(input[0]);
		int columns = Integer.parseInt(input[1]);
		int arr[][] = new int[rows][columns];
		int k = 2;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(input[k]);
				k++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		int sum = 0;
		int greatestSumIndex = 0;
		for(int j = 0; j < arr[0].length; j++) {
			int rowSum = 0;
			for(int i = 0; i < arr.length; i++) {
				rowSum += arr[i][j];
			}
			if(sum < rowSum) {
				sum = rowSum;
				greatestSumIndex = j;
			}
		}
//		System.out.println(sum);
		System.out.println(greatestSumIndex);

	}

}
