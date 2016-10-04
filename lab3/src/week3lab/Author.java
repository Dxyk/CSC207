package week3lab;

public class Author {
	private String first_name;
	private String last_name;
	
	public Author(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public String getFirstName() {
		return this.first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return this.last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String toString() {
		return this.first_name.toString() + ", " + this.last_name.toString();
	} 
	
}
