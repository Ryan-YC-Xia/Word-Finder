// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA4
// Fall 2021

/**
 * Class ScoreTable contains the value about Scrabble scores for scrabble
 * letters. Also contains a method to calculate the total score of a word.
 */
public class ScoreTable {

   public static final int[] LETTERSCORES = { 
      1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 
   };

   /**
    * Evaluate the score of a word according to individual scores of the letters. 
    *
    * @param word a String to be evaluated
    *
    * PRE: word only contains the 52 english characters, either upper case or lower case
    */
   public static int score(String word) {
      String wordLowerCase = word.toLowerCase();
      int score = 0;
      for (int i = 0; i < word.length(); i++) {
         score += LETTERSCORES[wordLowerCase.charAt(i) - 'a'];
      }
      return score;
   }
   
}