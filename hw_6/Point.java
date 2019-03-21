import java.util.Comparator;
import java.lang.Math;
 public class Point implements Comparable<Point>
 {  
     public double x = 0;
     public double y = 0;
        
     Point(double x1, double y1)
     {
         x = x1;
         y = y1;
     }

     public int compareTo(Point meme)
     {
        if (getY() > 0 && this.getY() > 0 || getY() < 0 && this.getY() < 0)
        {
            if(getAng() > this.getAng())
                return 1;
            else if(getAng() < this.getAng())
                return -1;
            else
                return 0;
        }
        else if (getY() < 0 && this.getY() > 0)
        {
            return -1;  
        }
        else if(getY() > 0 && this.getY() <0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
     }
     public double getX()
     {
        return x;
     }
     public double getY()
     {
         return y;
     }
     public void setX(double x1)
     {
       x = x1;
     }
     public void setY(double y1)
     {
         y = y1;
     }
     public double getAng()
     {
         double cosine = x / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
         double arcCosine = Math.acos(cosine);
         return cosine;
     }
 }
