package rutgersIntroProjects;

import java.util.Scanner;

public class FindDuplicate {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 3, 1, 5 };
		boolean hasDuplicate = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(i==4) {
					System.out.println(arr[j]);
				}
				if (arr[i] == arr[j]) {
					hasDuplicate = true;
					break;
				}
			}
			if (hasDuplicate) {
				break;
			}
		}
		//System.out.println(hasDuplicate);
	}

}
