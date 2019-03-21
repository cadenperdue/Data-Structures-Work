public class GridNode{
    private double xCoord;
    private double yCoord;
    private GridNode next;
    public GridNode(double _xCoord, double _yCoord, GridNode _next){
        xCoord = _xCoord;
        yCoord = _yCoord;
        next = _next;
    }
    public double getXCoord(){
        return xCoord;
    }
    public double getYCoord(){
        return yCoord;
    }
    public void setXCoord(double _xCoord)
    {
        xCoord = _xCoord;
    }
    public void setYCoord(double _yCoord)
    {
        yCoord = _yCoord;
    }
    public GridNode getNext()
    {
        return next;
    }
    public void setNext(GridNode _next)
    {
        next = _next;
    }
}
