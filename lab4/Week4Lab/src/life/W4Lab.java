package life;

public class W4Lab {

	public static void main(String[] args) {
		Organism lobster = new Arthropod("Homarus gammarus", 0, 0, 2, "north", 10);
		System.out.println(lobster);
		lobster.move();
		System.out.println(lobster);
	}

}
