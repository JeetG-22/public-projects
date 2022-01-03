package practiceProjects;

public class PrimeNum {

	public static void main(String[] args) {
		int num = 1000;

		int primeNum = 0;
		for(int i = 0; i < num; i++) {
			if(Math.pow(2, i-1)%i==1 || i/2==1) {
				primeNum++;
			}
			
		}
		System.out.println(primeNum);
		/*count=0;
		for(int j = 2; j <= i/2; j++) {
			if(i%j==0) {
				count++;
			}
		}
		if(count!=0 || i==2) {
			nonPrimeCount++;
		}/*
		System.out.println("Number of Prime: " + (num-nonPrimeCount));
		/*System.out.println(j);
		while(j<=i/2) {
			if(i%j==0) {
				count++;
				break;
				//isPrime=true;
			}
			j++;
		}
		*/
		
		/*count=0;
			for(int j = 2; j <= i/2; j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count!=0 || i==2) {
				nonPrimeNum++;
			}*/
			
		/*for(int i = 0; i < num; i++) {
			if(Math.pow(2, i-1)%i==1 || i/2==1) {
				System.out.println(i);
				primeNum++;
			}
			
		}
		System.out.println(primeNum);
		*/

	}

}
