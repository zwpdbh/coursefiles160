/**To decide if a string is palindrome or not, a palindrome string is the string are same from back and forth*/
class PalindromeTester {
	public static void main(String[] args) {
		System.out.println(Palindrome.isPalindrome("aba"));
		System.out.println(Palindrome.isPalindrome("abac"));
		System.out.println(Palindrome.isPalindrome("abba"));
	}
}

class Palindrome {
	public static boolean isPalindrome(String str) {
		if (str.equals("") || str.length()==1) {
			return true;
		} else if (str.charAt(0) == str.charAt(str.length()-1)) {
			String substr = str.substring(1, str.length()-1);
			return isPalindrome(substr);	// recursion 
		} else {
			return false;
		}
	}
}