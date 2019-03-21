import java.util.Random;
import java.util.*;
public class AngularSort
{
   /* private Point array[];
    private int length;

    public <T> void sort(T[] inputArr)
    {
        if (inputArr == null || inputArr.length == 0)
            return;
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
    public  void quickSort(int lowerIndex, int higherIndex)
    {
        int i = lowerIndex;
        int j = higherIndex;
        Random r = new Random();
        int low = i;
        int high = j;
        int pivot = r.nextInt(high - low) + low;
        while (i <= j)
        
            while (array[i] < pivot)
            {
                i++;
            }
            while (array[j] > pivot)
            {
                j--;
            }
            if (i <= j)
            {
                exchangeNum(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
    private void exchangeNum(int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    */
    public static <T extends Comparable<T>> void quickSort(ArrayList<T> arr, int a, int b)
    {
        if(a < b)
        {
            int lower = a;
            int upper = b;
            Random r = new Random();
            int pivot = r.nextInt(upper - lower) + lower;
            do {
                while (arr.get(lower).compareTo(arr.get(pivot)) < 0)
                    lower++;
                while (arr.get(pivot).compareTo(arr.get(pivot)) < 0) 
                    upper--;
                if (lower <= upper)
                {
                    T tmp = arr.get(upper);
                    arr.set(upper, arr.get(lower));
                    arr.set(lower, tmp);
                    lower++;
                    upper--;
                }
            } while (lower <= upper);

            quickSort(arr, a, upper);
            quickSort(arr, lower, b);
         }
    }
    public static void main (String[] args)
    {
        ArrayList<Point> list = new ArrayList<Point>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextDouble())
        {
           Point p = new Point(sc.nextDouble(), sc.nextDouble());
           list.add(p);
        }
        quickSort(list, 0, list.size() - 1);   

    }
}









