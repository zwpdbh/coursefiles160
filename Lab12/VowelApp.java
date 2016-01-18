/**
*This App is for Lab 12, part 2, it will read a sentence and count its vowels and consonants.
*/
import java.util.*;

public class VowelApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
//		Sentence str = new Sentence(input.nextLine());  
		Sentence str = new Sentence("abcdefgh igklmn , . () opq rst uvwxyz 123 &^"); // use String for test.
		
		System.out.println("The sentence is :" + "\"" + str + "\"");
		//str.count();
		System.out.println("VowelCount: " + str.numberOfVowel());
		System.out.println("ConsonantCount: " + str.numberOfConsonant());
	}
}