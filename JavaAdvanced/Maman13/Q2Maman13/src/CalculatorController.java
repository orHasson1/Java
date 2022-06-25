/**
 *   Controller for Calculator application.
 */

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.math.BigDecimal;
import java.math.MathContext;

public class CalculatorController {
	private int operatorInd; // the index of the binary operator on the text of the screen
	private boolean mathError; // true if there was a math error in the last expression, otherwise false
	private final String ERROR = "Math ERROR"; // math error message
	private final String START_VALUE = "0"; // the initial value on the screen
	 // the value of operatorInd if screen doesn't contain a binary operator
	private final int NO_OPERATOR = -1;
	
	// instance variable for interacting with GUI TextField component
	@FXML  private TextField screen; 
	
	// initializes operatorInd, mathError and the screen's text
	@FXML
	public void initialize() { 
		operatorInd = NO_OPERATOR;
		mathError = false;
		screen.setText(START_VALUE);
	}
	
	// clear the screen as a reaction to a press on the clear button
	@FXML
	void clearButtonPressed(ActionEvent event) {
		initialize();
	}
	
	// execute the relevant action as a reaction to a user press on a digit button  
	@FXML
	void digitButtonPressed(ActionEvent event) {
		if(!mathError){
			String pressed = ((Button) event.getSource()).getText(); // the pressed button;
			if(screen.getText().equals(START_VALUE)){
				screen.setText(pressed);
			} // if the screen shows "0" - erase the "0" and show the pressed digit
			else{
				screen.setText(screen.getText().concat(pressed));
			} 
		} // if no math error occurred and the 
	}
	
	// execute the relevant action as a reaction to a user press on the equal or a binary operator button  
	@FXML
	void equalOrBinaryOperatorButtonPressed(ActionEvent event) {	
		char lastChar = screen.getText().charAt(screen.getText().length() - 1);
		if(mathError || !(Character.isDigit(lastChar) || lastChar == '.')){
			return;
		}  // if the screen has a binary operator suffix or math error occurred

		BigDecimal result; // the value should be displayed on the screen excluding the new operator

		// finds result
		if(operatorInd == NO_OPERATOR){
			result = new BigDecimal(screen.getText());
		} // if there is only one value on the screen
		else{
			char operator = screen.getText().charAt(operatorInd);
			BigDecimal firstValue =  new BigDecimal(screen.getText(0, operatorInd));
			BigDecimal secondValue = new BigDecimal(screen.getText().substring(operatorInd + 1));

			if(operator == '/' && (secondValue.compareTo(BigDecimal.ZERO) == 0)){
				screen.setText(ERROR);
				mathError = true;
				return;
			} // if the expression is mathematically invalid

		result = findResult(firstValue, secondValue, operator);
		
		result = result.stripTrailingZeros();
		} // if threre is a mathematical expression on the screen

		// displays the result on the screen		
		String pressed = ((Button) event.getSource()).getText(); // the new operator
		if(pressed.equals("=")){
			operatorInd = NO_OPERATOR;
			screen.setText(result.toString());
		} // if the pressed operator is "="
		else{
			operatorInd = result.toString().length();
			screen.setText(result.toString().concat(pressed));
		} // if the pressed operator isn't "="
	}
	
	// execute the relevant action as a reaction to a user press on the negate button  
	@FXML
	void negateButtonPressed(ActionEvent event) {
		if(!mathError){
			String beforeValue = operatorInd == NO_OPERATOR ? "" : screen.getText(0, operatorInd + 1);
			String value = screen.getText().substring(operatorInd + 1);
		
			if(value.startsWith("-")){
				screen.setText(beforeValue.concat(value.substring(1)));
			} // the last value on the screen is negative
			else{
				screen.setText(beforeValue.concat("-" + value));
			} // if the last value on screen is positive
		} // if no math error occurred
	}
	
	// execute the relevant action as a reaction to a user press on the point button  
	@FXML
	void pointButtonPressed(ActionEvent event) {
		if(!mathError){
			if(!(screen.getText().length() - 1 ==  operatorInd ||
			      screen.getText().substring(operatorInd + 1).contains("."))){
				screen.setText(screen.getText().concat("."));
			} // adds a point iff there screen doesn't end with a binary operator and there isn't a point 
			  // in the last value on screen
		} // if no math error occurred
	}
	
	// returns the result of the expression firstValue + operator + secondValue
	private BigDecimal findResult(BigDecimal firstValue, BigDecimal secondValue, char operator){
		switch(operator){
			case '+':
				return firstValue.add(secondValue);
			case '-':
				return firstValue.subtract(secondValue);
			case '*':
				return firstValue.multiply(secondValue);
			default: // if the operator is "/"
				return firstValue.divide(secondValue, MathContext.DECIMAL32);	
		} // calculates and returns the result
	}
}
