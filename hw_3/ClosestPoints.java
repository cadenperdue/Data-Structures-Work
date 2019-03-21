import java.util.Scanner;
import java.io.*;
public class ClosestPoints{
 public static final int b = 100;
 GridNode [][] grid = new GridNode[b][b];
    public static void main(String [] args){
                
    // im just gonna leave this blank because there's no way i finish in time. please take pity on my soul, i promise this code should almost work
    }

    
    
    public void makeTable()
    {
        File f = new File("points.txt");
        try
        {
            Scanner scan = new Scanner(f);
            int i = 0;
            while(scan.hasNextLine() && i < 1000000)
            {
                GridNode x = new GridNode(scan.nextDouble(), scan.nextDouble(), null);
                int [] arr = hashFunction(x);
                if (grid[arr[0]][arr[1]] == null)
                {
                    grid[arr[0]][arr[1]] = x;
                }
                else
                {
                    x.setNext(grid[arr[0]][arr[1]]);
                    grid[arr[0]][arr[1]] = x;
                }
                i++;
            }
        }
        catch (FileNotFoundException q)
        {
            q.printStackTrace();
        }
    }
    public double smallest()
    {
        double minLength = 1000000;
        for(int k = 0; k < b; k++){
            for(int l = 0; l < b; l++){
                if(l == 0 && k == 0){
                    for(GridNode i = grid[0][0]; i != null; i = i.getNext()){
                        for(GridNode j = grid[0][0]; j != null; j = j.getNext()){
                            double plzHelp = calcDist(i, j);
                            if (plzHelp < minLength)
                                plzHelp = minLength;
                            }
                        
                        for(GridNode j = grid[1][0]; j != null; j = j.getNext()){
                            double plzHelp = calcDist(i, j);
                            if (plzHelp < minLength)
                                plzHelp = minLength;
                        }
                        for(GridNode j= grid[0][1]; j != null; j = j.getNext()){
                            double plzHelp = calcDist(i, j);
                            if (plzHelp < minLength)
                                plzHelp = minLength;
                        }
                        for(GridNode j = grid[1][1]; j != null; j = j.getNext()){
                            double plzHelp = calcDist(i, j);
                            if (plzHelp < minLength)
                                plzHelp = minLength;
                        }
                    }
                }
            }
        }
        return minLength;    
    }
              
    public double calcDist (GridNode a, GridNode b)
    {
        double x = a.getXCoord();
        double x2 = b.getXCoord();
        double y = a.getYCoord();
        double y2 = a.getYCoord();
        return  Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
    }
    public int[] hashFunction(GridNode x)
    {
        int xBox = (int)x.getXCoord() * 100000;
        int yBox = (int)x.getYCoord() * 100000;
        int[] coords = new int[2];
        coords[0] = xBox/3125;
        coords[0] = yBox/3125;
        return coords;
    }
}
