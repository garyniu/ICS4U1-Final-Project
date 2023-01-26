import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * First playable world
 * 
 * MUSIC CREDITS:
 * main theme (https://www.youtube.com/watch?v=uz2nAshTxNE)
 * 
 * @author Leo Xu, Gary,Niu
 * @version 1
 *
 */
public class IceWorld extends World
{

    private GreenfootImage background = new GreenfootImage("images/background/Dungeon1.jpg");
    
    private static GreenfootSound winter = new GreenfootSound("sounds/dragon1.mp3");

    private WorldBackground wbg2;

    private ArrayList<Player> p;
    private Player pl;
    
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
            {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
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
    private int timer = 0;
    private Wall closest = new Wall(0, 0);
    private int xoff = getWidth()/2 + 350, yoff = getHeight()/2 - 300;

    //stat bar
    private static SuperStatBar health;
    private static SuperStatBar stamina;

    /**
     * Constructor for objects of class IceWorld.
     * 
     */
    public IceWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1, false); 

        setPaintOrder(SuperStatBar.class, Fog.class, DungeonCover5.class, DungeonCover4.class, DungeonCover3.class, DungeonCover1.class, DungeonCover2.class, PlayerHitbox.class, Player.class, Others.class, WorldBackground.class, Wall.class);
        
        GameWorld.stopMusic();
        //stat bar
        //stamina
        stamina = new SuperStatBar(500, 500, null, 150, 10, 0, Color.GREEN, Color.BLACK, false, Color.GRAY, 3);
        addObject(stamina, 70, 15);
        //hp
        health = new SuperStatBar (100, 100, null, 200, 15, 0, Color.RED, Color.BLACK, false, Color.GRAY, 3);
        addObject(health, 95, 5);

        

        //addObject(new EnemySphere);

        
        GreenfootImage bg = new GreenfootImage(640, 500);
        bg.setColor(Color.BLACK);
        bg.fill();
        setBackground(bg);

        wbg2 = new WorldBackground(background);
        //Enter portals
        Others ep2 = new EnterPortal();
        addObject(ep2, -420, 300);

        Others ep3 = new EnterPortalGreen();
        addObject(ep3, -75, -415);

        //DUNGEON COVERS

        DungeonCover1 c1 = new DungeonCover1();//chair room
        addObject(c1, 260, 300);

        DungeonCover2 c2 = new DungeonCover2();//chair room
        addObject(c2, -70, 295);

        DungeonCover3 c3 = new DungeonCover3();//chest room
        addObject(c3, -348, 100);

        DungeonCover4 c4 = new DungeonCover4();//middle room
        addObject(c4, -50, -79);

        DungeonCover5 c5 = new DungeonCover5();//middle room
        addObject(c5, 275, 95);

        //change enemy to spawn anaywhere, and it moves itself to correct spot
        //addObject(new BossEnemy(300, 200, getMapBlockSize(), getMapOrigin()), 300, 200);//<- This doesn't work

        addObject(new Enemy(1, 1, 0), 0, 0);

        //hitbox for player
        FreeMovement playerTest2 = new PlayerHitbox(this.getWidth()/2, this.getHeight()/2);
        addObject(playerTest2, this.getWidth()/2, this.getHeight()/2);

        //FreeMovement playerTest2 = new PlayerHitbox(this.getWidth()/2, this.getHeight()/2);
        //addObject(playerTest2, this.getWidth()/2, this.getHeight()/2);

        addObject(wbg2, this.getWidth()/2, this.getHeight()/2);

        //playerTest.changeSpawnCoords(this.getWidth()/2, this.getHeight()/2);//remove

        playerTest2.changeSpawnCoords(xoff, yoff);

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

        Boundary cr9 = new Boundary(130,50);
        addObject(cr9, 150, 230);  
        cr9.setRotation(30);

        Boundary cr10 = new Boundary(170,50);
        addObject(cr10, 90, 270);  
        cr10.setRotation(30);

        Boundary cr11 = new Boundary(90,50);
        addObject(cr11, 290, 400);  
        cr11.setRotation(30);

        Boundary cr12 = new Boundary(100,50);
        addObject(cr12, 360, 360);  
        cr12.setRotation(30);

        //sklee room

        Boundary sr1 = new Boundary(100,25);
        addObject(sr1, 415, 320);  
        sr1.setRotation(30);

        Boundary sr2 = new Boundary(150,25);
        addObject(sr2, 270, 175);  
        sr2.setRotation(-30);

        Boundary sr3 = new Boundary(100,20);
        addObject(sr3, 350, 170);  
        sr3.setRotation(-30);

        Boundary sr4 = new Boundary(100,20);
        addObject(sr4, 630, 235);  
        sr4.setRotation(-30);

        Boundary sr5 = new Boundary(600,20);
        addObject(sr5, 680, 245);  
        sr5.setRotation(-27);

        Boundary sr6 = new Boundary(100,25);
        addObject(sr6, 880, 40);  
        sr6.setRotation(30);

        Boundary sr7 = new Boundary(100,25);
        addObject(sr7, 780, -5);  
        sr7.setRotation(30);

        Boundary sr8 = new Boundary(25,100);
        addObject(sr8, 660, 30);  
        sr8.setRotation(60);

        Boundary sr9 = new Boundary(100,25);
        addObject(sr9, 570, 25);  
        sr9.setRotation(30);

        Boundary sr10 = new Boundary(25,200);
        addObject(sr10, 475, -10);  
        sr10.setRotation(60);

        Boundary sr11 = new Boundary(200,25);
        addObject(sr11, 330, 0);  
        sr11.setRotation(30);

        Boundary sr12 = new Boundary(200,25);
        addObject(sr12, 270, 120);  
        sr12.setRotation(30);

        Boundary sr13 = new Boundary(25,225);
        addObject(sr13, 100, 80);  
        sr13.setRotation(90);

        Boundary sr14 = new Boundary(25,50);
        addObject(sr14, 20, 50);  
        sr14.setRotation(90);

        //middle world

        Boundary mw1 = new Boundary(25,300);
        addObject(mw1, -300,-25);  
        mw1.setRotation(-60);

        Boundary mw2 = new Boundary(100,25);
        addObject(mw2, -345,-125);  
        mw2.setRotation(-30);

        Boundary mw3 = new Boundary(100,25);
        addObject(mw3, -330,-160);  
        mw3.setRotation(60);

        Boundary mw4 = new Boundary(100,25);
        addObject(mw4, -290,-250);  
        mw4.setRotation(-30);

        Boundary mw5 = new Boundary(100,25);
        addObject(mw5, -170,-250);  
        mw5.setRotation(-30);

        Boundary mw6 = new Boundary(25,100);
        addObject(mw6, -165,-320);  
        mw6.setRotation(-35);

        Boundary mw7 = new Boundary(25,100);
        addObject(mw7, 230,-150);  
        mw7.setRotation(-60);

        Boundary mw8 = new Boundary(25,100);
        addObject(mw8, 135,-200);  
        mw8.setRotation(-60);

        Boundary mw9 = new Boundary(25,100);
        addObject(mw9, 50,-290);  
        mw9.setRotation(-60);

        Boundary mw10 = new Boundary(25,80);
        addObject(mw10, -100,-50);  
        mw10.setRotation(-60);

        Boundary mw11 = new Boundary(25,80);
        addObject(mw11, -90,-80);  
        mw11.setRotation(-60);

        Boundary mw12 = new Boundary(80,25);
        addObject(mw12, -35,-60);  
        mw12.setRotation(-60);

        Boundary mw13 = new Boundary(100,25);
        addObject(mw13, 60,-360);  
        mw13.setRotation(-30);

        Boundary mw14 = new Boundary(25,100);
        addObject(mw14, 40,-450);  
        mw14.setRotation(-60);

        Boundary mw15 = new Boundary(100,25);
        addObject(mw15, -150,-450);  
        mw15.setRotation(-30);

        Boundary mw16 = new Boundary(100,25);
        addObject(mw16, -70,-490);  
        mw15.setRotation(-30);

        portal = new Portal(portal);

        SpiderWorld spy1 = new SpiderWorld();
        spy1.addObject(portal, -580, 510);

        //addObject(new Fog(0, 0), getWidth()/2, getHeight()/2);

        for(int x = 0; x < 32; x++){
            for(int y = 0; y < 36; y++){//for each cell in the array
                //depending on the cell code, add/initialize objects (see map code at top for reference of what codes correspond to what objects

                if(mapTwo[x][y]==1){
                    wallListTwo[x][y]=new Wall(x, y);
                    //addObject(wallListTwo[x][y], (400 - x * 14 + y * 14-1), (140 + x * 7 + y * 7));

                    addObject(wallListTwo[x][y], (-65 - x * blockW + y * 30-1), (-445 + x * blockH + y * 16));

                    //X values: higher the value the more it shifts right, Y values: the higher the more the it shifts down

                    if (Greenfoot.getRandomNumber(10) == 1 && (Math.abs(x-11) > 3 && Math.abs(y-32) > 2)){
                        mapTwo[x][y] = 9;
                        addObject(new Enemy(x, y, Greenfoot.getRandomNumber(2)), 0, 0);
                    }

                }

            }
        }

        addObject(closest, -1000, -1000);
    }

    //test
    private int ox, oy;
    private int offX, offY;
    /**
     * Set an Object at an X and Y Value
     * @param cX X coordinate
     * @param cY Y coordinate
     */
    public void moveThing(int cX, int cY){
        GreenfootImage image = getBackground();
        xd = cX;
        yd = cY;
        wbg2.setLocation(xd, yd);
    }
    /**
     * Act Method 
     */
    public void act()
    {
        
        p = (ArrayList<Player>)getObjects(Player.class);
        pl = p.get(0);
        
        if (getObjects(Enemy.class) == null)
        {
            //LossScreen ls = new LossScreen(pl.getScore());
            //Greenfoot.setWorld(ls);
        }
        GameWorld.stopMusic();
        started();
        
        if (timer == 1){
            //get orgin
            ox = wbg2.getX();
            oy = wbg2.getY();
        } else {
            //start tracking from orgin

            offX = wbg2.getX() - ox;
            offY = wbg2.getY() - oy;

        }

        //System.out.println("offset xy: " + offX + " " + offY);

        timer++;

        
        p = (ArrayList<Player>)getObjects(Player.class);
        pl = p.get(0);
        
        if (getObjects(Enemy.class) == null){
            Greenfoot.setWorld(new LossScreen(pl.getScore()));
        }



        // System.out.println("mx " + getBlockCoord(1, 1).getX());
        //System.out.println("mky " + getBlockCoord(1, 1).getY());

        checkUserGrid();


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
    /**
     * Updates Hp of Player
     * @param hp Health
     */
    public static void updateHP(int hp){
        health.update((int)(hp));
    }
    //update stamina bar
    /**
     * Updates stamina of Player
     * @param st Stamina
     */
    public static void updateStamina(int st){
        stamina.update((int)(st));
    }

    //puts the user onto the grid based on coords
    /**
     * Places the user onto the grid based on coordinates
     * @return Pair Pair of coordinates for Player to be placed
     */
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
                    if ((Math.abs((pl.getX() + pl.getImage().getWidth()/2) - wallListTwo[i][j].getX()) < Math.abs((pl.getX() + pl.getImage().getWidth()/2) - closest.getX())) && (Math.abs((pl.getY() + pl.getImage().getHeight()/2) - wallListTwo[i][j].getY()) < Math.abs((pl.getY() + pl.getImage().getHeight()/2) - closest.getY()))){
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
    /**
     * Returns a copy of the MapArray
     * @return int[][] Copy of Map Array
     */
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
        ArrayList<Player> p = (ArrayList<Player>)getObjects(Player.class);
        Player pl = p.get(0);
        //Wall temp = wallListTwo[0][0];

        //int a = temp.getX(), b = temp.getY();

        //WILL RETURN NULL IF THERE IS NO BLOCK!!!!
        if (wallListTwo[x][y] == null){
            return new Pair(0, 0);
        } else {
            if (timer < 2){
                return new Pair(wallListTwo[x][y].getX()+xoff, wallListTwo[x][y].getY()+yoff);
            }

            return new Pair(wallListTwo[x][y].getX()-offX, wallListTwo[x][y].getY()-offY);
        }

    }
    /**
     * Get the Block Size/dimensions of a block
     * @return Pair Dimensions of block
     */
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
    /**
     * Set the grid position of the player 
     * @param x X coordinate
     * @param y Y coordinate
     * @param v Grid value 
     */
    public void setGridPosition(int x, int y, int v){
        mapTwo[x][y] = v;
    }
    
    /**
     * Starts the theme music when world starts
     * 
     */
    public void started()//starts the theme music when world starts
    {
        winter.playLoop();
        winter.setVolume(40);
    }
    
    /**
     * Stops the theme music when paused
     * 
     */
    public void stopped()// stops the theme music when paused
    {
        winter.stop();
    }
    
    
    /**
     * Stops the theme music for other worlds
     * 
     */
    public static void stopMusic()// stops the theme sound when paused
    {
        winter.stop();
    }

}
