import javax.sound.midi.*;

class TestString {
	public static void main(String[] args) {
		String drink = "Ginger ale";
		
		System.out.println(drink.substring(1));
		System.out.println(drink.substring(3, drink.length()-1));
		
		int first_e = drink.indexOf('e');
		int second_e = drink.indexOf('e', 5);
		System.out.println(first_e);
		System.out.println(second_e);
		
		System.out.println("green tea".indexOf('e', 5));
		
		System.out.println("The second e is at: " + drink.indexOf('e', drink.indexOf('e') + 1));
	}
}