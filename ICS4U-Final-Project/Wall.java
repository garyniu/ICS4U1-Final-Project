import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Used to place down the grids used in iceWorld
 * 
 * @author Leo Xu
 * @version 1
 */
public class Wall extends Others
{
    private GreenfootImage playImage;
    private GreenfootImage hiddenImage = new GreenfootImage("images/misc/hWall.png");
    
    private int gridx, gridy;
    
    private GreenfootImage semihiddenImage = new GreenfootImage("images/misc/isowall23.png");
    /**
     * Constructor for Wall
     * @param gridx X grid value 
     * @param gridy Y grid value
     */
    public Wall(int gridx, int gridy) 
    {
        playImage = new GreenfootImage("images/misc/isowall245.png");
        setImage(playImage);
        // Add your action code here.
        
        this.gridx = gridx;
        this.gridy = gridy;
        
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
     * Get Grid coordinates in relation to grid size
     * @return Pair Pair of coordinates 
     */
    public Pair getGridCoord(){
        return new Pair(gridx, gridy);
    }
    /**
     * Change image to playImage
     */
    public void change1()
    {
        setImage(playImage);
    }
    /**
     * Change image to hiddenImage
     */
    public void change2()
    {
        setImage(hiddenImage);
    }
    /**
     * Change image to semiHiddenImage
     */
    public void change3()
    {
        setImage(semihiddenImage);
    }
}
