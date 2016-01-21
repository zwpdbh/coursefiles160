import java.util.*;
/**Lab 15*/
public class IntCounterApp {
	/**In a three time repetition:
	*it ask use to input a int and try to find it in a random generated int array.
	*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		for (int i=1; i<=3; i++) {
			System.out.println("\nWhich number do you wish to find?");
			int target = input.nextInt();
			int[] numberArray = makeArray();
			IntCounter intCounter = new IntCounter(numberArray);
			intCounter.showTarget(target);
		}
		
		System.out.println("\nFinished");
	}
	
	/**it generates a random int[] with length randomly between 5-10 and the element in the array is also random generated randomly between 0-4
	*then it return the int[]
	*/
	public static int[] makeArray() {
		Random generator = new Random();
		int size = generator.nextInt(6) + 5; // random number between 5-10;
		int[] numList = new int[size];
		for (int i=0; i<size; i++) {
			numList[i] = generator.nextInt(5); // random number between 0-4;
		}
		
		return numList;
	}
}

