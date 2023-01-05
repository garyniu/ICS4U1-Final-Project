import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    Label titleLabel = new Label("press 1 to show grid tile", 30);
    Label titleLabelTwo = new Label("press 2 to hide grid tile", 30);
    Label titleLabelThree = new Label("press 3 to show transparent grid tile", 30);
    
    //TODO
    //arr of enemies, world only needs to get coordinate points for arr and draws enemies, does not worry
    //about any of the logic
    
    //same with the player
    
    //Process:
    // 1. Get coordinates for all entities in the world (GridMovement getCoord() method)
    // 2. For each entity, find the coordinate points of the grid in 2D array
    //      2.5. If following camera, have a check to see if on or off screen
    // 3. Using scaling factor and getting the coordinates of the grid it is currently on, draw it on that grid space
    
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
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 720x405 cells with a cell size of 1x1 pixels.
        super(720, 405, 1);
        
        setBackground("BG.jpg");
        
        addObject(titleLabel, 150, 150);
        addObject(titleLabelTwo, 150, 200);
        addObject(titleLabelThree, 250, 250);
        
        GridMovement enemyTest = new Enemy(0, 0);
        
        addObject(enemyTest, 50, 50);
        
        
        TestMovementNPC main = new TestMovementNPC();//spawn MainCharater
        addObject(main, 200, 200);
        
        //main portal that allows portals to other worlds work
        Portal portal = new Portal();
        this.addObject(portal, 9999, 9999);
        portal = new Portal(portal);
        this.addObject(portal, 9999, 9999);
        
        portal = new Portal();// PortalTest world's portal
        this.addObject(portal, 550, 300); 
        portal = new Portal(portal);
        PortalTest world2 = new PortalTest(); 
        world2.addObject(portal, 100, 100);
        
        
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 7; y++){//for each cell in the array
                //depending on the cell code, add/initialize objects (see map code at top for reference of what codes correspond to what objects
               
                if(mapTwo[x][y]==1){
                    wallListTwo[x][y]=new Wall();
                    //addObject(wallListTwo[x][y], (400 - x * 14 + y * 14-1), (140 + x * 7 + y * 7));
                    
                    addObject(wallListTwo[x][y], (440- x * 14 + y * 14-1), (125 + x * 7 + y * 7));
                    
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
            showText("mouseX: " + String.valueOf(m.getX()), 120, 30);
            showText("mouseY: " + String.valueOf(m.getY()), 120, 70);
        }
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
    
}
