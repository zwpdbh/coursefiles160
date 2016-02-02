/**Find the greatest common divisor of two positive integer.*/
class BiggestCommonDivisor {
	public static void main(String[] args) {
		System.out.println(DivisorCalc.gcd(10, 5));
		System.out.println(DivisorCalc.gcd(10, 10));
		System.out.println(DivisorCalc.gcd(10, 15));
		System.out.println(DivisorCalc.gcd(10, 20));
		System.out.println(DivisorCalc.gcd(3, 5));
		System.out.println(DivisorCalc.gcd(21, 9));
	}
}

class DivisorCalc {
	public static int gcd(int num1, int num2) {
		if (num1 >= num2 && num1%num2==0) {
			return num2;
		} else if (num1 < num2 && num2%num1==0) {
			return gcd(num2, num1);
		} else {
			return gcd(num2, num1%num2);
		}
	}
}