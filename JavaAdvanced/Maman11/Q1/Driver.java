/**
 * Driver class of maman 11, question 1.
 */

public class Driver {
	// the main class uses to create a vocabulary for the game and to execute a game 
	public static void main(String[] args){
		// create a new vocavulary
		Vocabulary wordsVoc = new Vocabulary();

		// add words for the vocabulary
		wordsVoc.addWord("dOg");
		wordsVoc.addWord("smIle");
		wordsVoc.addWord("aPartment");
		wordsVoc.addWord("sunsEt");

		// start a new game of guessing a secret word from the vocabulary
		Game game = new Game(wordsVoc);
		game.executeGame();          
	}
}
