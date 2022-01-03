package practiceProjects;

import java.util.Arrays;

public class DuplicatesInArrayInteger {

	public static void main(String[] args) {
		Integer arr[] = {14,0,12,14,14,12,0};
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					arr[i]=null;
				}
			}
			if(arr[i]!=null) {
				count++;
			}
		}
		int newArr[] = new int[count];
		for(int i = 0, j = 0; i < arr.length; i++) {
			if(arr[i]!=null) {
				int temp = arr[i];
				arr[i] = newArr[j];
				newArr[j] = temp;
				j++;
			}
		}
		System.out.println(Arrays.toString(newArr));

	}

}
