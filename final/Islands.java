import java.util.*;

public class Islands
{
    public static char[][] map;
    public static int counter = 0;
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        map = new char[size][size];
        sc.nextLine();
        
        for(int i = 0; i < size; i++)
        {
            String s = sc.nextLine();
           
            for (int j = 0; j < size; j++)
            {
                char a = s.charAt(j);
                map[i][j] = a;
               // System.out.print(map[i][j]);
            }
        }
        for(int i = 0; i < size; i++)
        {
           for(int j = 0; j < size; j++)
           {
                if(dfs(i, j))
                    counter++;
           }
        }
        System.out.println(counter);
       
    }
    public static boolean dfs(int i, int j)
    {
        if(map[i][j] == '/')
        {
            return false;
        }
        else
        {
            map[i][j] = '/';
            if(i - 1 > 0)
            {
                dfs(i - 1, j);
                if(j - 1 > 0)
                    dfs(i - 1, j - 1);
                if(j + 1 < map.length)
                    dfs(i - 1, j + 1);
            }
            if (j - 1 > 0)
                dfs(i, j - 1);
            if (j + 1 < map.length)
                dfs(i, j + 1);

            if(i + 1 < map.length)
            {
                dfs(i + 1, j);
                if (j - 1 > 0)
                    dfs(i + 1, j - 1);
                if (j + 1 < map.length)
                    dfs(i + 1, j + 1);
            }
            return true;
        }
    }
        
}
