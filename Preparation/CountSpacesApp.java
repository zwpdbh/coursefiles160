import java.util.*;

public class CountSpacesApp {
	public static void main(String[] args) {
		String myStr = "Count the spaces in this     sentences , haha ";
		
//		Scanner sc = new Scanner(myStr);
//		sc.useDelimiter(" ");
//		int count = 0;
//		do {
//			count++;
//			System.out.println("The " + count + " word is " + sc.next());
//		} while (sc.hasNext());
		
		int count = 0;
		int space = 0;
		while(count < myStr.length()) {
			System.out.println("The " + count + " ch is " + myStr.charAt(count));
			if (myStr.charAt(count) == ' ') {
				space++;
			}
			count++;
		}
		System.out.println("There are " + space + " spaces");
	}
}