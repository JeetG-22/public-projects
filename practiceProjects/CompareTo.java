package practiceProjects;

public class CompareTo {

	public static void main(String[] args) {
		/* .compareTo takes the distance between the first unique characters
		 * in two strings and prints out the difference in the values
		 * (uniqueChar1-uniqueChar2 = distance between unicode value
		 * Can be positive or negative
		 */ 
		
		String word1 = "bfple";
		String word2 = "bear";
		int distance = word1.compareTo(word2);
		System.out.println(distance);

	}

}
