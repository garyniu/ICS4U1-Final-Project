import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends GridMovement
{
    //TODO 
    //Attacks(Justin)
    //Sprites(Justin)
    //Items(Victor)
    //Movement(Gary)
    
    private int timer = 0;
    
    
    //charater animation images
    private GreenfootImage[] upImages;
    private GreenfootImage[] downImages;
    private GreenfootImage[] rightImages;
    private GreenfootImage[] leftImages;
    
    //animation image speed
    private SimpleTimer actionTimer;
    private int delay = 0;
    private boolean isFacingRight = true;
    private boolean isFacingUp = true;
    
    private int size = 75;//quick way to adjust all the MainCharater's image sizes
    private int CharaterSpeed = 2;//quick way to adjust all the MainCharater's speed
    private int SprintSpeed = 5;
    
    
    public Player(int x, int y){
        super(x, y);
        upImages = new GreenfootImage[9];
        downImages = new GreenfootImage[9];
        rightImages = new GreenfootImage[9];
        leftImages = new GreenfootImage[9];
        
        for(int i = 0; i < downImages.length; i++)//main charater walking down animation 
        {
             downImages[i] = new GreenfootImage("images/animate1/down" + i + ".png");
             downImages[i].scale(size, size);
        }
        
        for(int i = 0; i < downImages.length; i++)//main charater walking up animation 
        {
             upImages[i] = new GreenfootImage("images/animate3/up" + i + ".png");
             upImages[i].scale(size, size);
        }
        
        for(int i = 0; i < rightImages.length; i++)//main charater walking left and right animation 
        {
             rightImages[i] = new GreenfootImage("images/animate2/right" + i + ".png");
             rightImages[i].scale(size, size);
             
             leftImages[i] = new GreenfootImage("images/animate2/right" + i + ".png");
             leftImages[i].mirrorHorizontally();
             leftImages[i].scale(size, size);
        }
        setImage(rightImages[0]);

        actionTimer = new SimpleTimer();
        actionTimer.mark();
        
    }
    
    public void act()
    {
        timer++;
        super.act();
        
        
        if (Greenfoot.isKeyDown("w")){
            moveUp();
        } else if (Greenfoot.isKeyDown("s")){
            moveDown();
        } else if (Greenfoot.isKeyDown("a")){
            moveLeft();
        } else if (Greenfoot.isKeyDown("d")){
            moveRight();
        }
    }
}
