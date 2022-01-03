package practiceProjects;

public class C {

	public static void main(String[] args) {
		int n = 5;
		int w = n;
		for(int i = 0; i < n; i++) {
			for(int j = w; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
			w--;
		}

	}

}
