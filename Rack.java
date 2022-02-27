// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA4
// Fall 2021

import java.util.ArrayList;
import java.util.Collections;

/**
 * A Rack of Scrabble tiles
 */
public class Rack {

   private static final int NUMCHAR = 26;

   private String inputString;
   private String rack_unique;
   private int[] element_mult;

   /**
    * Create a rack from the given string input
    * 
    * @param input
    */
   public Rack(String input) {
      inputString = input;
      rack_unique = new String();
      element_mult = new int[NUMCHAR];
      int length = input.length();
      for (int i = 0; i < length; i++) {
         char ch = input.charAt(i);
         int index = rack_unique.indexOf(ch);
         if (index == -1) {
            element_mult[rack_unique.length()] = 1;
            rack_unique += ch;
         } else {
            element_mult[index]++;
         }
      }
   }

   /**
    * Prints all the word made from the current rack using the given dictionary.
    * Printed words are sorted by score, or alphabetically if scores are the same.
    * 
    * @param dictionary the dictoinary used to obtain the word from
    */
   public void printAllWords(AnagramDictionary dictionary) {
      ArrayList<Word> words = new ArrayList<Word>();
      for (String key : allSubsets(rack_unique, element_mult, 0)) {
         for (String anagram : dictionary.getAnagramsOf(StringRegulator.sort(key))) {
            words.add(new Word(anagram));
         }
      }
      Collections.sort(words);
      System.out.println("We can make " + words.size() + " words from \"" + inputString + "\"");
      if (words.size() > 0) {
         System.out.println("All of the words with their scores (sorted by score):");
         for (Word word : words) {
            System.out.println(word.toString());
         }
      }
   }

   /**
    * Finds all subsets of the multiset starting at position k in unique and mult.
    * unique and mult describe a multiset such that mult[i] is the multiplicity of
    * the char unique.charAt(i). PRE: mult.length must be at least as big as
    * unique.length() 0 <= k <= unique.length()
    * 
    * @param unique a string of unique letters
    * @param mult   the multiplicity of each letter from unique.
    * @param k      the smallest index of unique and mult to consider.
    * @return all subsets of the indicated multiset. Unlike the multiset in the
    *         parameters, each subset is represented as a String that can have
    *         repeated characters in it.
    * @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();

      if (k == unique.length()) { // multiset is empty
         allCombos.add("");
         return allCombos;
      }

      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k + 1);

      // prepend all possible numbers of the first char (i.e., the one at position k)
      // to the front of each string in restCombos. Suppose that char is 'a'...

      String firstPart = ""; // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {
         for (int i = 0; i < restCombos.size(); i++) { // for each of the subsets
                                                       // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));
         }
         firstPart += unique.charAt(k); // append another instance of 'a' to the first part
      }

      return allCombos;
   }

}