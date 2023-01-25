import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Used to place down the grids used in spiderWorld
 * 
 * @author Leo Xu
 * @version 1
 */
public class SmallWall extends Others
{
    private GreenfootImage playImage = new GreenfootImage("images/misc/isowall256.png");
    
    private GreenfootImage hiddenImage = new GreenfootImage("images/misc/hWall.png");
    
    private GreenfootImage semihiddenImage = new GreenfootImage("images/misc/isowall23.png");
    /**
     * Constructor for Small Wall
     */
    public SmallWall() 
    {
        // Add your action code here.
        change1();
       
        
        
        
    }
    
    public void addedToWorld(World GameWorld){
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    
    /**
     * Act Method 
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            change1();
        }
        if(Greenfoot.isKeyDown("2"))
        {
            change2();
        }
        if(Greenfoot.isKeyDown("3"))
        {
            change2();
        }
    }
    /**
     * Change to playImage
     */
    public void change1()
    {
        setImage(playImage);
    }
    /**
     * Change to hiddenImage
     */
    public void change2()
    {
        setImage(hiddenImage);
    }
    /**
     * Change to semiHiddenImage
     */
    public void change3()
    {
        setImage(semihiddenImage);
    }
}
