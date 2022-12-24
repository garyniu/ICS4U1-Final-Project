import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Label titleLabel = new Label("press 1 to show grid tile", 30);
    Label titleLabelTwo = new Label("press 2 to hide grid tile", 30);
    Label titleLabelThree = new Label("press 3 to show transparent grid tile", 30);
    
    
    
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
    public MyWorld()
    {    
        // Create a new world with 720x405 cells with a cell size of 1x1 pixels.
        super(720, 405, 1);
        
        setBackground("BG.jpg");
        
        addObject(titleLabel, 150, 150);
        addObject(titleLabelTwo, 150, 200);
        addObject(titleLabelThree, 250, 250);
        
        
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
}
