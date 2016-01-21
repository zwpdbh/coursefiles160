/**helper class for Lab15*/
public class IntCounter {
	private int[] numArray;
	
	/**the constructor of this class, and print each element in the array and its length while initialize the instance*/
	public IntCounter(int[] numArray) {
		this.numArray = numArray;
		for (int num: numArray) {
			System.out.print(num + " ");
		}
		System.out.println("Array is of length " + this.numArray.length);
	}
	
	/**the instance of IntCounter takes an int as target, then search it through itself, print the index of target if find, or print not find*/
	public void showTarget(int target) {
		boolean haveTarget = false;
		if (target > 4 || target < 0) {
			System.out.println("There are no " + target + " in this array");
			return;
		}
		for (int i=0; i<numArray.length; i++) {
			if (target == numArray[i]) {
				System.out.println("There is a " + target + " in position " + i);
				haveTarget = true;
			}
		}
		
		if (!haveTarget) {
			System.out.println("There are no " + target + " in this array");
		}
	}
}