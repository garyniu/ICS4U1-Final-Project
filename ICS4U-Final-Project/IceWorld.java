import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class PortalTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceWorld extends World
{

    private GreenfootImage background = new GreenfootImage("images/background/Dungeon1.jpg");
    
    private WorldBackground wbg2;
    
    private int xd = 0, yd = 0;
    
    private int x = 940;
    
    
    public int[][] mapTwo={
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,0},
            {0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0},
            {0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0},
            {0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,0},
            {0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,0},
            {0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,0},
            {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0},
            {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,1,1,0,0},
            {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},

        }; 
        
        
    public Wall[][] wallListTwo = new Wall[32][36];
    
    private int blockW = 30, blockH = 16;
    private Wall closest = new Wall(0, 0);
    
    private static boolean playerAttacking = false;
    private static int weapon = 0;
    
    /**
     * Constructor for objects of class PortalTest.
     * 
     */
    public IceWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1920, 1080, 1, false); 
        
        
        setPaintOrder(Dungeon1Cover1.class, PlayerHitbox.class, Player.class, Others.class, WorldBackground.class);
        
        GreenfootImage bg = new GreenfootImage(640, 500);
        bg.setColor(Color.BLACK);
        bg.fill();
        setBackground(bg);
        
        
        
        wbg2 = new WorldBackground(background);
        
        Others ep2 = new EnterPortal();
        addObject(ep2, -420, 300);
        
        Others ep3 = new EnterPortalGreen();
        addObject(ep3, -75, -415);
        
        //change enemy to spawn anaywhere, and it moves itself to correct spot
        //addObject(new BossEnemy(300, 200, getMapBlockSize(), getMapOrigin()), 300, 200);//<- This doesn't work
        addObject(new Enemy(5, 6), 0, 0);
        //player
        FreeMovement playerTest = new Player(this.getWidth()/2, this.getHeight()/2);
        addObject(playerTest, this.getWidth()/2, this.getHeight()/2);
        
        FreeMovement playerTest2 = new PlayerHitbox(this.getWidth()/2, this.getHeight()/2);
        addObject(playerTest2, this.getWidth()/2, this.getHeight()/2);
        
        //hitbox for player
        //FreeMovement playerTest2 = new PlayerHitbox(this.getWidth()/2, this.getHeight()/2);
        //addObject(playerTest2, this.getWidth()/2, this.getHeight()/2);
        
        addObject(wbg2, this.getWidth()/2, this.getHeight()/2);
        
        playerTest.changeSpawnCoords(this.getWidth()/2, this.getHeight()/2);
        
        playerTest2.changeSpawnCoords(this.getWidth()/2, this.getHeight()/2);
        
        
        
        //xd = playerTest.getX();
        //yd = playerTest.getY();
        
        //moveThing(xd, yd);
        
        //main portal that allows portals to other worlds work
        Portal portal = new Portal();
        this.addObject(portal, 9999, 9999);
        
        portal = new Portal(); //this worlds portal
        this.addObject(portal, -75, -415);
        
        
        //chest room
        Boundary b1 = new Boundary(300,50);
        addObject(b1, -800, -100);  
        b1.setRotation(150);
        
        Boundary b2 = new Boundary(25,25);
        addObject(b2, -800, -50);  
        b2.setRotation(140);
        
        Boundary b3 = new Boundary(100,25);
        addObject(b3, -800, -10);  
        b3.setRotation(30);
        
        Boundary b4 = new Boundary(100,25);
        addObject(b4, -760, 50);  
        b4.setRotation(30);
        
        Boundary b5 = new Boundary(100,25);
        addObject(b5, -680, 130);  
        b5.setRotation(30);
        
        Boundary b6 = new Boundary(100,200);
        addObject(b6, -620, 220);  
        b6.setRotation(60);
        
        Boundary b7 = new Boundary(120,85);
        addObject(b7, -480, 185);  
        b7.setRotation(30);
        
        
        Boundary b8 = new Boundary(75,110);
        addObject(b8, -430, 210);  
        b8.setRotation(62);
        
        Boundary b9 = new Boundary(75,100);
        addObject(b9, -240, 75);  
        b9.setRotation(61);
        
        Boundary b10 = new Boundary(500,25);
        addObject(b10, -500, -20);  
        b10.setRotation(29);
        
        Boundary b11 = new Boundary(500,25);
        addObject(b11, -500, 300);  
        b11.setRotation(29);
        
        Boundary b12 = new Boundary(100,200);
        addObject(b12, -260, 360);  
        b12.setRotation(60);
        
        //chair room
        Boundary cr1 = new Boundary(40,80);
        addObject(cr1, -140, 400);  
        cr1.setRotation(60);
        
        
        Boundary cr2 = new Boundary(500,25);
        addObject(cr2, -100, 480);  
        cr2.setRotation(28);
        
        Boundary cr3 = new Boundary(25,500);
        addObject(cr3, 330, 470);  
        cr3.setRotation(63);
        
        Boundary cr4 = new Boundary(25,50);
        addObject(cr4, 130, 540);  
        cr4.setRotation(63);
        
        Boundary cr5 = new Boundary(150,50);
        addObject(cr5, 10, 230);  
        cr5.setRotation(30);
        
        Boundary cr6 = new Boundary(150,50);
        addObject(cr6, 1, 140);  
        cr6.setRotation(30);
        
        Boundary cr7 = new Boundary(100,70);
        addObject(cr7, 50, 280);  
        cr7.setRotation(30);
        
        Boundary cr8 = new Boundary(40,80);
        addObject(cr8, 70, 440);  
        cr8.setRotation(59);
        
        
        Boundary cr9 = new Boundary(170,50);
        addObject(cr9, 150, 230);  
        cr9.setRotation(30);
        
        Boundary cr10 = new Boundary(170,50);
        addObject(cr10, 90, 270);  
        cr10.setRotation(30);
        
        Boundary cr11 = new Boundary(100,50);
        addObject(cr11, 290, 400);  
        cr11.setRotation(30);
        
        
        
        
        
        portal = new Portal(portal);
        
        
        SpiderWorld spy1 = new SpiderWorld();
        spy1.addObject(portal, 270, 400);
        
        
        for(int x = 0; x < 32; x++){
            for(int y = 0; y < 36; y++){//for each cell in the array
                //depending on the cell code, add/initialize objects (see map code at top for reference of what codes correspond to what objects
               
                if(mapTwo[x][y]==1){
                    wallListTwo[x][y]=new Wall(x, y);
                    //addObject(wallListTwo[x][y], (400 - x * 14 + y * 14-1), (140 + x * 7 + y * 7));
                    
                    addObject(wallListTwo[x][y], (-65 - x * blockW + y * 30-1), (-445 + x * blockH + y * 16));
                    
                    //X values: higher the value the more it shifts right, Y values: the higher the more the it shifts down
                    
                }
                
            }
        }
        
        
        addObject(closest, -1000, -1000);
        
    }
    
    
    
    //test
    
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
            showText("mouseX: " + String.valueOf(m.getX() - 960), 900, 500);
            showText("mouseY: " + String.valueOf(m.getY() - 545), 900, 600);
        }
        

        //attack here VVV
        if(playerAttacking){
            checkUserGrid();
            if(weapon == 1){
                //attack grid with swipe
            }else if(weapon == 2){
                //attack grid with jab
            }else if(weapon == 3){
                //attack grid with shot
            }
        }

        //System.out.println("fuck " + getBlockCoord(5, 6).getX());
        
        //checkUserOntoGrid();

        
        /*if (m != null)
        {
            showText("mouseX: " + String.valueOf(m.getX()), 900, 500);
            showText("mouseY: " + String.valueOf(m.getY()), 900, 600);
        }*/
        
        /*
        for (int i = 0; i < mapTwo.length; i++){
            for (int j = 0; j < mapTwo[i].length; j++){
                System.out.print(mapTwo[i][j]);
            }
            System.out.println();
        }*/
    }
    
    public static void attacking(){
        playerAttacking = true;
    }
    public static void stopAttacking(){
        playerAttacking = false;
    }
    public static void weapon(int type){
        weapon = type;
    }
    
    //puts the user onto the grid based on coords
    public Pair checkUserGrid(){
        ArrayList<Player> p = (ArrayList<Player>)getObjects(Player.class);
        Player pl = p.get(0);
        
        
        //very inefficent and dumb, best way would be to base off of user current position
        //and then search for grid spaces directly around it, but not enough time
        for (int i = 0; i < mapTwo.length; i++){
            for (int j = 0; j < mapTwo[i].length; j++){
                if (mapTwo[i][j] == 8){
                    mapTwo[i][j] = 1;
                }
            }
        }
        
        
        //add param to each grid block to just store what grid they are
        
        //find which gridblock the player is on
        //find what gridspace the gridblock is
        //set that gridblock to user standing on it
        
        
        for (int i = 0; i < wallListTwo.length; i++){
            for (int j = 0; j < wallListTwo[i].length; j++){
                
                
                if (wallListTwo[i][j] != null){
                    if ((Math.abs(pl.getX() - wallListTwo[i][j].getX()) < Math.abs(pl.getX() - closest.getX())) && (Math.abs(pl.getY() - wallListTwo[i][j].getY()) < Math.abs(pl.getY() - closest.getY()))){
                        closest = wallListTwo[i][j];
                    }
                }
                
                
            }
        }
        
        
        if (mapTwo[closest.getGridCoord().getX()][closest.getGridCoord().getY()] == 1){
            mapTwo[closest.getGridCoord().getX()][closest.getGridCoord().getY()] = 8;
        }
        
        //System.out.println(closest.getGridCoord().getX() + " " + closest.getGridCoord().getY());
        
        return new Pair(closest.getGridCoord().getX(), closest.getGridCoord().getY());
        
    }
    
    public int[][] getMapArr(){
        int[][] copy = new int[mapTwo.length][mapTwo[0].length];
        
        for (int i = 0; i < mapTwo.length; i++){
            for (int j = 0; j < mapTwo[i].length; j++){
                copy[i][j] = mapTwo[i][j];
            }
        }
        
        return copy;
    }
    
    //returns a copy of blocks in array
    
    //BROKEN!!!!!!!!!!!!! FIXXXXXXXXXXXXXXXX
    public Pair getBlockCoord(int x, int y){
        
        //Wall temp = wallListTwo[0][0];
        
        //int a = temp.getX(), b = temp.getY();
        
        //WILL RETURN NULL IF THERE IS NO BLOCK!!!!
        if (wallListTwo[x][y] == null){
            return new Pair(0, 0);
        } else {
            return new Pair(wallListTwo[x][y].getX(), wallListTwo[x][y].getY());
        }
        
    }
    
    //WORKING
    public Pair getMapBlockSize(){
        
        Wall walli = new Wall(-1, -1);

        for (int i = 0; i < wallListTwo.length; i++){
            for (int j = 0; j < wallListTwo[i].length; j++){
                if (wallListTwo[i][j] != null){
                    walli = wallListTwo[i][j];
                }
                
            }
            
        }
        
        return new Pair(walli.getImage().getWidth(), walli.getImage().getHeight());
    }
    
    public void setGridPosition(int x, int y, int v){
        mapTwo[x][y] = v;
    }


}
