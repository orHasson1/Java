/**
 *  Tests the AssociationTable generic class for values of type Student and keys of type String.
 */

import java.util.Iterator;

public class AssociationTableTest {
	public static void main(String[] args){
		// creates 3 in instances of Student class 
		Student studentA = new Student("Daniel", "Levi", "111111111", 1996, 10, 16);
		Student studentB= new Student("Noy", "Cohen", "222222222", 1987, 3, 8);
		Student studentC = new Student("Dor", "Bar", "333333333", 2000, 6, 1);
		Student studentD = new Student("Lilah", "Golan", "444444444", 1991, 7, 12);
		
		try{
			// creates an array of 3 students an array of them phone numbers 
			Student[] students = {studentA, studentB, studentC};
			String[] phoneNumbers = {"052-2222222", "054-4444444", "051-1111111"};
		
			// creates an association table of 3 students so that for each i students[i] will be a key and its
			// value will be phoneNumbers[i]
			AssociationTable<Student, String> associationTable = new <Student, String>AssociationTable
		                                                                                                 (students, phoneNumbers);
		
			associationTable.add(studentD, "053-3333333"); // adds studentD to the association table
			associationTable.add(studentA, "050-0000000"); // updates the phone number of studentA
			associationTable.remove(studentC); // removes studentC from the association table

			// prints the standart output of the sorted association table of the students
			Iterator<Student> it = associationTable.keyIterator();
			Student currentStudent;
			System.out.printf("%s %47s %n", "STUDENT", "PHONE NUMBER");
			
			while(it.hasNext()){
				currentStudent = it.next();
				System.out.println("------------------------------------------------------------------------");
				System.out.printf("%s %30s %n", currentStudent.toString(), 
					                    associationTable.get(currentStudent));
			}
		} catch(IllegalArgumentException e){
			System.out.println("The students' and the phone numbers' arrays haven't the same size");	
		}
	}
}

