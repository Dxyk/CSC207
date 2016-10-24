package week3lab;

public class Store {
	public void main(String[] args) {
		Author[] authors = {new Author("Russle", "Winder"), new Author("Graham", "Roberts")};
		Book b = new Book("Developing Java Software", authors, "1234567", 1240);
		System.out.println(b);
	}
}
