import java.util.*;

public class AnagramsApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
//		String phrase1 = input.nextLine();
//		String phrase2 = input.nextLine();
//	
//		Boolean anagram = process(phrase1, phrase2);
		


		Boolean[] results = {
			process("Resistance", "Ancestries"),
			process("Gainly", "Laying"),
			process("Admirer", "Married"),
			process("Orchestra", "Carthorse"),
			process("Creative", "Reactive"),
			process("Deductions", "Discounted"),
			process("Listen", "Silent"),
			process("Paternal", "Parental"),
			process("Angered", "Angered"),
			process("A highwayman", "Away! Hang him!"),
			process("Internal Revenue Service", "I never return even a slice."),
			process("Shakespeare", "Seek a phrase."),
			process("Received payment", "Paid me every cent.")
		};
		
		for (Boolean anagram:results){}
		
	}
	
	/**it takes two strings and compare them, then return a boolean value to indicate they are anagram of each other or not*/
	private static boolean process(String str1, String str2) {
		String sorted1 = sortString(str1);
		String sorted2 = sortString(str2);
		
		if (sorted1.equals(sorted2)) {
			System.out.println(str1 + "\t is an anagram of \t" + str2);
			return true;
		} else {
			System.out.println(str1 + "\t is NOT an anagram of \t" + str2);
			return false;
		}
	}
	
	/**it takes a string and sort it based on the rule, then return the sorted string*/
	private static String sortString(String str) {
		String all = "abcdefghigklmnopqrstuvwxyz";
		String lowerStr = str.toLowerCase();
		String empty = "";
		for (int i=0; i<all.length(); i++) {
			for (int j=0; j<lowerStr.length(); j++) {
				if (lowerStr.charAt(j) == all.charAt(i)) {
					empty += lowerStr.charAt(j);
				}
			}
		}
		//System.out.println(empty + " are the letters of " + str + " in order");
		return empty;
	}
}
