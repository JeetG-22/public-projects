package practiceProjects;

import java.util.Arrays;

public class DuplicatesInArray {

	public static void main(String[] args) {
		int arr[] = {14,0,12,14,14,12,0};
		boolean isDuplicate[] = new boolean[arr.length];
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					isDuplicate[j]=true;
				}
				//System.out.println(isDuplicate[i]);
				
			}
			if(isDuplicate[i]==false) {
				count++;
			}
		}
		//System.out.println(Arrays.toString(isDuplicate));
		int newArr[] = new int[count];
		for(int i = 0, j = 0; i < arr.length; i++) {
			if(isDuplicate[i]==false) {
				int temp = arr[i];
				arr[i] = newArr[j];
				newArr[j] = temp;
				j++;
			}
		}
		System.out.println(Arrays.toString(newArr));
	}

}
