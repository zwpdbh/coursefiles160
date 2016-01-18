import java.util.*;

public class SumofEven {
	/**It let user input a value and calculate the sum of even numbers
	*between 2 and that number.
	*/
	public static void main(String[] args) {
		int sum = 0;
		int count = 2;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer greater than 1:");
		int endNum = input.nextInt();
		if (endNum < 2) {
			System.out.println("Input value must not be less than 2");
			return ;
		}
		while (count <= endNum) {
			sum = sum + count;
			count += 2;
		}
		System.out.println("Sum of even numbers between 2 and " + endNum + " inclusive is: " + sum);
	}
}