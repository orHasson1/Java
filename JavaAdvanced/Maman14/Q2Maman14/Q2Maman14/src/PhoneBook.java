/**
 * The class represents a phone book.
 */

import java.util.TreeMap;
import java.util.SortedMap;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Iterator;
import java.io.FileWriter;

public class PhoneBook {
	// the keys of contacts are the names and the values are the phone numbers
	private TreeMap<String, String> contacts;
	
	// constructs an empty phone book
	public PhoneBook() {
		this.contacts = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
	}
	
	 // returns the contacts
	public TreeMap<String, String> getContacts() {
		return contacts;
	}
	
	// receives a text file of contacts (each odd  line i in the file is a name of a contact, and line i+1 is  the
	// phone number of him/her), and adds them  to the phone book
	public void addAllContacts(File file){
		try(Scanner input = new Scanner(file)){
			while(input.hasNextLine()){
				contacts.put(input.nextLine(), input.nextLine());
			}
				input.close();
		}catch(IOException e){
			System.out.println("IOException occured");
		}
	}
	
	// erases all the contacts of the phone book
	public void clearPhoneBook(){
		contacts.clear();
	}
	
	// if the phone book doesn't contain the received contact name, adds the contact to the phone book and
	// return true, otherwise returns false
	public boolean addContact(String name, String phoneNumber){
		if(contacts.containsKey(name)){
			return false;
		} // if the contact already exists in the phone book
		
		contacts.put(name, phoneNumber);
		return true;
	}
	
	// updates the phone number of a contact
	public void editContact(String name, String newPhoneNum){
		contacts.replace(name, newPhoneNum);
	}
	
	// deletes a contact
	public void deleteContant(String name){
		contacts.remove(name);
	}
	
	// return a submap of all the contancs with a given name/preffix of a given name
	public SortedMap<String, String> searchContact(String name) {
		return contacts.subMap( name, name + Character.MAX_VALUE);
	}
	
	// returns a text file of all the contacts of in the phone book (each odd  line i in the file is a name of a 
	// contact, and line i+1 is  the hone number of him/her)
	public void phoneBookFile(String file) throws IOException {
		try(FileWriter fileWriter = new FileWriter(file)){
			Iterator iterator = contacts.keySet().iterator();
			String key;
		
			while(iterator.hasNext()){
				key = (String) iterator.next();
				fileWriter.write(key + System.lineSeparator());
				fileWriter.write(contacts.get(key) + System.lineSeparator());
			}
		
			fileWriter.close();
		}
	}
}
