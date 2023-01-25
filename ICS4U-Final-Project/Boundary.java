import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boundary here.
 * 
 * This Actor is used to create invisible walls in the playable world maps
 * 
 * @author Leo Xu
 * @date June 15 2022
 * 
 */
public class Boundary extends Others
{
    private GreenfootImage boundImage = new GreenfootImage ("images/misc/baal2.png");
    
    public void addedToWorld(World GameWorld){
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    
    /**
     * Constructor for Boundary
     * @param width Width
     * @param height Height
     */
    public Boundary (int width, int height)//Sets the boundary's size
    {
        boundImage.scale(width, height);
        setImage(boundImage);
    }
}
