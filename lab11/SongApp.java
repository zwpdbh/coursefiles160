class SongApp {
	public static void main(String[] args) {
		Song song1 = new Song("While my guitar gently weeps");
		System.out.println(song1);
		song1.process();
		
		System.out.print("\n");
		Song song2 = new Song("Let it be");
		System.out.println(song2);
		song2.process();
		
//		System.out.println(song1);
//		System.out.println(song2);
		
		System.out.print("\n");
		Song song3 = new Song("Penny Lane");
		System.out.println(song3);
		song3.process();
	}
}