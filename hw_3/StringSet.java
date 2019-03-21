/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that insert a new 
 * String, finds a String key and prints the contents of the data structure resp.
 */
public class StringSet {

  StringNode [] table;		// Hash table - collisions resolved through chaining.
  int size;			// Number of elements actually stored in the structure.
  int capacity;			// Allocated memory (size of the hash table).

  /** 
   * Constructur: initilaizes size, capacity and initial table size.
   */
  public StringSet() {
    size = 0;
    capacity = 100;
    table = new StringNode[capacity];
  }
  public void insert(String key) {

    if (size == capacity) {
      capacity = capacity * 2;
      StringNode [] sarr = new StringNode[capacity];
      for (int i = 0; i < size; i++)
      {
          if (sarr[i] != null)
          {
              for (StringNode head = table[i]; head != null; head.getNext())
              {
                  if(sarr[hash(head.getKey())] == null)
                  {
                      StringNode newOne = new StringNode(head.getKey(), null);
                      sarr[hash(head.getKey())] = newOne;
                  }
                  else
                  {
                      StringNode nextNode = new StringNode(head.getKey(), sarr[hash(head.getKey())], sarr[hash(head.getKey())]);
                      sarr[hash(head.getKey())] = nextNode;
                  }
              }
          }
      }
      table = sarr;
    }
    if(table[hash(key)] == null)
    {
        StringNode a = newStringNode(key, null);
        table[hash(key)] = a;
    }
    else
    {
        StringNode dat = new StringNode(key, table[hash(key)]);
        table[hash(key)] = dat;
    }
    size++;
    }
  public boolean find(String key) {
   int hashish = hash(key);
   for (StrongNode h = table[hashish]; h != null; h.getNext());
   {
       if ((h.getKey().equals(key)))
       {
          return true;
       }
       
       else
       {
            return false;   
       }
  }
}
  /*
   * Prints the contents of the hash table.
   */
  public void print() {
    for(int i = 0; i < size; i++)
    {
        StringNode current = table[i];
        System.out.println(current.getKey());
        while (current.getNext() != null)
        {
            current = current.getNext();
            System.out.println(current.getKey());
        }
  }
}
  /*
   * The hash function that returns the index into the hash table for a string k.
   */
  private int hash(String k) {
    int h = 0;
    for (int i = 0; i < k.length(); i++)
    {
        h = (97 * h + k.charAt + k.charAt(i)) % 100;
    }
    return h;
  }



}
