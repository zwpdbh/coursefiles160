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
//			System.out.println("Guess what fruit I am?\t" + fruit.substring(0, 2) + "\t" + fruit.length() + "letters");
//			String guess = input.nextLine();
//			
//			while (!guess.equals(fruit)) {
//				System.out.println("Try again\n");
//				System.out.println("Guess what fruit I am?\t" + fruit.substring(0, 2) + "\t" + fruit.length() + "letters");
//				guess = input.nextLine();
//			}
			/** do-while is very useful when get user's input and execute it in a conditional loop*/
			String guess;
			do {
				System.out.println("Guess what fruit I am?\t" + fruit.substring(0, 2) + "\t" + fruit.length() + "letters");
				guess = input.nextLine();
				if (guess.equalsIgnoreCase(fruit)) {
					break;
				}
				System.out.println("Try again\n"); //it is natural to put "try again" before next loop
			} while (!guess.equalsIgnoreCase(fruit));

			System.out.println("Correct\n");
		}
	}
}