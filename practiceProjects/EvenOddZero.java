package practiceProjects;

public class EvenOddZero {

	public static void main(String[] args) {
		int num = 295019000, odd = 0, even = 0, zero = 0; 
		while(num!=0) {
			int digit = num%10;
			if(digit % 10 == 0) {
				zero++;
			}
			else if(digit % 2 == 0) {
				even++;
			}
			else {
				odd++;
			}
			num/=10;
		}
		System.out.println("Even: " + even);
		System.out.println("Odd: " + odd);
		System.out.println("Zero: " + zero);

	}

}
