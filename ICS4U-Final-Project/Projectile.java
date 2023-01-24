import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends FreeMovement
{
    //BUGS
    //has to hold down e to play attack animation
    //attack animation can start at random images

    //arrow animation
    private GreenfootImage arrowUpImage;
    private GreenfootImage arrowDownImage;
    private GreenfootImage arrowLeftImage;
    private GreenfootImage arrowRightImage;

    //vertical + horizontal booleans
    private boolean isFacingUp, isFacingDown, isFacingLeft, isFacingRight = false;
    //diagonal booleans
    private boolean isFacingLeftUp, isFacingRightUp, isFacingLeftDown, isFacingRightDown;
    
    //location
    private int x, y;

    //player variables
    //player sizes(orignal image size)
    private int size = 60;
    
    //player speed variables
    private int speed = 10;
    
    //player damage variables(for enemy)
    private int damage = 5;
    
    //animation image speed
    private SimpleTimer actionTimer;
    private int delay = 0;
    private int dashTime;

    public Projectile(int x, int y, int dir){
        super(x, y);
        //arrow
        //up
        arrowUpImage = new GreenfootImage("images/PlayerAnimations/bowAttack/verticalArrow" + ".png");
        //down
        arrowDownImage = new GreenfootImage("images/PlayerAnimations/bowAttack/verticalArrow" + ".png");
        arrowDownImage.mirrorVertically();
        //left
        arrowLeftImage = new GreenfootImage("images/PlayerAnimations/bowAttack/horizontalArrow" + ".png");
        //right
        arrowRightImage = new GreenfootImage("images/PlayerAnimations/bowAttack/horizontalArrow" + ".png");
        arrowRightImage.mirrorHorizontally();
        //set sizes
        arrowUpImage.scale(size, size);
        arrowDownImage.scale(size, size);
        arrowLeftImage.scale(size, size);
        arrowRightImage.scale(size, size);
        
        //determine direction of arrow
        if(dir == 1){//up
            isFacingUp = true;
            isFacingDown = false;
            isFacingLeft = false;
            isFacingRight = false;
            setImage(arrowUpImage);
        }else if(dir == 2){//down
            isFacingUp = false;
            isFacingDown = true;
            isFacingLeft = false;
            isFacingRight = false;
            setImage(arrowDownImage);
        }else if(dir == 3){//left
            isFacingUp = false;
            isFacingDown = false;
            isFacingLeft = true;
            isFacingRight = false;
            setImage(arrowLeftImage);
        }else if(dir == 4){//right
            isFacingUp = false;
            isFacingDown = false;
            isFacingLeft = false;
            isFacingRight = true;
            setImage(arrowRightImage);
        }
        
        actionTimer = new SimpleTimer();
        actionTimer.mark();
    }

    //movement
    public void moveLeft(){
        posx -= speed;
        dir = "R";
    }
    public void moveRight(){
        posx += speed;
        dir = "L";
    }
    public void moveUp(){
        posy-=2; 
        dir = "D";
    }
    public void moveDown(){
        posy+=2;
        dir = "U";
    }

    public void arrowMoving(){
        if(actionTimer.millisElapsed() < 1000)
        {
            if(isFacingUp){
                moveUp();
            }else if(isFacingDown){
                moveDown();
            }else if (isFacingLeft){
                moveLeft();
            }else if(isFacingRight){
                moveRight();
            }
            
            actionTimer.mark();
        }
    }
    
    public void act()
    {
        super.act();
        x = getX();
        y = getY();
    }
}