/**
 * The class represents a student.
 */

import java.time.LocalDate;

public class Student implements Comparable<Student>{
	private String firstName;
	private String lastName;
	private String id;
	private LocalDate birthDate;
	
	// constructor
	public Student(String firstName, String lastName, String id, int year, int month, int dayOfMonth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		birthDate = LocalDate.of(year, month, dayOfMonth);
	}

	// returns the first name of the student
	public String getFirstName() {
		return firstName;
	}
	
	// returns the last name of the student
	public String getLastName() {
		return lastName;
	}
	
	// returns the id of the student
	public String getId() {
		return id;
	}
	
	// returns the birth date of the student
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	// returns a negative integer, zero, or a positive integer as the student's id  is less than, equal to, 
	// or greater than the other student's id
	@Override
	public int compareTo(Student otherStudent){
		return id.compareTo(otherStudent.getId());
	}
	
	// return String representation of Student object
	@Override
	public String toString() {
		return String.format("Name: %s %s%nID Number: %s%nBirth Date: %s ", 
			getFirstName(), getLastName(), getId(), getBirthDate());
	}
}
