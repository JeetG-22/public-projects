package practiceProjects;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStoreIndex {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Input: ");
		String input = kbd.nextLine();
		int length = 0;
		for(int i = 3; i < input.length(); i++) {
			if(i!=3 && input.substring(i,i+1).equals(input.substring(3,4))) {
				length++;
			}
		}
		System.out.println(length);
		int arr[] = new int[length];
		for(int j = 3, i = 0; j < input.length(); j++) {
			if(j!=3 && input.substring(j,j+1).equals(input.substring(3,4))) {
				arr[i]= input.indexOf(input.charAt(j));
				i++;
			}
		}
		System.out.println(Arrays.toString(arr));
		kbd.close();

	}

}
