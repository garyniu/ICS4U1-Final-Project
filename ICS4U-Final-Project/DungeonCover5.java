import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * Used to cover the actor when it goes through walls or doors
 * 
 * @author Leo Xu
 * @version 1
 *
 */
public class DungeonCover5 extends Others
{
    /**
     * Act - do whatever the Dungeon1Cover1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage coverImage = new GreenfootImage("images/misc/iceCover5.png");
    
    public void addedToWorld(World GameWorld){
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    
    public DungeonCover5() 
    {
        // Add your action code here.
        setImage(coverImage);
    }
}
