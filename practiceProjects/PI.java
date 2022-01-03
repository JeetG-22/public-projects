package practiceProjects;

public class PI {

	public static void main(String[] args) {
		int numIterations = 3;
		double numerator = 1, denom = 1;
		double pi = 1;
		int count = 0;
		while(count<=numIterations) {
			pi+=numerator/denom * 4.0;
			numerator*=-1;
			denom+=2;
			count++;	
		}
		System.out.println("PI: " + pi);

	}

}
