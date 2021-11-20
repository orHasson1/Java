/**
 * This class represents a person.
 *
 * @author Or Hasson
 * @version 02/11/2020
 */       
public class Person{
    // Declarations
    protected String _firstName;
    protected long _id;
    protected String _lastName;
    
    // Constructor
    /**
     * Constructor of class Person. Constructs a new person. 
     * @param firstName The first name of the person.
     * @param lastName The last name of the person.
     * @param id The id of the person.
     */
    public Person(String firstName, String lastName, long id){
       _firstName = firstName;
       _lastName = lastName;
       _id = id;
    }
    
    // Methods
    /**
     * Returns the first name of the person.
     * @return The first name.
     */
    public String getFirstName(){
       return _firstName;
    }
    
    /**
     * Returns the id of the person.
     * @return The id.
     */
    public long getId(){
       return _id;
    }
    
    /**
     * Returns the last name of the person if it's given.
     * @return The last name.
     */
    public String getLastName(){
       return _lastName;
    }
    
    /**
     * Updates the first name of the person.  
     * @param firstName The new name for the person.
     */   
    public void setFirstName(String firstName){
        _firstName = firstName;
    }
    
    /**
     * Updates the last name of the person.  
     * @param lastName The new name for the person.
     */  
    public void setLastName(String lastName){
        _lastName = lastName;
    }
    
    private void setId(long id){
        _id = id;
    }
    
    /**
     * Return a string representation of the person.
     * @return String representation of the person.
     */  
    public String toString(){
        return ("Last Name: " + _lastName + ", First Name: " + _firstName + 
                ", ID: " + _id);
    }
}
