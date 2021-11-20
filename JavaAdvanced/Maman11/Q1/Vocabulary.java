/**
 * A class represents a vocabulary of english words (maximum 200 words).
 */
import java.util.Random;

public class Vocabulary {
	private String[] _wordsVoc;
	private int _wordsNum;
	final static int MAX_WORDS = 200;
	final static int MIN_WORDS = 0;
	Random rand = new Random();
	
	// create an empty vocabulary that can contain maxinum 200 words
	public Vocabulary(){
		_wordsVoc = new String[MAX_WORDS];
		_wordsNum = MIN_WORDS;
	}

	// if word is an english word add it's lower case version to the vocabulary
	public void addWord(String word){
		if(_wordsNum < MAX_WORDS && this.legalWord(word)){
			_wordsVoc[_wordsNum] = word.toLowerCase();
			_wordsNum++;

		}             
	}

	// return true if word is an english word, otherwise return false
	private boolean legalWord(String word){
		if (word.equals("")){
			return false;
		} // if word is an empty string

		for(int i = 0; i < word.length(); i++){
			if(!(Character.isLetter(word.charAt(i)))){ 
				return false;
			} // if word contains a character that isn't an english letter
		}
		return true;
	}

	// return a random word from the vocabulary
	public String chooseRandomWord(){
		return _wordsVoc[(int) (rand.nextFloat() * _wordsNum)];
	}
}
