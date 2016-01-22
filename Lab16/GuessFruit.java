import java.util.*;

public class GuessFruit {
	public static void main(String[] args) {
		String[] fruits = new String[3];
		
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Please input a name of fruit " + (i+1) + " in 3:");
			String fruitName = input.nextLine();
			fruits[i] = fruitName;
		}
		
		for (String fruit: fruits) {
			//System.out.print(fruit + "\t");
			System.out.println("Guess what fruit I am?\t" + fruit.substring(0, 2) + "\t" + fruit.length() + "letters");
			String guess = input.nextLine();
			
			while (!guess.equals(fruit)) {
				System.out.println("Try again\n");
				System.out.println("Guess what fruit I am?\t" + fruit.substring(0, 2) + "\t" + fruit.length() + "letters");
				guess = input.nextLine();
			}
			
			if (guess.equals(fruit)) {
				System.out.println("Correct\n");
			}
		}
	}
}