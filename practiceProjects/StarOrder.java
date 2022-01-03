package practiceProjects;

public class StarOrder {

	public static void main(String[] args) {
		int n = 5; 
		int w = n;
		for(int i = 0; i < n;i++) {
			for(int j = 0; j < w;j++) {
				System.out.print("*");
			}
			System.out.println();
			w--;
		}

	}

}
