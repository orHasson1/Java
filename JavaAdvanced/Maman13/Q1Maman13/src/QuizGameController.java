/**
 *   Controller for QuizGame application.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;

public class QuizGameController { 
	// the file exam.txt should contain MCQ questions so that each question consists of 5 lines: the question, 
	// the correct answer and 3 incorrect answers
	private final QuestionLibrary QUESTIONS = new QuestionLibrary("exam.txt");
	private String chosenAnswer; // user's chosen answer to the current question 	
	
	// instance variables that refer to GUI components
	@FXML private Text title;
	@FXML private Text question;
	@FXML private ToggleGroup optionsToggleGroup;
	@FXML private Text message;
	@FXML private Button nextButton;
	@FXML private Button checkButton;
	@FXML private Button finishQuizButton;
	@FXML private Button restartQuizButton;
	
	// initializes for the first game
	@FXML
	public void initialize(){	
		// hides the finish and the restart buttons and disables the check button
		showNode(finishQuizButton, false);
		showNode(restartQuizButton, false);
		checkButton.setDisable(true);
		
		// displays the first question
		displayCurrentQuestion();
	}
	
	// displays the next question of the quiz game 
	private void displayCurrentQuestion(){
		nextButton.setDisable(true); // disables the next button
		
		// updates the text 
		message.setText("");
		title.setText("Question " + (QUESTIONS.getCurrentQuestionInd() + 1));
		question.setText(QUESTIONS.currentQuestion().getQuestion());
		QUESTIONS.currentQuestion().shuffleAnswers();	
		
		for(int i = 0; i < optionsToggleGroup.getToggles().size(); i++){
			((Node) optionsToggleGroup.getToggles().get(i)).setDisable(false);
			((RadioButton) optionsToggleGroup.getToggles().get(i)).
			setText(QUESTIONS.currentQuestion().getOptions().get(i));
		} // updates the optional answers
	}
	
	// execute the relevant actions as a reaction to a user click on a radio button of an optional answer
	@FXML
	void optionButtonMouseClicked(MouseEvent event) {
		checkButton.setDisable(false);
		chosenAnswer = ((RadioButton) event.getSource()).getText();
	}
	
	// execute the relevant actions as a reaction to a user press on the check button
	@FXML
	void checkButtonPressed(ActionEvent event) {
		// disables the check button and the optional answers' radio buttons
		checkButton.setDisable(true);
		optionsToggleGroup.getToggles().forEach(radioButton ->  {((Node) radioButton).setDisable(true);});
		
		// informs the user whether the answer was correct or incorrect
		if(QUESTIONS.enterAnAnswer(chosenAnswer)){
			message.setText("CORRECT");
		} // if the user answered correctly
		else{
			message.setText("INCORRECT");
		} // if the user didn't answered correctly
		
		// executes the relevant action whether it's the end of the quiz or not
		if(QUESTIONS.allAnswered()){
			showNode(finishQuizButton, true);
		} // if the user answered all the questions
		else{
			nextButton.setDisable(false);
		} // if it isn't the end of the quiz
	}
	
	// execute the relevant actions as a reaction to a user press on the next button
	@FXML
	void nextButtonPressed(ActionEvent event) {
		optionsToggleGroup.getSelectedToggle().setSelected(false);
		displayCurrentQuestion();
	}
	
	// execute the relevant actions as a reaction to a user press on the finish quiz button
	@FXML
	void finishQuizButtonPressed(ActionEvent event) {
		// hides or shows the relevant buttons
		showNode(nextButton, false);
		showNode(checkButton, false);
		optionsToggleGroup.getToggles().forEach(radioButton -> {showNode((Node) radioButton, false);});
		showNode(restartQuizButton, true);
		showNode(finishQuizButton, false);
		
		// imform the user about the success rate of the quiz game
		question.setText("");
		title.setText("Quiz Result");
		message.setText("Your score is: " + QUESTIONS.successRate());
	}
	
	// execute the relevant actions as a reaction to a user press on the restart button
	@FXML
	void restartQuizButtonPressed(ActionEvent event) {
		QUESTIONS.deleteAnsweresData(); // initialize the data about the quiz game
		
		// enable optional answers' radio buttons
		optionsToggleGroup.getToggles().forEach(radioButton -> {showNode((Node) radioButton, true);
		                                                                     ((Node) radioButton).setDisable(false);});
		
		// hides or shows the relevant buttons
		question.setVisible(true);
		nextButton.setVisible(true);
		checkButton.setVisible(true);
		restartQuizButton.setVisible(false);
		optionsToggleGroup.getSelectedToggle().setSelected(false);
		
		// displays the first question
		displayCurrentQuestion();
	}
	
	// displays the given node if show is true, otherwise hides it
	private void showNode(Node node, boolean show){
		node.setVisible(show);
		node.setManaged(show);
	}
}
