/**
 * A class represents a game of guessing a secret words. The rules of the game 
 * described on maman 11, question 1.
 */

import java.util.Scanner;
import java.util.Arrays;

public class Game {
	private Vocabulary _wordsVoc; 
	private String _secretWord;
	private int _guessesNum;    
	private String _gamesState;  // a string of the relevant chars and lines without sapces
	private boolean _won;
	private String _alreadyChosen;  // a string of the relevant chars without any separation 
	final static String ABC = "abcdefghijklmnopqrstuvwxyz";
	Scanner scan = new Scanner(System.in);

	// possible output messages for the game
	final String INVALID_INPUT_MSG = "Invalid input! Please try again!";
	final String NEXT_CHOICE_OPT = "\nLetters that haven't been chosen:\n";
	final String NEXT_GUESS_MSG = "\nEenter a guessed letter:";
	final String NUMBE_OF_GUESSES_MSG = "The number of guesses:";
	final String NEW_GAME_MSG = "Enter \"yes\" if you want to start a new game!";
	final String SEPARATOR = "#######";

	// initialize for a new game
	public Game(Vocabulary wordsVoc){
		_wordsVoc = wordsVoc;
		// Chooses a randon word from the vocabulary
		ChosenWord chosenWord = new ChosenWord(_wordsVoc.chooseRandomWord());
		_secretWord = chosenWord.getChosenWord();
		_gamesState = chosenWord.getWordLinesRep();
		_won = false;
		_alreadyChosen = ABC;  
	}

	// start a new game
	public void executeGame(){
		// as long as the player has not won yet
		while(!_won){
			// print the relevant data for the new round of the game
			newRoundOutput();
			// get the user's guess
			String guess = scan.nextLine().toLowerCase();
			System.out.println("\n" + SEPARATOR);

			if (validGuess(guess)){ // update the relevant data if the last guess was valid
				updateGamesData(guess);
			} 
			
			else{  // ask the player for another guess if the last one was invalid
			   System.out.println(INVALID_INPUT_MSG); 
			}
		}

		// end the current game if the player won
		gameEnded();
	}  

	// print the relevant data for the current round of the game
	private void newRoundOutput(){
		// print for example: _ _ s t _ (the user guessed corectly s and t)
		System.out.println(_gamesState.replace(""," "));

		// print for example: [a, d] (the user already tried to guess a and d)
		System.out.println(NEXT_CHOICE_OPT +
						   Arrays.toString(_alreadyChosen.split("")));

		// ask the to make a guess
		System.out.println(NEXT_GUESS_MSG);
	}

	// update the relevant data after a valid guess
	private void updateGamesData(String lastChoice){
		updateGamesState(lastChoice);
		updateAlreadyChosen(lastChoice);
		_guessesNum++;
		wonTheGame();
	}

	// tell the user what was the number of his/her guesses in the last game (only valid guesses)
	// and ask for a new game (isn't case sensitive)
	private void gameEnded(){
		System.out.println(_secretWord + "\n");
		System.out.println(NUMBE_OF_GUESSES_MSG + _guessesNum);
		System.out.println(NEW_GAME_MSG);
		String answer = scan.nextLine().toLowerCase();
		
		// if the player wants to play a new game
		if(answer.toLowerCase().equals("yes")){
			startNewGame(); 
		}
	}
	
	// update _won value if necessary
	private void wonTheGame(){
		_won = _gamesState.indexOf('_') == -1;
	}

	// start a new game (not the first game of the player)
	private void startNewGame(){
		Game newGame = new Game(_wordsVoc);
		newGame.executeGame();    
	}

	// return true if the last guess was volid, otherwise return false
	private boolean validGuess(String guess){
		 return (guess.length() == 1) && Character.isLowerCase(guess.charAt(0));
	}

	// update _gamesState value if necessary
	private void updateGamesState(String lastGuess){
		for (int i = 0; i < _secretWord.length(); i++){
			if(_secretWord.charAt(i) == lastGuess.charAt(0)){
				_gamesState = _gamesState.subSequence(0, i) + lastGuess +
					                _gamesState.substring(i+1);
			}
		}   
	}

	// update _alreadyChosen value if necessary
	private void updateAlreadyChosen(String lastGuess){
		_alreadyChosen = _alreadyChosen.replaceAll(lastGuess, "");
	}
}

