import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnterPortal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnterPortal extends Others

{
    /**
     * Act - do whatever the EnterPortal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void addedToWorld(World GameWorld){
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    
    GifImage void1 = new GifImage("images/misc/void1.gif");
    public void act()
    {
        // Add your action code here.
        setImage(void1.getCurrentImage());
    }
}
