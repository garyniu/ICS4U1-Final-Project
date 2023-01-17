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
    
    private int x, y;
    //animation image speed
    private SimpleTimer actionTimer;
    private int delay = 0;
    
    private boolean isFacingUp, isFacingUpRight, isFacingUpLeft = false;
    
    private boolean isFacingDown, isFacingDownRight, isFacingDownLeft = false;
    
    private boolean isFacingLeft, isFacingRight = false;

    private int size = 75;//quick way to adjust all the MainCharater's image sizes
    private int CharaterSpeed = 2;//quick way to adjust all the MainCharater's speed
    private int SprintSpeed = 5;
    
        
    public Player(int x, int y){
        super(x, y);
        CharImg = new GreenfootImage("images/animate1/down2.png");
        setImage(CharImg);
    }
        
    public void act()
    {
        timer++;
        x = getX();
        y = getY();
            if (timer % 60 == 0){
            super.act();
            
            
            if (Greenfoot.isKeyDown("w")){
                moveUp();
                isFacingUp = true;
                isFacingRight = false;
                isFacingLeft = false;
                isFacingDown = false;
                isFacingDownRight = false;
                isFacingDownLeft = false;
                if(Greenfoot.isKeyDown("a"))
                {
                    isFacingUpLeft = true;
                }
                if(Greenfoot.isKeyDown("d"))
                {
                    isFacingUpRight = true;
                }
            }
            if (Greenfoot.isKeyDown("s")){
                moveDown();
                isFacingUp = false;
                isFacingRight = false;
                isFacingLeft = false;
                isFacingDown = true;
                isFacingDownRight = false;
                isFacingDownLeft = false;
                if(Greenfoot.isKeyDown("a"))
                {
                    isFacingDownLeft = true;
                }
                if(Greenfoot.isKeyDown("d"))
                {
                    isFacingDownRight = true;
                }
            }
            if (Greenfoot.isKeyDown("a")){
                moveLeft();
                isFacingLeft = true;
            }
            if (Greenfoot.isKeyDown("d")){
                moveRight();
                isFacingRight = true;
            }
            if (Greenfoot.isKeyDown("shift"))
            {
                if(isFacingUp == true)
                {
                    setLocation(x, y - 5);
                }
                if(isFacingUpRight == true)
                {
                     
                }
    
            }
        }
    }
}
