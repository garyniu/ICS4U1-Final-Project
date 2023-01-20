import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon1Cover1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon1Cover1 extends Others
{
    /**
     * Act - do whatever the Dungeon1Cover1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage coverImage = new GreenfootImage("images/Cover1.png");
    
    public void addedToWorld(World GameWorld){
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    
    public Dungeon1Cover1() 
    {
        // Add your action code here.
        setImage(coverImage);
    }
}
