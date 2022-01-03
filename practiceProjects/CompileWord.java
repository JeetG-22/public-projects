package practiceProjects;

import java.util.Scanner;

public class CompileWord {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		String str = "Compile";
		String spaces = "";
		for(int i = 0; i < str.length(); i++) {
			System.out.println(spaces + str.charAt(i));
			spaces += " ";
		}
		kbd.close();
		
		
	}

}
