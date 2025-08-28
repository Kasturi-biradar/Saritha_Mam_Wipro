package MAVEN_JDBC;

public class Lab6 {
	
	    String firstName;
	    String lastName;
	    char gender;

	    public Lab6(String firstName, String lastName, char gender) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.gender = gender;
	    }

	   
	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public char getGender() {
	        return gender;
	    }

	    public static void main(String[] args) {
	       
	       Lab6 person = new Lab6("Divya", "Bharathi", 'F');

	        System.out.println("Person Details:");
	        System.out.println("First Name: " + person.getFirstName() );
	    	System.out.println("Last Name: " + person.getLastName() ); 
	    	System.out.println("Gender: " + person.getGender());
	    }
	}


