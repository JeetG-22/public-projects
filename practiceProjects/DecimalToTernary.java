package practiceProjects;


public class DecimalToTernary {

	public static void main(String[] args) {
		int n = 7;
		int arr[] = new int [32];
		System.out.println(arr.length);
	    int v = 0; 
	    while(n>0) {
	    	arr[v]=n%3;
	    	n=n/3;
	    	v++;
	    }
	    for(int i = arr.length-1;i>=0;i--) {
	    	System.out.print(arr[i]);
	    }

	}

}
