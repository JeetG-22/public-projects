package practiceProjects;

public class E {

	public static void main(String[] args) {
		int n = 5;
		int w = n;
		int y = 1;
		for(int i = 0; i < n; i++) {
			for(int space = 1; space < w; space++) {
				System.out.print(" ");
			}
			for(int j = 0; j < y;j++) {
				System.out.print("*");
			}
			System.out.println();
			y++;
			w--;
			
		}
	}

}
