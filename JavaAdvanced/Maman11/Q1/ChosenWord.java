/**
 * A class represents a secret word for the game.
 */

public class ChosenWord {
	private String _word;
	private String _wordLinesRep;


	public ChosenWord(String word){
		_word = word;
		// "_" as the number of letters in _word
		_wordLinesRep = "";
		for(int i = 0; i <  _word.length(); i++){
			_wordLinesRep  = _wordLinesRep  + "_";
		}     
	}
	
	// returne the secret word
	public String getChosenWord(){
		return _word;
	}
	
	// return a string of "_" X the number of letters in the word
	public String getWordLinesRep(){
		return _wordLinesRep;
	}
}