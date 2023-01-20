import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Others
{
    private GreenfootImage playImage = new GreenfootImage("images/misc/isowall2.png");
    
    private GreenfootImage hiddenImage = new GreenfootImage("images/misc/hWall.png");
    
    private GreenfootImage semihiddenImage = new GreenfootImage("images/misc/isowall23.png");
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Wall() 
    {
        // Add your action code here.
        change1();
    }
    
    public void addedToWorld(World GameWorld){
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    
    
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
            change3();
        }
    }
    
    public void change1()
    {
        setImage(playImage);
    }
    
    public void change2()
    {
        setImage(hiddenImage);
    }
    
    public void change3()
    {
        setImage(semihiddenImage);
    }
}
