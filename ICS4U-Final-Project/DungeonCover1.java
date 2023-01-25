import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * Used to cover the actor when it goes through walls or doors
 * 
 * @author Leo Xu
 * @version 1
 *
 */
public class DungeonCover1 extends Others
{
    private GreenfootImage coverImage = new GreenfootImage("images/misc/iceCover1.png");
    
    public void addedToWorld(World GameWorld){
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    /**
     * Constructor
     */
    public DungeonCover1() 
    {
        // Add your action code here.
        setImage(coverImage);
    }
}
