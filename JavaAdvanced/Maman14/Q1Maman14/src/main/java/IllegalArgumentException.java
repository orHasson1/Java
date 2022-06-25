/**
 * The class represents an illegal argument exception.
 */

public class IllegalArgumentException extends Exception {
	// empty constructor
	public IllegalArgumentException() {
		super();
	}
	
	// allows to print a message when the exception happens
	public IllegalArgumentException(String message){
		super(message);
	}
}
