package week3lab;

public class Store {
	public void main(String[] args) {
		Author a1 = new Author("Russle", "Winder");
		Author a2 = new Author("Graham", "Roberts");
		Author[] authors = {a1, a2};
		Book b = new Book("Developing Java Software", authors, "1234567", 1240);
		System.out.println(b);
	}
}
