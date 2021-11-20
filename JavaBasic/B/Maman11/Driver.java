 /**
 * The class Driver is used as a tester to the classes Person, Student and
 * ComputerScienceStudent.
 *
 * @author Or Hasson
 * @version 02/11/20
 *///
public class Driver{
    // The class main creates a ComputerScienceStudent array in a size 10. It adds 4 
    // computer science students to the array and prints their details, and afterwards
    // the name of the outstanding studant.
    public static void main(String[] args){ 
        ComputerScienceStudent[] studentsArr = new ComputerScienceStudent[10];
        
        String[] coursesFirstStudent = {"Algorithms", "Compilation", "Calculus II", 
                                        "Data Mining"};
        String[] coursesSecondStudent = {"Algebra I", "Data Mining", "Calculus I", 
                                         "Calculus II"};
        String[] coursesThirdStudent = {"Algebra I", "Compilation", "Calculus II", 
                                         "Algebra II", "Algebra I"};
                                    
        double[] gradesFirstStudent = {70,80,90,100};                            
        double[] gradesSecondStudent = {95,100,90,95};
        double[] gradesThirdStudent = {98,97,100,93,100};
        
        studentsArr[0] = new ComputerScienceStudent("Noy", "Levi", 123456789,
                                                     coursesFirstStudent, 
                                                     gradesFirstStudent, "Python");
        studentsArr[1] = new ComputerScienceStudent("Bar", "Mizrahi", 987654321,
                                                     coursesSecondStudent, 
                                                     gradesSecondStudent, "C++"); 
        studentsArr[2] = new ComputerScienceStudent("Bar", "Cohen", 171921151);
        System.out.println("BELOW IS DATA OF THREE COMPUTER SCIENCE STUDENTS:");
                                                     
        // Testing Constructors and toString.
        /* The output should be:
          "Last Name: Levi, First Name: Noy, ID: 123456789
           Courses:
           	Algorithms:	70
           	Compilation:	80
           	Calculus II:	90
            	Data Mining:	100
           Programming Language is: Python 
            
           "*/
        System.out.println(studentsArr[0]+ "\n"); 
        
        // Test mutators and accessors.
        /* Next in the output, first name should be Dor, the last name Schwarz. 
           (Person's accessors and mutators test).*/
        studentsArr[1].setFirstName("Dor"); 
        studentsArr[1].setLastName("Schwartz");
        System.out.println("Last Name: " + studentsArr[1].getLastName() + 
                           ", First Name: " + studentsArr[1].getFirstName() + 
                           ", ID: " + studentsArr[1].getId());

        /* Next in the output should be four grades and courses (getNumOfCourses 
         * of Student test). */
        String coursesAndGradesStr = "Courses:\t";
        for (int i=0; i<studentsArr[1].getNumOfCourses(); i++){
            coursesAndGradesStr = coursesAndGradesStr + "\n\t" + 
                                  coursesSecondStudent[i] + ":\t" +
                                  (int) gradesSecondStudent[i];
        }
        System.out.println(coursesAndGradesStr);
        
         /* In the next line of the the output, the programming language shoud be 
         * C++ (ComputerScienceStudent's accessor and mutator test) */
        studentsArr[1].setProgrammingLanguage("C++");
        System.out.println("Programming Language is: " +  
                            studentsArr[1].getProgrammingLanguage()+ "\n");
                            
        // Tests addCourse​of Student.
        /* If toString works properly (tested above), the output that describes the
         * courses and the grades of the third student shoud be:
         * Algebra I:	98
	 * Compilation:	97
	 * Calculus II:	100
	 * Algebra II:	93 */
        for(int i=0; i<coursesThirdStudent.length; i++){
            studentsArr[2].addCourse(coursesThirdStudent[i], gradesThirdStudent[i]);
        }
        System.out.println(studentsArr[2] + "\n");
        
        // Tests getAverageGrade of Student.
        /* If getFirstName of Student works properly (tested above), the outstanding
         * student by the output should be Bar.
         */
        String bestStudent = "";
        double bestAverage = 0;
        for(int i=0; i<3; i++){
            if(bestAverage < studentsArr[i].getAverageGrade()){
                bestAverage = studentsArr[i].getAverageGrade();
                bestStudent = studentsArr[i].getFirstName();
            } // End of if that updates the best student.
        } // End of for that finds the best student.
        
        System.out.println("THE OUTSTANDING STUDENT OUT OF THE THREE STUDENTS IS: " +
                            bestStudent);         
    }
}

