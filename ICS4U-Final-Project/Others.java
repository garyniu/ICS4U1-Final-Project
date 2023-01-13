import greenfoot.*;

/**
 * Write a description of class Others here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
