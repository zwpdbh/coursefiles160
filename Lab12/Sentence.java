/**
* A helper class Sentence, it has method to get the number of vowels and consonant
*/
public class Sentence {
	String str = "";
	private int numberOfVowel = 0;
	private int numberOfConsonant = 0;
	
	/**receive a String to initialize the Sentence class*/
	public Sentence(String str) {
		this.str = str;
		this.count();
	}
	
	/**return the sentence as String*/
	public String toString() {
		return str;
	}
	
	// getters
	/**count the vowels in the str and return it as int */
	public int numberOfVowel() {
		return numberOfVowel;
	}
	
	/**count the consonant in the str and return it as in*/
	public int numberOfConsonant() {
		return numberOfConsonant;
	}
	
	// setters
	/**count each char in the sentence and set the data field*/
	private void count() {
		int count = 0;
		numberOfConsonant = 0;
		numberOfVowel = 0;
		while (count < this.str.length()) {
			//System.out.println(count);
			char ch = this.str.charAt(count);
			if (Character.isAlphabetic(ch)) {
				switch (Character.toLowerCase(ch)) {
					case 'a':
						this.numberOfVowel++;
						break; // !necessary!
					case 'e':
						this.numberOfVowel++;
						break;
					case 'i':
						this.numberOfVowel++;
						break;
					case 'o':
						this.numberOfVowel++;
						break;
					case 'u':
						this.numberOfVowel++;
						break;
					case ' ':
						break;
					default:
						numberOfConsonant++;
						break;
				} //end of switch
				count++;
			} else {
				count++;
				continue;
			}
		}
	}
}