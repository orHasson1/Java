/**
 * This class represents a computer science student. It's a subclass of Student.
 *
 * @author Or Hasson
 * @version 02/11/2020
 */       
public class ComputerScienceStudent extends Student{
    // Declarations
    protected String _programmingLanguage;
    /* The default programming language. */
    protected final String DEFAULT_PROG_LAN = "Java";
    
    // Constructors
    /**
     * Constructor of class ComputerScienceStudent. Constructs a new computer 
     * science student. 
     * @param firstName The first name of the computer science student.
     * @param lastName The last name of the computer science student.
     * @param id The id of the computer science student.
     */
    public ComputerScienceStudent(String firstName, String lastName, long id){
        super(firstName, lastName, id);
        _programmingLanguage = DEFAULT_PROG_LAN;
    }
    
    /**
     * Constructor of class ComputerScienceStudent. Constructs a new computer 
     * science student. 
     * @param firstName The first name of the computer science student.
     * @param lastName The last name of the computer science student.
     * @param id The id of the computer science student.
     * @param courses The courses of the computer science student.
     * @param grades The grades of the computer science student.
     * @param programmingLanguage The programming language of the computer science
     * student.
     */
    public ComputerScienceStudent(String firstName, String lastName, long id, 
                                  String[] courses,double[] grades, 
                                  String programmingLanguage){
        super(firstName, lastName, id, courses, grades);
        _programmingLanguage = programmingLanguage;
    }
    
    // Methods
    /**
     * Returns the programming language of the computer science student.
     * @return The programming language.
     */
    public String getProgrammingLanguage(){
        return _programmingLanguage;
    }
    
    /**
     * Updates the programming language of the computer science student.
     * @param programmingLanguage The new programming language.
     */   
    public void setProgrammingLanguage(String programmingLanguage){
        _programmingLanguage = programmingLanguage;
    }
    
    /**
     * Return a string representation of the computer science student.
     * @return String representation of the computer science student.
     */  
    public String toString(){
        return (super.toString() + "\nProgramming Language is: " +  
                _programmingLanguage);
    }    
}
