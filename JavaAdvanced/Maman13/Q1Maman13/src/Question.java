/**
 * Class represents a multiple choice question.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Question {
	private String question; // the question
	private ArrayList<String>options; // the optional answers of the question
	private String correctAnswer; // the correct answer of the question
	private final int QUESTION_IND = 0; // the index of the question in questionData (constructor's param)
	// the index of the correct answer in questionData (constructor's param)
	private final int CORRECT_ANSWER_IND = 1; 
	
	// the constructor receives an array list in which the first object is the question, the second is the 
	// correct answer and the rest are other optional answers
	public Question(ArrayList<String> questionData) {
		question = questionData.get(QUESTION_IND); 
		correctAnswer = questionData.get(CORRECT_ANSWER_IND);
		questionData.remove(QUESTION_IND); // remains only the optional answers
		options = new ArrayList<>();
		options.addAll(questionData);
	}
	
	// returns the question
	public final String getQuestion() {
		return question;
	}
	
	// returns the options
	public final ArrayList<String> getOptions() {
		return options;
	}
	
	// shuffles the array list of the optional answers
	public void shuffleAnswers() {
		Collections.shuffle(options);
	}
	
	// returns the correct answer of the question
	public final String getCorrectAnswer() {
		return correctAnswer;
	}
}
