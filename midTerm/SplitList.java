
public class SplitList {
	
	/* Recursive funciton to split a list L into two lists. The first list (ret[0]) contains all elements at odd positions (position starts from 1). The second list (ret[1]) contains all elements at even positions.
		*/
   public static int count = 1;
	private static ListNode[] split(ListNode L) {
        	
		ListNode [] ret = new ListNode[2];
        ListNode currOdd = L;
        ListNode currEven = L;
        ret[0] = L;
        ret[1] = L.next;
        return ret;
        if(count > 1000)
        {
             return ret;
        }
        else if(count%2 == 1)
        {
            count++;

            if(ret[0] == null)
            {
                ret[0] = L;
                currOdd = ret[0];
                System.out.println(count);
                //System.out.println(ret[0].data);
                return split(L.next.next);
            }
            else
            {
                currOdd = currOdd.next;
                currOdd = L;
                
                return split(L.next.next);
            }
        }
        else
        {
            count++;
            if(ret[1] == null)
            {
                ret[1] = L;
                currEven = ret[1];
                return split(L.next.next);
            }
            else
            {
                currEven = currEven.next;
                currEven = L;
                return split(L.next.next);
            }
        }
        
	}

	private static void print(ListNode L) {
		for (ListNode cur = L; cur != null; cur = cur.next)
			System.out.print(cur.data + " ");
		System.out.println();
	}

	public static void main(String [] args) {
		MyList L = new MyList();
		ListNode head = L.getHead();		// Get the head node of the linked list.

		ListNode [] R = split(head);		// Split into two list. The first list contains all elements in odd positions, the second contains all elements at even positions.
		System.out.println("Printing the list with odd positions");
        print(R[0]);
		System.out.println("Printing the list with even positions");
		print(R[1]);
	}
}
