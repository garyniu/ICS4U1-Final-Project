import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpookyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiderWorld extends World
{
    private GreenfootImage background = new GreenfootImage("images/background/spider1.jpg");
    
    private WorldBackground wbg3;
    
    
    
    public int[][] mapFour={
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
        }; 
        
        
    public Wall[][] wallListFour = new Wall[10][7];
    
    
    private int xd = 0, yd = 0;
    /**
     * Constructor for objects of class SpookyWorld.
     * 
     */
    public SpiderWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1922, 1450, 1); 
        setPaintOrder(Dungeon1Cover1.class, Player.class, Others.class, WorldBackground.class);
        
        wbg3 = new WorldBackground(background);
        
        
        Others ep2 = new EnterPortal();
        addObject(ep2, 400, -120);
        
        FreeMovement playerTest = new Player(this.getWidth()/2, this.getHeight()/2);

        addObject(playerTest, this.getWidth()/2, this.getHeight()/2);
        addObject(wbg3, this.getWidth()/2, this.getHeight()/2);
        
        playerTest.changeSpawnCoords(this.getWidth()/2, this.getHeight()/2);

        
        xd = playerTest.getX();
        yd = playerTest.getY();
        
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 7; y++){//for each cell in the array
                //depending on the cell code, add/initialize objects (see map code at top for reference of what codes correspond to what objects
               
                if(mapFour[x][y]==1){
                    wallListFour[x][y]=new Wall();
                    //addObject(wallListFour[x][y], (400 - x * 14 + y * 14-1), (140 + x * 7 + y * 7));
                    
                    //addObject(wallListFour[x][y], (440- x * 14 + y * 14-1), (125 + x * 7 + y * 7));
                    
                    //X values: higher the value the more it shifts right, Y values: the higher the more the it shifts down
                    
                }
                
            }
        }
    }
    
    public void act()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        
        if (m != null)
        {
            showText("mouseX: " + String.valueOf(m.getX() - 960), 900, 500);
            showText("mouseY: " + String.valueOf(m.getY() - 730), 900, 600);
        }
        
        /*if (m != null)
        {
            showText("mouseX: " + String.valueOf(m.getX()), 900, 500);
            showText("mouseY: " + String.valueOf(m.getY()), 900, 600);
        }*/
    }
    
    public void moveThing(int cX, int cY){
        GreenfootImage image = getBackground();
        xd = cX;
        yd = cY;
        wbg3.setLocation(xd, yd);
    }
}
