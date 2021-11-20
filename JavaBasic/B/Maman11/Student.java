
/**
 * This class represents a student. It's a subclass of Person.
 *
 * @author Or Hasson
 * @version 02/11/2020
 */       
public class Student extends Person{
    // Declarations
    protected double _averageGrade;
    protected String[] _courses;
    protected double[] _grades;
    protected int _numberOfCourses;
    protected final int MAX_NUM_OF_COURSES = 10; /* The maximal number of courses
                                                    for a student. */
                                                 
    // Constructors
    /**
     * Constructor of class Student. Constructs a new student. 
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     * @param id The id of the student.
     */
    public Student(String firstName, String lastName,long id){
        super(firstName, lastName, id);
        _averageGrade = 0;
        _courses = new String[MAX_NUM_OF_COURSES];
        _grades = new double[MAX_NUM_OF_COURSES];
        _numberOfCourses = 0;        
    }
    
    /**
     * Constructor of class Student. Constructs a new student. 
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     * @param id The id of the student.
     * @param courses The courses of the student.
     * @param grades The grades of the student.
     */
    public Student(String firstName, String lastName, long id, String[] courses,
                   double[] grades){
        this(firstName, lastName, id);
        _numberOfCourses = courses.length;
        for(int i=0; i<courses.length; i++){
            _courses[i] = courses[i];
            _grades[i] = grades[i];
        } /* End of for that updates _courses and _grades. */
        _averageGrade = this.calculateAverageGrade();
    }       
    
    // Methods
    /**
     * Adds a course to the student if it's posible (the maximal number of courses 
     * per student is 10).
     * @param courseName The name of the new course.
     * @param courseGrade The grade of the new course.
     * @return True if the course was added, otherwise false.
     */
    public boolean addCourse(String courseName, double courseGrade){
        for(int i=0; i<_numberOfCourses; i++){
            if(_courses[i].equals(courseName)){
                return false;
            }
        } /* End of for that checks if the student already has the course. */
        
        if(_numberOfCourses == MAX_NUM_OF_COURSES){
            return false;
        } /* Returns false if adding a course isn't posible. */
        else{
            _courses[_numberOfCourses] = courseName;
            _grades[_numberOfCourses] = courseGrade;
            this.setNumOfCourses(_numberOfCourses+1);
            // Calculates and updates the average grade.
            this.setAverageGrade(this.calculateAverageGrade());
            return true;
        } /* Adds the course and returns true. */
    }
    
    /**
     * Returns the average grade of the student.
     * @return The average grade.
     */
    public double getAverageGrade(){
        return _averageGrade;
    }
    
    /**
     * Returns the number of courses of the student.
     * @return The number of courses.
     */
    public int getNumOfCourses(){
        return _numberOfCourses;
    }
    
    private void setAverageGrade(double averageGrade){
        _averageGrade = averageGrade;
    }
    
    private void setNumOfCourses(int numberOfCourses){
        _numberOfCourses = numberOfCourses;
    }
    
    private double calculateAverageGrade(){
        double gradesSum = 0; /* The sum of all the grades of the student. */
        for (int i=0; i<_numberOfCourses; i++){
            gradesSum += _grades[i];
        } /* End of for that updates gradesSum. */
        /* Returns the average grade. */
        return gradesSum / _numberOfCourses;
    }
    
    /**
     * Return a string representation of the student.
     * @return String representation of the student.
     */  
    public String toString(){
        /* String representation of the student's details. */
        String studentStr = super.toString() + "\n";
        
        if (_numberOfCourses == 0){
            studentStr = studentStr + "\tNo courses";
        } /* End of for updates the string for a student that has no courses. */
        else{
            studentStr = studentStr + "Courses:";
            for (int i=0; i<_numberOfCourses; i++){
                studentStr = studentStr + "\n\t" + _courses[i] + ":\t" +
                             (int) _grades[i];
            } /* End of for that updates the courses and grades int the string. */
        } /* Updates the string for a student that has courses. */
        return studentStr;
    }
}
