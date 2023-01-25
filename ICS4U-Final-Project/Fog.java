import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visual Fog Effect
 * 
 * @author Gary Niu
 * @version January 24
 */
public class Fog extends Actor
{

    
    private int x, y;
    private GreenfootImage boundImage = new GreenfootImage ("fog.png");
    /**
     * Constructor for Fog
     */
    
    public Fog(){
        boundImage.scale(600, 500);
        setImage(boundImage);
    }
    /**
     * Act Method
     */
    public void act()
    {
        //System.out.println("test");
    }
}
