import java.util.*; // for easy output of arrays with Arrays.toString().

public class Merge3 {
  public static void main(String[] args) 
  {
      
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter array size: ");
    int arrSize = sc.nextInt();
    int[] aarray = new int[arrSize];
    int[] barray = new int[arrSize];
    int[] carray = new int[arrSize];
    System.out.println("Enter 1st array elements: ");
    for(int i = 0; i < arrSize; i++)
    {
        aarray[i] = sc.nextInt();
    }
    System.out.println("Enter 2nd array elements: ");
    for (int i = 0; i < arrSize; i++)
    {
        barray[i] = sc.nextInt();
    }
    System.out.println("Enter 3rd array elements: ");
    for (int i = 0; i < arrSize; i++)
    {
        carray[i] = sc.nextInt();
    }

    int[] d = merge2(aarray, barray);
    d = merge2(d, carray);
    int length = d.length;
    int curr = 0;
    while(curr < length)
    {
        System.out.print(d[curr] + " ");
        curr++;
    }
    System.out.println("");
  }
  public static int[] merge2 (int[] a, int[] b)
  {
      int[] ans = new int[a.length + b.length];
      /*int ith = 0;
      int jth = 0; 
      int kth = 0;
      for (int p = 0; p < d.length; p++)
      {
          d[p] = ith < a.length && (jth >= b.length || a[ith] < b[jth])
            ? (kth >= c.length || a[ith] < c[kth]
                ? a[ith++]
                : c[kth++])
            : (jth < b.length && (kth >= c.length || b[jth] < c[kth])
                ? b[jth++]
                : c[kth++]);
      }
      return d;
      */
      int i = 0;
      int j = 0;
      int k = 0;

      while (i < a.length && j < b.length)  
      {
         ans[k++] = a[i] < b[j] ? a[i++] :  b[j++];
      }
      while (i < a.length)
      {  
          ans[k++] = a[i++];
      }

      while (j < b.length)
      {    
           ans[k++] = b[j++];
      }
      return ans; 
    }
}
