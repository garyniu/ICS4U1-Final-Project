import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossWorld extends World
{
    
    private GreenfootImage background = new GreenfootImage("images/background/boss1.jpg");
    
    private WorldBackground wbg;
    
    private int xd = 0, yd = 0;
    
    //stat bar
    private static SuperStatBar health;
    private static SuperStatBar stamina;
    /**
     * Constructor for objects of class BossWorld.
     * 
     */
    public BossWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 1500, 1); 
        
        setPaintOrder(Boundary.class, SuperStatBar.class, PlayerHitbox.class, Player.class, BossEnemy.class, Enemy.class, Portal.class, EnterPortal.class, Wall.class, WorldBackground.class);

        wbg = new WorldBackground(background);

        GreenfootImage bg = new GreenfootImage(640, 500);
        bg.setColor(Color.BLACK);
        bg.fill();
        setBackground(bg);
        
        //stat bar
        //stamina
        stamina = new SuperStatBar(500, 500, null, 150, 10, 0, Color.GREEN, Color.BLACK, false, Color.GRAY, 3);
        addObject(stamina, 70, 15);
        //hp
        health = new SuperStatBar (100, 100, null, 200, 15, 0, Color.RED, Color.BLACK, false, Color.GRAY, 3);
        addObject(health, 95, 5);
        
       
        
        addObject(wbg, this.getWidth()/2, this.getHeight()/2);
    }
}
