import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PortalTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PortalTest extends World
{

    private GreenfootImage background = new GreenfootImage("BG33.png");
    
    private WorldBackground wbg;
    
    private int xd = 0, yd = 0;
    
    /**
     * Constructor for objects of class PortalTest.
     * 
     */
    public PortalTest()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        wbg = new WorldBackground(background);
        
        Others ep2 = new EnterPortal();
        addObject(ep2, 560, 515);

    }
    
    public void moveThing(int cX, int cY){
        GreenfootImage image = getBackground();
        xd = cX;
        yd = cY;
        wbg.setLocation(xd, yd);
    }
}
