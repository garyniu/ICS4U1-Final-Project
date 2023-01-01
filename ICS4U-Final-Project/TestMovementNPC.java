import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * The playable charater that allows you to interect the world
 * 
 * @author Leo Xu
 * @date June 15 2022
 * 
 */
public class TestMovementNPC extends Actor
{
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
    
    private int size = 50;//quick way to adjust all the MainCharater's image sizes
    private int CharaterSpeed = 2;//quick way to adjust all the MainCharater's speed
    private int SprintSpeed = 5;//quick way to adjust all the MainCharater's sprint speed
    
    public TestMovementNPC()
    {
        upImages = new GreenfootImage[2];
        downImages = new GreenfootImage[2];
        rightImages = new GreenfootImage[2];
        leftImages = new GreenfootImage[2];
        
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
    
    int curIndex = 0;
    public void idleAction()//controls the animation image speed for moving left and right
    {
        if(actionTimer.millisElapsed() > 100)
        {
            if (isFacingRight)
            {
                setImage(rightImages[curIndex]);
            }
            else
            {
                setImage(leftImages[curIndex]);
            }
            
       
            curIndex++;
            curIndex %= 2;
            actionTimer.mark();
        }
    }
    
    public void idleActionTwo()//controls the animation image speed for moving up and down
    {
        if(actionTimer.millisElapsed() > 100)
        {
            
             if (isFacingUp)
            {
                setImage(upImages[curIndex]);
            }
            else
            {
                setImage(downImages[curIndex]);
            }
            curIndex++;
            curIndex %= 2;
            actionTimer.mark();
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("d"))//MainCharater moves right
        {
            isFacingRight = true;
            move(CharaterSpeed);
            idleAction();
            
            if(Greenfoot.isKeyDown("c"))//MainCharater sprints right
            {
                isFacingRight = true;
                move(SprintSpeed);
            }
        }
        
        if(Greenfoot.isKeyDown("a"))//MainCharater moves left
        {
            isFacingRight = false;
            move(-CharaterSpeed);
            idleAction();
            
            if(Greenfoot.isKeyDown("c"))//MainCharater sprints left
            {
                 isFacingRight = false;
                move(-SprintSpeed);
            }
        }
        
        if(Greenfoot.isKeyDown("w"))//MainCharater moves up
        {
            int x = getX();
            int y = getY();
            setLocation(x, y -CharaterSpeed);
            
            isFacingUp = true;
            idleActionTwo();
            
            if(Greenfoot.isKeyDown("c"))//MainCharater sprints up
            {
                
                setLocation(x, y -SprintSpeed);   
            }
        }
        
        if(Greenfoot.isKeyDown("s")) //MainCharater moves down
        {
            int x = getX();
            int y = getY();
            setLocation(x, y + CharaterSpeed);
            isFacingUp = false;
            idleActionTwo();
            
              if(Greenfoot.isKeyDown("c"))//MainCharater sprints down
            {
                
                setLocation(x, y + SprintSpeed);   
            }
        }
    }
    
    public void setLocation(int x, int y)//When MainCharater touches Boundary, it stops MainCharater from moving further
    {
        int oldX = getX();
        int oldY = getY();
        super.setLocation(x, y);
        /*if(!getIntersectingObjects(Boundary.class).isEmpty())
        {
            super.setLocation(oldX, oldY);
        }*/
    }
}
