package practiceProjects;

public class ChristmasTree {

	public static void main(String[] args) {
		int n = 10;
		int nsp = n-1;
		int nStC = 1;
		for(int i = 0; i < n; i++) {
			for(int k = 0; k < nsp; k++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= nStC; j++) {
				if(j%2==0) {
					System.out.print("C");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
			nsp--;
			nStC+=2;
			
		}

	}

}
