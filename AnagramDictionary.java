// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA4
// Fall 2021

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * A dictionary of all anagram sets. Note: the processing is case-sensitive; so
 * if the dictionary has all lower case words, you will likely want any string
 * you test to have all lower case letters too, and likewise if the dictionary
 * words are all upper case.
 */
public class AnagramDictionary {

   HashMap<String, HashSet<String>> dictionary = new HashMap<String, HashSet<String>>();

   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName.
    * 
    * @param fileName the name of the file to read from
    * @throws FileNotFoundException      if the file is not found
    * @throws IllegalDictionaryException if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException, IllegalDictionaryException {
      InputStream file = new FileInputStream(fileName);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNext()) {
         String word = scanner.next();
         String reg = StringRegulator.sort(word);
         if (!dictionary.containsKey(reg)) {
            HashSet<String> anagrams = new HashSet<String>();
            anagrams.add(word);
            dictionary.put(reg, anagrams);
         } else {
            if (!dictionary.get(reg).add(word)) {
               scanner.close();
               throw new IllegalDictionaryException(word);
            }
         }
      }
      scanner.close();
   }

   /**
    * Get all anagrams of the given string. This method is case-sensitive. E.g.
    * "CARE" and "race" would not be recognized as anagrams.
    * 
    * @param string string to process
    * @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String string) {
      if(dictionary.containsKey(string)){
         return new ArrayList<String>(dictionary.get(StringRegulator.sort(string)));
      }
      return new ArrayList<String>();
   }

}