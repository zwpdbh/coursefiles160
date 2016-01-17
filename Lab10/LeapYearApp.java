/**Lab 10, created by Frank Jan 17, 2016*/

class LeapYearApp {
	public static void main(String[] args) {
		leapYear(2010);
		leapYear(2012);
		leapYear(1900);
		leapYear(2000);
		leapYear(1565);
	}
	
//	public void leapYear(int year) {
//		if (year % 4 == 0 && year % 100 != 0 && year %400 !=0) {
//			System.out.println(year + " is a leap year");
//		} else if (year % 4 != 0) {
//			System.out.println(year + " is not a leap year because it can not be divided by 4");
//		} else if (year % ) {
//			code
//		}
//	}
	
	// Read a year as int and decide if it is a leapyear. 
	public static  void leapYear(int year) {
		if (year < 1582) {
			System.out.println("Error: Gregorian calendar was adopted at 1582.");
			return ;
		}
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					System.out.println(year + " is a leap year");
				} else {
					System.out.println(year + " is not a leap year because it can be devided by 100, however can not be devided by 400");
				}
			} else if (year % 100 != 0 && year % 400 !=0) {
				System.out.println(year + " is a leap year");
			}
		} else {
			System.out.println(year + " is not a leap year because it can not be divided by 4");
		}
	}
}