/**
 *  This class contains a stack of cards.
 *
 */
public class CardStack {
	private String [] cards;	// Stack implemented as an array.
	private int top;		// accessing the top element of the stack.
	
	/* Constructor, to initialize a stack of 100 cards. */	
	public CardStack() {
		cards = new String[100];
		top = -1;
	}

	/* Push a card into the stack. You may assume that the stack size is not longer than 52. */
	public void pushCard(String card)
    {
         if(top < 99){
            cards[top+1] = card;
            top++; 
         }
	}
	
	/* Pop and return the popped card from the stack. Return null if trying to pop from an empty stack. */
	public String popCard() {	
        if (cards[0] == null)
        {
            return null;
        }
        else
        {
            String c = cards[top];
            setTopCard(null);
            top--;
            return c;
        }
	}
	
	/* Get the top card. Return null if stack is empty. */
	public String getTopCard() {
		if (cards[top] == null)
        {
            return null;
        }
        else
        {
            return cards[top];
        }
	}
	
	/* Get the third card from the top. Return null if there are less than 3 cards in the stack. */
	public String getTop3Card() {
		if (cards[2] == null)
        {
            return null;
        }
        else
        {
             int i = 0;
             while(cards[i] != null)
             {
                 i++;
             }
             return cards[i-2];
        }
	}
	
	/* Set the top card. Throw an IllegalArgumentException if stack is empty with an appropriate message. */
	public void setTopCard(String card) {
		if(cards[0] == null)
        {
            throw new IllegalArgumentException("Please add a card to the stack");
        }
        else
        {
            cards[top] = card;
        }
	}
	
	/* Set the third car from the top. Throw an IllegalArgumentException if stack doesn't have 3 cards with an appropriate message. */
	public void setTop3Card(String card) {
	if(cards[0] == null)
        {
            throw new IllegalArgumentException("Please add a card to the stack");
        }
        else
        {
            int i = 0;
            while(cards[i] != null)
            {
                i++;
            }
            cards[i - 2] = card;
        }	
	}
	
	/* Return the size of the stack. */
	public int size() 
    {
        return top += 1;	     
	}
	
	/* Print the entire stack. */
	public void printCardStack() {
	    int i = 0;
            while(cards[i] != null)
            {
	        	System.out.print(cards[i]);
                i++;
            }
	}
}
