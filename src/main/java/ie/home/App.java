package ie.home;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static String LongestWord(String sen) { 
		  
	    // code goes here   
	    /* Note: In Java the return type of a function and the 
	       parameter types being passed are defined, so this return 
	       call must match the return type of the function.
	       You are free to modify the return type. */
	    String[] words = sen.split(" ");
	    int length = words[0].length();
	    int index = 0;
	    
	    for (int i = 1; i < words.length; i++) {
	        String word = words[i];
	        
	        if (word.length() > length) {
	            length = word.length();
	            index = i;
	        }
	    }
	       
	    return words[index];
	    
	  } 
	  
	  public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner s = new Scanner(System.in);
	    System.out.print(LongestWord(s.nextLine())); 
	  } 
} 

