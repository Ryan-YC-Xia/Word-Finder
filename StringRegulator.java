// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA4
// Fall 2021

import java.util.Arrays;

/**
 * A class containing the static sorting method for a String.
 */
public class StringRegulator {
   /**
    * Returns an alphabetically sorted version of the given String. 
    *
    * @param str the string to be sorted
    */
   public static String sort(String str) {
      char charArray[] = str.toCharArray();
      Arrays.sort(charArray);
      return new String(charArray);
   }
}