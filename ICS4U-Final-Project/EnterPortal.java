import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * Animated portal used for graphics
 * 
 * @author Leo Xu
 * @version 1
 *
 */
public class EnterPortal extends Others

{
    GifImage void1 = new GifImage("images/misc/void1.gif");
    public void addedToWorld(World GameWorld){
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    public void act()
    {
        // Add your action code here.
        setImage(void1.getCurrentImage());
    }
}
