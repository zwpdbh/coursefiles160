import java.util.*;
import java.awt.print.*;

public class Song {
	private String songLine;
	// Constructor
	public Song(String songLine) {
		this.songLine = songLine;
	}
	
	public String toString() {
		return this.songLine;
	}
	
	public void process() {
		int length = this.songLine.length();

		System.out.println("Length is: " + length);
		System.out.println("The last charatar is :" + this.songLine.charAt(length - 1));

		int theSecondBlank = this.songLine.indexOf(' ', this.songLine.indexOf(' ') + 1);
		
		if (theSecondBlank == -1) {
			theSecondBlank = length;
		} else if (theSecondBlank >= length) {
			theSecondBlank = length - 1;
		}
		System.out.println("The first two words are: " + this.songLine.substring(0, theSecondBlank)); // 7 
		System.out.println("The rest are: " + this.songLine.substring(theSecondBlank));		// endIndex - the ending index, exclusive.
		
		String thirdWord = this.getWord(this.songLine, 3);
		System.out.println("The third word is : " + thirdWord + " and its first letter is " + thirdWord.charAt(0));	// 8 
		
		System.out.println("Upper => " + this.songLine.toUpperCase());	 // 9
		System.out.println(this.songLine + " => " + this.songLine.replace(' ', 'x')); // 10
		System.out.println("The first letter b in the sentence happend at index: " + this.songLine.indexOf("b")); // 11
	}
	
	/** Get the xth word in the line.  */
	private static String getWord(String str, int th) {
		Scanner words = new Scanner(str);
		words.useDelimiter(" ");
		int count = 1;
		String word = "";
		while (words.hasNext()) {
			word = words.next();
			if (count == th) {
				return word;
			}
			count ++;
		}

		if (count - 1 < th) {
			return word = " ";
		}
		return word;
	}
	
//	private static int numOfWords(String str) {
//		Scanner words = new Scanner(str);
//		words.useDelimiter(" ");
//		int count = 0;
//		while (words.hasNext()) {
//			count++;
//		}
//		return count;
//	}
}