/**
 * This class generates random
 */
 
import java.util.Scanner;

public class CardSolo {
	
	public static boolean matchCard (String cardA, String cardB) {
		// TBD: How will you know if CardA can be matched to cardB?
        // Create substrings for the suit and number of both cards, then compare
        // the two cards, if there is equivalency in either the suit or num, 
        // return true, otherwise return false
        if (cardA == null || cardB == null)
        {
            return false;
        }
        
        String cardASuit = cardA.substring(0, 1);
        String cardANum = cardA.substring(1);
        String cardBSuit = cardB.substring(0, 1);
        String cardBNum = cardB.substring(1);
        if (cardASuit.equals(cardBSuit) && cardANum.equals(cardBNum))
        {
            return false;
        }
        else if (cardASuit.equals(cardBSuit) || cardANum.equals(cardBNum))
            return true;
        else
            return false;
	}
	
	public static void main(String [] args) {
		
		// Need 2 stacks.
		CardStack A = new CardStack();
		CardStack B = new CardStack();
		
		Scanner inputScanner = new Scanner(System.in);
		String inputCard;
        

		// while there is a card in the input.
		while (inputScanner.hasNext()) {
			inputCard = inputScanner.next();
			A.pushCard(inputCard);
            if(A.size() >= 3){
	            while (matchCard(inputCard, A.getTop3Card()) && A.size() >= 3)
                {
                    A.setTop3Card(inputCard);
                    A.popCard();
                    B.pushCard(A.popCard());
                    B.pushCard(A.popCard());
                    while(matchCard(inputCard, A.getTopCard()) && A.size() > 1)
                    {
                        A.popCard();
                        A.setTopCard(inputCard);
                    }
                }
            }
            else if (A.size() > 1)                
            {
                while(matchCard(inputCard, A.getTopCard()))
                {
                    A.popCard();
                    A.setTopCard(inputCard);
                        while (matchCard(inputCard, A.getTop3Card()) && A.size() >= 3)
                        {
                            A.setTop3Card(inputCard);
                            A.popCard();
                            B.pushCard(A.popCard());
                            B.pushCard(A.popCard());
                        }
                    }
                }
                
            while(B.size() > 1)
            {
                A.pushCard(B.popCard());
            }
		}
		
		System.out.print("Number of piles is " + A.size() + ":");
		A.printCardStack();
	}
 
}
