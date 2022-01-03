package practiceProjects;

public class MedianNum {

	public static void main(String[] args) {
		int a = 6, b = 7, c = 35, d = 10, e = 3;
		int firstMax = (int)(Math.max(a, Math.max(b, Math.max(c, Math.max(d, e)))));
		System.out.println(firstMax);

	}

	
}
