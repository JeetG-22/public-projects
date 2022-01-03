package practiceProjects;

public class TestingPrograms {
	
	public static void main(String [] args) {
		int n = 28;
		int nl = n/2+1;
		int nst = 1;
		int nsp = n/2;
		for(int i = 0; i < nl; i++) {
			for(int k = 0; k < nsp; k++) {
				System.out.print(" ");
			}
			for(int j = 0; j<nst;j++) {
				System.out.print("*");
			}
			System.out.println();
			nsp--;
			nst+=2;
		}
		nl = n/2;
		nst-=4;
		nsp = 1;
		for(int i = 0; i < nl; i++) {
			for(int k = 0; k < nsp; k++) {
				System.out.print(" ");
			}
			for(int j = 0; j<nst;j++) {
				System.out.print("*");
			}
			System.out.println();
			nsp++;
			nst-=2;
		}
		
		
	}

}
 