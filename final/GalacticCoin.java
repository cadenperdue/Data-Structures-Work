import java.util.*;

public class GalacticCoin
{
    public static int max = 1000;
    public static int counter = 0;
    public static double[] table = new double[100000001];
    
    public static int[] countTable = new int[100000001];
    public static void main (String[] args)
    {
      //  table[1].setNum(3);        
      //  System.out.println(table[1].getNum());   
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a galactic coin: ");
        int value = sc.nextInt();
        double bigger = recurse(value);
         
        System.out.println((int)bigger);
        for(int i = 0; i < countTable.length; i++)
        {
            if(countTable[i] != 0)
            {
                System.out.println(i + "          " + countTable[i]);
            }
        }
    }
    public static double recurse(double v)
    {
        double value = v;   
        double two = Math.floor(value/2);
        double three = Math.floor(value/3);
        double four = Math.floor(value/4);
        double total = two + three + four;
        
        
        
        if(table[(int)value] != 0)
        {
            return table[(int)value];
        }
        if(value >= total)
        {
            return value;
        }
        else
        {   
            if(table[(int)value] == 0)
            {
                table[(int)value] = total;
                
                countTable[(int)two] ++;
                countTable[(int)three] ++;
                countTable[(int)four] ++;
            }
            else
            {
                total = table[(int)value];
            }
            return recurse(two) + recurse(three) + recurse(four);
         }
        
    }
}
