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
    
    private int xd = 0, yd = 0;
    
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
        
        
    public SmallWall[][] wallListFour = new SmallWall[10][7];
    
    
    
    
    /**
     * Constructor for objects of class SpookyWorld.
     * 
     */
    public SpiderWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1922, 1450, 1, false); 
        
        setPaintOrder(Dungeon1Cover1.class, Player.class, Others.class, WorldBackground.class);
        
        wbg3 = new WorldBackground(background);
        
        GreenfootImage bg = new GreenfootImage(640, 500);
        bg.setColor(Color.BLACK);
        bg.fill();
        setBackground(bg);
        
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
                    wallListFour[x][y]=new SmallWall();
                    //addObject(wallListFour[x][y], (400 - x * 14 + y * 14-1), (140 + x * 7 + y * 7));
                    
                    addObject(wallListFour[x][y], (-60 - x * 14 + y * 14-1), (390 + x * 7 + y * 7));
                    
                    
                    
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
    
    public int[][] getMapArr(){
        int[][] copy = new int[1][1];// = new int[mapTwo.length][mapTwo[0].length];
        
        /*
        for (int i = 0; i < mapTwo.length; i++){
            for (int j = 0; j < mapTwo[i].length; j++){
                copy[i][j] = mapTwo[i][j];
            }
        }*/
        
        return copy;
    }
    
    //returns the top left corner position of the array on the screen
    public Pair getMapOrigin(){
        
        //Wall temp = wallListTwo[0][0];
        
        //int a = temp.getX(), b = temp.getY();
        
        return new Pair(0, 0);
    }
    
    //returns the width and height of a block
    public Pair getMapBlockSize(){
        return new Pair(0,0);//new Pair(wallListTwo[0][0].getImage().getWidth(), wallListTwo[0][0].getImage().getHeight());
    }
}
