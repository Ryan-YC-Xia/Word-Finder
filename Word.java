// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA4
// Fall 2021

/**
 * Class Word represents the concept of a Scrabble word.
 * Stores information of the word's content and score.
 * Also implements Comparable for easy sorting.
 */
public class Word implements Comparable<Word> {

   private String content;
   private int score;

   /**
    * Create a word from the given string.
    * 
    * @param str the string given
    */
   public Word(String str) {
      content = str;
      score = ScoreTable.score(str);
   }

   /**
    * The overridden compareTo method.
    * Comparing rules are according to the printing requirements of the Rack class.
    * 
    * @param otherWord
    */
   public int compareTo(Word otherWord) {
      if (score != otherWord.getScore()) {
         return otherWord.getScore() - score;
      } else {
         return content.compareTo(otherWord.getContent());
      }
   }

   /**
    * The overridden toString method.
    * Satisfies the printing requirements of the Rack class.
    */
   public String toString() {
      return score + ": " + content;
   }

   /**
    * Gets the content of a word
    */
   public String getContent() {
      return content;
   }

   /**
    * Gets the score of a word
    */
   public int getScore() {
      return score;
   }

}
