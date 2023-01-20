import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PortalTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PortalTest extends World
{

    private GreenfootImage background = new GreenfootImage("images/background/Dungeon1.jpg");
    
    private WorldBackground wbg2;
    
    private int xd = 0, yd = 0;
    
    /**
     * Constructor for objects of class PortalTest.
     * 
     */
    public PortalTest()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1920, 1080, 1, false); 
        
        
        setPaintOrder(Dungeon1Cover1.class, Player.class, Others.class, WorldBackground.class);
        
        
        
        setBackground("images/misc/hWall.png");
        
        wbg2 = new WorldBackground(background);
        
        Others ep2 = new EnterPortal();
        addObject(ep2, 260, 115);
        
        Others c1 = new Dungeon1Cover1();
        addObject(c1, 240, 305);
        
        
        
        
        FreeMovement playerTest = new Player(this.getWidth()/2, this.getHeight()/2);

        addObject(playerTest, this.getWidth()/2, this.getHeight()/2);
        addObject(wbg2, this.getWidth()/2, this.getHeight()/2);
        
        
        
        xd = playerTest.getX();
        yd = playerTest.getY();
        
        moveThing(xd, yd);
    }
    
    public void moveThing(int cX, int cY){
        GreenfootImage image = getBackground();
        xd = cX;
        yd = cY;
        wbg2.setLocation(xd, yd);
    }
    
    public void act()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if (m != null)
        {
            showText("mouseX: " + String.valueOf(m.getX()), 260, 200);
            showText("mouseY: " + String.valueOf(m.getY()), 260, 300);
        }
    }
}
