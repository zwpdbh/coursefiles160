import java.util.*;

public class TestScanner {
	public static void main(String[] args) {
		Scanner word = new Scanner("11 22 33 44 55 66 77 88 99");
		word.useDelimiter(" ");
		
		int count = 1;
		while (word.hasNext()) {
			System.out.println(count + " ==> " + word.next());
			count++;
		}
		System.out.println(count);
	}
}