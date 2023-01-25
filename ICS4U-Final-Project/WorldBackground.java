import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldBackground extends Others
{
    
    private GreenfootImage image;
    /**
     * Constructor for Background 
     * @param image Image for background
     */
    public WorldBackground(GreenfootImage image){
        this.image = image;
        
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    /**
     * Changes the background 
     * @param image New background
     */
    public void changeBG(GreenfootImage image){
        this.image = image;
        
        setImage(image);
    }
}
