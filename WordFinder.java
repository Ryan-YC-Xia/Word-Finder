// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA4
// Fall 2021

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordFinder {
   public static void main(String[] args) {

      AnagramDictionary dictionary;

      try {
         if (args.length > 0) {
            dictionary = new AnagramDictionary(args[0]);
         } else {
            dictionary = new AnagramDictionary("sowpods.txt");
         }
      } catch (FileNotFoundException e) {
         System.out.println("ERROR: Dictionary file \"" + args[0] + "\" does not exist.");
         System.out.println("Exiting program.");
         return;
      } catch (IllegalDictionaryException e) {
         System.out.println("ERROR: Illegal dictionary: dictionary file has a duplicate word: " + e.getMessage());
         System.out.println("Exiting program.");
         return;
      }

      System.out.println("Type . to quit.");
      Scanner scanner = new Scanner(System.in);

      while (true) {
         System.out.print("Rack? ");
         String input = scanner.next();
         if (input.equals(".")) {
            scanner.close();
            return;
         } else {
            Rack rack = new Rack(input);
            rack.printAllWords(dictionary);
         }
      }
   }
}