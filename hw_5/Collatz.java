import java.util.Scanner;

public class Collatz
{
    public static int length = 0;
    public static int [] arr = new int[100000000];
    public static void main (String[] args)
    {
        int max = 0;
        Scanner sc = new Scanner(System.in);
        int range;
        System.out.println("Enter first number of the number range: ");
        range = sc.nextInt();
        int count = range;
        System.out.println("Enter the second number of the number range: ");
        int range2 = sc.nextInt();
        int maxNum = 0;
        length = 0;        
        while(count < range2)
        {
            length = 0;
            collatzLength(count);
            if (arr[count] == 0)
            {
                arr[count] = length;
            }
            if (length > max){
                max = length;
                maxNum = count;
            }
            count = count + 1;
        }
        
        System.out.println("The number with the highest Collatz length is : " + maxNum);
        System.out.println("The Collatz length is : " + max - 1);
    }
    public static void collatzLength(int x)
    {
        if(arr[x] != 0)
        {
            length =length + arr[x];
        }
        else if (x == 1)
        {
            length += 1;
            
        }
        else if (x % 2 == 0)
        {
            length += 1;
            collatzLength(x/2);
        }
        else
        {
            length += 1;
            collatzLength(3 * x + 1);
        }
        
    }
   
}
