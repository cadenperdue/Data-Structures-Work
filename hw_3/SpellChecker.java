import java.util.Scanner;
import java.io.*;

/*
 * This class implements a spell checker application. 
 * This class requires a proper implementation to the StirngSet class.
 */
public class SpellChecker {

  public static void main(String [] args) {

    File f = new File("dictionary");
    
    try {
      Scanner sk = new Scanner(f);
        
      StringSet x = new StringSet();
    
      // Read in the entire dictionary...
      while (sk.hasNext()) {
        String word = sk.next();
        x.insert(word);      
      }
      System.out.println("Dicitonary loaded...");
     
      sk = new Scanner(System.in);
      
      // Keep suggesting alternatives as long as the user makes an input.
      while (sk.hasNext()) {
        String word = sk.next();
        if (x.find(word))
	  System.out.println(word + " is correct.");
        else {
	  System.out.println("Suggesting alternatives ...");
          char[] charArray = word.toCharArray;
          String y = "";
          for(int i = 0; i < word.length(); i++)
          {
              for(int k = 'a'; j< 'a' + 26; j++)
              {
                 y = "";
                  charArray[i] = (char) k;
                  for (int fuk = 0; fuk < charArray.length; fuk++)
                  {
                      y = y + charArray[fuk];
                  }
                  if(!y.equals(word) && x.find(y))
                  {
                      System.out.println(y);
                  }
              }
              charArray = word.toCharArray();
          }
        }
      }
    }

		
        
    
    
    
     catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    } 

  } 

}
