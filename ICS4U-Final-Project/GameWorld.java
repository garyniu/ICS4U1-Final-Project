import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * 
 * KNOWN ISSUES:
 * Bow does not work as intended, therefore it is commented out
 * Attacking an enemy will cause all enemies to disappear
 * Ending screen button returns to main screen, but it will not play again even if you press the play button
 * 
 * CREDITS:
 * Player Sprite:
 * Authors: bluecarrot16, Benjamin K. Smith (BenCreating), Evert, Eliza Wyatt (ElizaWy), TheraHedwig, MuffinElZangano, Durrani, Johannes Sj?lund (wulax), Stephen Challener (Redshrike), Matthew Krohn (makrohn), Manuel Riecke (MrBeast), Joe White, Michael Whitlock (bigbeargames), Johannes Sjölund (wulax), Nila122, David Conway Jr. (JaidynReiman)
 * 
 * - body/bodies/male/universal/light.png: by bluecarrot16, Benjamin K. Smith (BenCreating), Evert, Eliza Wyatt (ElizaWy), TheraHedwig, MuffinElZangano, Durrani, Johannes Sj?lund (wulax), Stephen Challener (Redshrike). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/liberated-pixel-cup-lpc-base-assets-sprites-map-tiles
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * - https://opengameart.org/content/lpc-male-jumping-animation-by-durrani
 * - https://opengameart.org/content/lpc-runcycle-and-diagonal-walkcycle
 * - https://opengameart.org/content/lpc-revised-character-basics
 * 
 * - head/heads/human_male/universal/light.png: by bluecarrot16, Benjamin K. Smith (BenCreating), Stephen Challener (Redshrike). License(s): OGA-BY 3.0, CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/liberated-pixel-cup-lpc-base-assets-sprites-map-tiles
 * - https://opengameart.org/content/lpc-character-bases
 * 
 * - eyes/male/blue.png: by Matthew Krohn (makrohn), Stephen Challener (Redshrike). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/liberated-pixel-cup-lpc-base-assets-sprites-map-tiles
 * 
 * - hair/plain/male/black.png: by Manuel Riecke (MrBeast), Joe White. License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/liberated-pixel-cup-lpc-base-assets-sprites-map-tiles
 * - https://opengameart.org/content/ponytail-and-plain-hairstyles
 * 
 * - arms/armour/plate/male/iron.png: by Michael Whitlock (bigbeargames), Matthew Krohn (makrohn), Johannes Sjölund (wulax). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * - http://opengameart.org/content/lpc-clothing-updates
 * 
 * - bauldron/male/walnut.png: by Nila122. License(s): GPL 2.0, GPL 3.0, CC-BY-SA 3.0. 
 * - https://opengameart.org/content/more-lpc-clothes-and-hair
 * 
 * - torso/clothes/longsleeve/male/black.png: by David Conway Jr. (JaidynReiman), Johannes Sjölund (wulax). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * - http://opengameart.org/content/lpc-clothing-updates
 *
 * - torso/armour/leather/male/black.png: by Johannes Sjölund (wulax). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * - http://opengameart.org/content/lpc-clothing-updates
 * 
 * - cape/solid/female/black.png: by bluecarrot16, David Conway Jr. (JaidynReiman). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-curly-hair-elven-ears-white-cape-with-blue-trim-and-more
 * - https://opengameart.org/content/lpc-roman-armor
 * - http://opengameart.org/content/lpc-clothing-updates
 * 
 * - cape/solid_behind/black.png: by Nila122, David Conway Jr. (JaidynReiman). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-curly-hair-elven-ears-white-cape-with-blue-trim-and-more
 * - https://opengameart.org/content/lpc-roman-armor
 * 
 * - legs/armour/plate/male/steel.png: by bluecarrot16, Michael Whitlock (bigbeargames), Johannes Sjölund (wulax). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * 
 * - feet/boots/male/black.png: by bluecarrot16, Nila122. License(s): CC-BY-SA 3.0, GPL 2.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-clothes-and-hair
 * - https://opengameart.org/content/lpc-santa
 * - http://opengameart.org/content/lpc-clothing-updates
 * 
 * MUSIC CREDITS:
 * main theme (https://www.youtube.com/watch?v=Q7eJg7hRvqE)
 * 
 * @author Justin, Leo, Gary, Victor
 * @version December 31
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
    
    private static SuperStatBar health;
    private static SuperStatBar stamina;
    
    private static GreenfootSound waitMusic;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 720x405 cells with a cell size of 1x1 pixels.
        super(600, 500, 1, false);

                
        //setPaintOrder(Fog.class, Boundary.class, SuperStatBar.class, PlayerHitbox.class, Player.class, BossEnemy.class, Enemy.class, Items.class, Portal.class, EnterPortal.class, Wall.class, WorldBackground.class);
        setPaintOrder(SuperStatBar.class, Fog.class, Boundary.class, GameCover1.class, PlayerHitbox.class, Player.class, BossEnemy.class, Enemy.class, Portal.class, EnterPortal.class, Wall.class, WorldBackground.class);


        setPaintOrder(Fog.class, Boundary.class, SuperStatBar.class, PlayerHitbox.class, Player.class, BossEnemy.class, Enemy.class, Items.class, Portal.class, EnterPortal.class, Wall.class, WorldBackground.class);
        setPaintOrder(Fog.class, Boundary.class, GameCover1.class, SuperStatBar.class, PlayerHitbox.class, Player.class, BossEnemy.class, Enemy.class, Items.class, Portal.class, EnterPortal.class, Wall.class, WorldBackground.class);



        waitMusic = new GreenfootSound("sounds/waiting.mp3");

        wbg = new WorldBackground(background);

        GreenfootImage bg = new GreenfootImage(640, 500);
        bg.setColor(Color.BLACK);
        bg.fill();
        setBackground(bg);
        
        //Enter Portal
        Others ep = new EnterPortal();
        addObject(ep, 560, 215);
    
        stamina = new SuperStatBar(500, 500, null, 150, 10, 0, Color.GREEN, Color.BLACK, false, Color.GRAY, 3);
        addObject(stamina, 70, 15);
        //hp
        health = new SuperStatBar (100, 100, null, 200, 15, 0, Color.RED, Color.BLACK, false, Color.GRAY, 3);
        addObject(health, 95, 5);
        
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
        world2.addObject(portal, -420, 300);

        //player
        FreeMovement playerTest = new Player(250, 400);
        addObject(playerTest, this.getWidth()/2, this.getHeight()/2);
        //hitbox for player
        FreeMovement playerTest2 = new PlayerHitbox(250, 400);
        addObject(playerTest2, this.getWidth()/2, this.getHeight()/2);

        addObject(wbg, this.getWidth()/2, this.getHeight()/2);
        

        Items chest1 = new Items();
        this.addObject(chest1, 260, 180);
        //GameCover
        GameCover1 c1 = new GameCover1();
        addObject(c1, 145, 355);
        

        
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

        Boundary bound9 = new Boundary(20,50);
        addObject(bound9, 460, 340);  
        bound9.setRotation(-20);

        Boundary bound10 = new Boundary(50,35);
        addObject(bound10, 320, 230);  
        bound10.setRotation(35);

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

    /**
     * Updates Hp of Player
     * @param hp Health
     */
    public static void updateHP(int hp){
        //health.update((int)(hp));
    }
    /**
     * Updates Stamina Bar for Player
     * @param st Stamina
     */
    public static void updateStamina(int st){
        stamina.update((int)(st));
    }
    /**
     * Act Method 
     */
    public void act()
    {
        started();
        MouseInfo m = Greenfoot.getMouseInfo();
        if (m != null)
        {
            showText("mouseX: " + String.valueOf(m.getX()), 120, 30);
            showText("mouseY: " + String.valueOf(m.getY()), 120, 70);
        }
        
        
    }
    /**
     * Set an Object at an X and Y Value
     * @param cX X coordinate
     * @param cY Y coordinate
     */
    public void setThing(int cX, int cY)
    {
        xd = this.getWidth()- cX;
        yd = this.getHeight() - cY;

        //System.out.println("newx and y: " + cX + " " + cY );

        wbg.setLocation(xd, yd);
    }
    /**
     * Move an Object to an X and Y Value
     * @param cX X coordinate
     * @param cY Y coordinate
     */
    public void moveThing(int cX, int cY){
        GreenfootImage image = getBackground();
        xd = cX;
        yd = cY;
        wbg.setLocation(xd, yd);
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

    //returns the top left corner position of the array on the screen
    /**
     * Returns the top Left corner position of the array on the screen
     * @return Pair Pair of coordinates
     */
    public Pair getMapOrigin(){
        Wall temp = wallListTwo[0][0];

        int a = temp.getX(), b = temp.getY();

        return new Pair(a, b);
    }

    //returns the width and height of a block
    /**
     * Returns the width and height of a block 
     * @return Pair Dimensions of a block
     */
    public Pair getMapBlockSize(){
        return new Pair(wallListTwo[0][0].getImage().getWidth(), wallListTwo[0][0].getImage().getHeight());
    }
    
    /**
     * Starts the theme music when world starts
     * 
     */
    public void started()//starts the theme music when world starts
    {
        waitMusic.playLoop();
        waitMusic.setVolume(40);
    }
    
    /**
     * Stops the theme music when paused
     * 
     */
    public void stopped()// stops the theme music when paused
    {
        waitMusic.stop();
    }
    
    
    /**
     * Stops the theme music for other worlds
     * 
     */
    public static void stopMusic()// stops the theme sound when paused
    {
        waitMusic.stop();
    }
}
