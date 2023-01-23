import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerHitbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerHitbox extends FreeMovement
{

    //32-51
    private int x, y;
    private GreenfootImage boundImage = new GreenfootImage ("images/misc/baal2.png");

    //animation image speed
    private SimpleTimer actionTimer;
    private int width = 30;
    private int length = 50;
    
    private int playerSpeed = 2;//Player speed
    private int sprintSpeed = 4;//Player spriting speed
    private boolean sprinting = false;//sprinting boolean

    public PlayerHitbox(int x, int y){
        super(x, y);
        //walk

        //walk
        boundImage.scale(width, length);
    }

    public void act()
    {
        super.act();
        x = getX();
        y = getY();
        
        setImage(boundImage);
        
        //movement
        //a and d goes first so the horizontal walking animation always plays
        //when moving diagonally(looks better since there is no horizontal animation)
        if (Greenfoot.isKeyDown("a")){//detect left
            moveLeft();
        }
        if (Greenfoot.isKeyDown("d")){//detect right
            moveRight();
        }
        if (Greenfoot.isKeyDown("w")){//detect up
            moveUp();
        }
        if (Greenfoot.isKeyDown("s")){//detect down
            moveDown();
        }
        
        /*//sprint toggling with shift key (works weird)
        if(!sprinting){
            if(Greenfoot.isKeyDown("Shift")){
                FreeMovement.setPlayerSpeed(10);//sprinting speed
                sprinting = true;
            }
        }else if(sprinting){
            if(Greenfoot.isKeyDown("Shift")){
                FreeMovement.setPlayerSpeed(2);//walking speed
                sprinting = false;
            }
        }*/
        //sprint toggling
        if(Greenfoot.isKeyDown(",")){
            FreeMovement.setPlayerSpeed(sprintSpeed);//sprinting speed
            sprinting = true;
        }
        if(Greenfoot.isKeyDown(".")){
            FreeMovement.setPlayerSpeed(playerSpeed);//walking speed
            sprinting = false;
        }
    }
}