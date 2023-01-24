import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    //TODO
    //arr of enemies, world only needs to get coordinate points for arr and draws enemies, does not worry
    //about any of the logic
    
    //same with the player
    
    //Process:
    // 1. Get coordinates for all entities in the world (GridMovement getCoord() method)
    // 2. For each entity, find the coordinate points of the grid in 2D array
    //      2.5. If following camera, have a check to see if on or off screen
    // 3. Using scaling factor and getting the coordinates of the grid it is currently on, draw it on that grid space
    
    //TODO
    // Make sure to despawn / undraw actors when they move off screen
    
    //Variables for the config variable?
    //0,0 grid position on actual grid
    //scaling factor
    //pixel size of a grid square
    
    //following camera
    
    
    //map 10 by 7
    // 0 = blank tile
    // 1 = wall

    public int[][] mapTwo={
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
        
        
    public Wall[][] wallListTwo = new Wall[10][7];
    
    private GreenfootImage background = new GreenfootImage("images/background/BG33.png");
    
    private WorldBackground wbg;
    
    private int xd = 0, yd = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 720x405 cells with a cell size of 1x1 pixels.
        super(600, 500, 1, false);
        
        setPaintOrder(Boundary.class, Projectile.class, PlayerHitbox.class, Player.class, BossEnemy.class, Enemy.class, Portal.class, EnterPortal.class,TorchFire.class, Wall.class, WorldBackground.class);

        wbg = new WorldBackground(background);

        GreenfootImage bg = new GreenfootImage(640, 500);
        bg.setColor(Color.BLACK);
        bg.fill();
        setBackground(bg);
        
        //Enter Portal
        Others ep = new EnterPortal();
        addObject(ep, 560, 215);
        
        //TorchFire
        Others tf = new TorchFire();
        addObject(tf, 180, 180);
        
        
        //main portal that allows portals to other worlds work
        Portal portal = new Portal();
        this.addObject(portal, 9999, 9999);
        portal = new Portal(portal);
        this.addObject(portal, 9999, 9999);
        
        //gameWorldPortal to portalTest world
        portal = new Portal();
        this.addObject(portal, 560, 215);//Portal in this world (GameWorld) 
        
        portal = new Portal(portal);
        IceWorld world2 = new IceWorld();//portal to the other world (iceWorld)
        world2.addObject(portal, 260, 115);
        
        //player
        FreeMovement playerTest = new Player(250, 400);
        addObject(playerTest, this.getWidth()/2, this.getHeight()/2);
        //hitbox for player
        FreeMovement playerTest2 = new PlayerHitbox(250, 400);
        addObject(playerTest2, this.getWidth()/2, this.getHeight()/2);
        
        
        addObject(wbg, this.getWidth()/2, this.getHeight()/2);
        
        
        //Boudary class
        Boundary bound1 = new Boundary(550,50);
        addObject(bound1, 520, 360);  
        bound1.setRotation(150);
        
        
        Boundary bound2 = new Boundary(280,50);
        addObject(bound2, 70, 380);  
        bound2.setRotation(390);
        
        
        Boundary bound3 = new Boundary(100,50);
        addObject(bound3, 200, 480);  
        bound3.setRotation(210);
        
        
        Boundary bound4 = new Boundary(210,20);
        addObject(bound4, 280, 240);  
        bound4.setRotation(210);
        
        Boundary bound5 = new Boundary(20,150);
        addObject(bound5, 270, 300);  
        bound5.setRotation(240);
        
        Boundary bound6 = new Boundary(10, 300);
        addObject(bound6, 80, 300);  
        bound6.setRotation(240);
        
        Boundary bound7 = new Boundary(10, 750);
        addObject(bound7, 20, 250);  
        bound7.setRotation(240);
        
        Boundary bound8 = new Boundary(500,10);
        addObject(bound8, 500, 175);  
        bound8.setRotation(210);
        
        
        xd = playerTest.getX();
        yd = playerTest.getY();
        
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 7; y++){//for each cell in the array
                //depending on the cell code, add/initialize objects (see map code at top for reference of what codes correspond to what objects
               
                if(mapTwo[x][y]==1){
                    wallListTwo[x][y]=new Wall(x, y);
                    //addObject(wallListTwo[x][y], (400 - x * 14 + y * 14-1), (140 + x * 7 + y * 7));
                    
                    //addObject(wallListTwo[x][y], (440- x * 14 + y * 14-1), (125 + x * 7 + y * 7));
                    
                    //X values: higher the value the more it shifts right, Y values: the higher the more the it shifts down
                    
                }
                
            }
        }
        
        moveThing(xd, yd);
    }
    
    public void act()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if (m != null)
        {
            showText("mouseX: " + String.valueOf(m.getX()), 120, 30);
            showText("mouseY: " + String.valueOf(m.getY()), 120, 70);
        }
    }
    
    public void setThing(int cX, int cY)
    {
        xd = this.getWidth()- cX;
        yd = this.getHeight() - cY;
        
        System.out.println("newx and y: " + cX + " " + cY );
        
        wbg.setLocation(xd, yd);
    }

    public void moveThing(int cX, int cY){
        GreenfootImage image = getBackground();
        xd = cX;
        yd = cY;
        wbg.setLocation(xd, yd);
    }
    
    
    //returns deep copy of map array
    public int[][] getMapArr(){
        int[][] copy = new int[mapTwo.length][mapTwo[0].length];
        
        for (int i = 0; i < mapTwo.length; i++){
            for (int j = 0; j < mapTwo[i].length; j++){
                copy[i][j] = mapTwo[i][j];
            }
        }
        
        return copy;
    }
    
    //returns the top left corner position of the array on the screen
    public Pair getMapOrigin(){
        Wall temp = wallListTwo[0][0];
        
        int a = temp.getX(), b = temp.getY();
        
        return new Pair(a, b);
    }
    
    //returns the width and height of a block
    public Pair getMapBlockSize(){
        return new Pair(wallListTwo[0][0].getImage().getWidth(), wallListTwo[0][0].getImage().getHeight());
    }
    
    public static void spawnArrow(int x, int y, int dir){
        FreeMovement arrow = new Projectile(x, y, dir);
        //addObject(arrow, this.getWidth()/2, this.getHeight()/2);
    }
}
