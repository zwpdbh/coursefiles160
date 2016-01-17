import java.time.*;

class DVDApp {
	public static void main(String[] args) {
		DVD myBestDVD = new DVD("Star Wars", "US", 5, "1997");
		
		System.out.println("The info of DVD is :");
		System.out.println(myBestDVD.getName());
		System.out.println(myBestDVD.getZone());
		System.out.println(myBestDVD.getTime());
		
		myBestDVD.setTime("2009");
		System.out.println(myBestDVD.getTime());
	}
	// You can NOT define a class in a class!
}