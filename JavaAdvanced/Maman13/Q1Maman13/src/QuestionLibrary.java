/**
 * Class represents a question library of MCQ questions.
 */

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class QuestionLibrary {
	private ArrayList<Question>questions;
	private int questionsNum;
	private int currentQuestionInd; // the index of the first unanswered question in the question library
	private int correctAnswers; // the number of the correctly answered questions in the question library
	private final int MIN_QUESTIONS = 0; // the minimum of questionsNum
	private final int FIRST_QUESTION_IND = 0; 
	private final int MIN_CORRECTS = 0; // the minimum of correctAnswers
	private final  int QUESTION_SIZE = 5; // in lines (1 line for the question + 4 lines for optional answers)
	private final int MAX_SUCCESS_RATE = 100; // the maximal score for correct answers
	private final int POINT_ZERO_LEN = 2; // the length of ".0"
	
	public QuestionLibrary(String fileName) {
		this.questions = new ArrayList<>();
		ArrayList<String>questionData = new ArrayList<>(QUESTION_SIZE);
		questionsNum = MIN_QUESTIONS; 
		
		try(Scanner input = new Scanner(Paths.get(fileName))){
			while(input.hasNextLine()){
				questionData.clear();
				
				for(int i = 0; i < QUESTION_SIZE; i++){
					questionData.add(input.nextLine());
				} // adds the question and the optional answers of it to questionData
		
				questions.add(new Question(questionData)); // adds the question from the file
				questionsNum++; // updates the number of questions
			} // while the given file contains more questions
			
			input.close();
		}catch(IOException e){
			System.out.println("IOException occured");
		}
		
		currentQuestionInd = FIRST_QUESTION_IND;
		correctAnswers = MIN_CORRECTS;
	}
	
	// returns the index of the first question that wasn't answered in the list questions
	public final int getCurrentQuestionInd() {
		return currentQuestionInd;
	}
	
	// returns the current question 
	public Question currentQuestion() {
		return questions.get(currentQuestionInd);
	}
	
	// updates the relevant attributes for the given answer to the current question
	public boolean enterAnAnswer(String answer){
		boolean correct = answer.equals(questions.get(currentQuestionInd).getCorrectAnswer());
		
		if(correct){
			correctAnswers++;
		} // if answer is the correct answer to the current question
		currentQuestionInd++;
		return correct;
	}
	
	// returns true if all the questions in the question library have been answered, otherwise returns false
	public boolean allAnswered(){
		return currentQuestionInd == questionsNum;
	}
	
	// returns the percentage of correctly answered questions out of all the questions
	public String successRate(){
		String score = "" + (double) correctAnswers * MAX_SUCCESS_RATE  / questionsNum;
		
		if(score.endsWith(".0")){
			score = score.substring(0, score.length() - POINT_ZERO_LEN);
		} // remove suffix ".0" if neaded
		return score;
	}	
	
	// initializes to a state where all questions are unanswered
	public void deleteAnsweresData(){
		currentQuestionInd = 	FIRST_QUESTION_IND;
		correctAnswers = MIN_CORRECTS;
	}
}
