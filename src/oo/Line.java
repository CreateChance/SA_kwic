package kwic.oo;

import java.util.ArrayList;

/**
 * Class to save all string words of one line.
 * 
 * @author Baniel Gao
 *
 */
public class Line {
	
	// words of one line
	private ArrayList<String> words_ = new ArrayList<>();
	
	/**
	 * set a char to one word.
	 * 
	 * @param ch char to set
	 * @param pos position of word to set
	 * @param whichWord which word to set
	 * 
	 * @return void
	 */
	public void setChar(char ch, int pos, int whichWord) {
		char[] word;
		
		if (whichWord < words_.size()) {
			word = words_.get(whichWord).toCharArray();
			word[pos] = ch;
			words_.set(whichWord, new String(word, 0, word.length));
		}
	}
	
	/**
	 * get a char of one word.
	 * 
	 * @param pos position of the char
	 * @param whichWord which word to get
	 *  
	 * @return char
	 */
	public char getChar(int pos, int whichWord) {
		char result = 0;
		
		if (whichWord < words_.size()) {
			char[] word = words_.get(whichWord).toCharArray();
			result = word[pos];
		}
		
		return result;
	}
	
	/**
	 * add a char to ont word
	 * 
	 * @param ch char to add
	 * @param whichWord which word to add
	 */
	public void addChar(char ch, int whichWord) {
		char[] word;
		char[] new_word;
		
		if (whichWord < words_.size()) {
			word = words_.get(whichWord).toCharArray();
			new_word = new char[word.length + 1];
			new_word[word.length] = ch;
			words_.set(whichWord, new String(new_word, 0, word.length + 1));
		}
	}
	
	/**
	 * delete a char from a word
	 * 
	 * @param pos position to delete
	 * @param whichWord which word to delete
	 */
	public void deleteChar(int pos, int whichWord) {
		StringBuffer word;
		
		if (whichWord < words_.size()) {
			word = new StringBuffer(words_.get(whichWord));
			word.deleteCharAt(pos);
			words_.set(whichWord, word.toString());
		}
	}
	
	/**
	 * get char count of one word
	 * 
	 * @param whichWord which word to get
	 * @return int char counts of one word
	 */
	public int getCharCount(int whichWord) {
		int count = -1;
		
		if (whichWord < words_.size()) {
			count = words_.get(whichWord).length();
		}
		
		return count;
	}
	
	/**
	 * change one word content to new one.
	 * 
	 * @param word new word to set
	 * @param whichWord which word to set
	 */
	public void setWord(char[] word, int whichWord) {
		setWord(new String(word), whichWord);
	}
	
	/**
	 * change one word content to new one
	 * 
	 * @param word new word to set
	 * @param whichWord which word to set
	 */
	public void setWord(String word, int whichWord) {
		if (whichWord < words_.size()) {
			words_.set(whichWord, word);
		}
	}
	
	/**
	 * get one word from a line.
	 * 
	 * @param whichWord which word to get
	 * @return String word if exists, otherwise null.
	 */
	public String getWord(int whichWord) {
		String word = null;
		
		if (whichWord < words_.size()) {
			word = words_.get(whichWord);
		}
		
		return word;
	}
	
	/**
	 * add a word to line.
	 * 
	 * @param word
	 */
	public void addWord(char[] word) {
		addWord(new String(word));
	}
	
	/**
	 * add a word to line.
	 * 
	 * @param word
	 */
	public void addWord(String word) {
		words_.add(word);
	}
	
	/**
	 * add am empty word to line.
	 * 
	 */
	public void addEmptyWord() {
		words_.add(new String());
	}
	
	/**
	 * delete one word from one line
	 * 
	 * @param whichWord which word to delete.
	 */
	public void deleteWord(int whichWord) {
		if (whichWord < words_.size()) {
			words_.remove(whichWord);
		}
	}
	
	/**
	 * get word count of one line.
	 * 
	 * @return int word count of one line.
	 */
	public int getWordCount() {
		int count = 0;
		
		count = words_.size();
		
		return count;
	}
	
	
}
