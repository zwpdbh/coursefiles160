class BookApp {
	public static void main(String[] args) {
		Book mybook1 = new Book();
		Book mybook2 = new Book();
		Book mybook3 = new Book();
		
		mybook1.setTitle("Life of Pi");
		mybook1.setPages(348);
		mybook1.setPrice(28.90);
		
		mybook2.setTitle("Mister Pip");
		mybook2.setPages(240);
		mybook2.setPrice(22.70);
		
		mybook3.setTitle("Hyperion");
		mybook3.setPages(698);
		mybook3.setPrice(97);
		
		mybook1.displayBook();
		mybook2.displayBook();
		mybook3.displayBook();
	}
}