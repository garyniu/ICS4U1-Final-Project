import greenfoot.*;

/**
 * Superclass purely used for the shifting camera affect.
 * 
 * @author Gary Niu
 * @version January 2023
 */
public abstract class Others extends Actor
{
    // instance variables - replace the example below with your own
    
    protected int xg, yg;

    /**
     * Constructor for objects of class Others
     */
    public Others()
    {
    }

    public Pair getOGCoords(){
        return new Pair(xg, yg);
    }
    
}
