package jdbc;

public class Person {

	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Object getFirstName() {
		return firstName;
	}
	
	public Object getLastName() {
		return lastName;
	}

}
