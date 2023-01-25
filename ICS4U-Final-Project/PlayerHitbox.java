import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Follows the Player class around acting as it's hitbox in order to not have
 * collision issues when Player's image size increases/decreases from animations
 * 
 * @author Justin Sin
 * @version 1.0
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
    
    //player speed variables
    private int playerSpeed = 2;
    private int sprintSpeed = 3;
    private boolean sprinting = false;

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
        //Sprint key with Shift
        if(Greenfoot.isKeyDown("Shift")){
            FreeMovement.setPlayerSpeed(sprintSpeed);//sprinting speed
            sprinting = true;
        }else{
            FreeMovement.setPlayerSpeed(playerSpeed);//walking speed
            sprinting = false;
        }
    }
}