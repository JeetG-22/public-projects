package practiceProjects;

public class UniformRandomNumbers {

	public static void main(String[] args) {
		double num1 = Math.random();
		System.out.println("Number 1: " + num1);
		double num2 = Math.random();
		System.out.println("Number 2: " + num2);
		double num3 = Math.random();
		System.out.println("Number 3: " + num3);
		double num4 = Math.random();
		System.out.println("Number 4: " + num4);
		double num5 = Math.random();
		System.out.println("Number 5: " + num5);
		
		System.out.println("Max: " + Math.max(num1, Math.max(num2, Math.max(num3, Math.max(num4, num5)))));
		System.out.println("Min: " + Math.min(num1, Math.min(num2, Math.min(num3, Math.min(num4, num5)))));
		
		double average = (num1+num2+num3+num4+num5)/5;
		System.out.println("Average: " + average);

	}

}
