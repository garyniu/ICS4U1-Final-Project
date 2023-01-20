import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends FreeMovement
{
    //TODO 
    //Attacks(Justin)
    //Sprites(Justin)
    //Items(Victor)
    //Movement(Gary)

    //charater animation images
    private GreenfootImage[] upImages;
    private GreenfootImage[] downImages;
    private GreenfootImage[] rightImages;
    private GreenfootImage[] leftImages;
    //character attack animation images
    private GreenfootImage[] aupImages;
    private GreenfootImage[] adownImages;
    private GreenfootImage[] arightImages;
    private GreenfootImage[] aleftImages;

    //animation image speed
    private SimpleTimer actionTimer;
    private int delay = 0;
    private boolean isFacingRight = true;
    private boolean isFacingUp = true;

    private int size = 60;//quick way to adjust all the MainCharater's image sizes
    private int atkSize = 180;
    private int CharacterSpeed = 1;//quick way to adjust all the MainCharater's speed
    private int SprintSpeed = 2;//quick way to adjust all the MainCharater's sprint speed
    
    public Player(int x, int y){
        super(x, y);
        //walk
        upImages = new GreenfootImage[9];
        downImages = new GreenfootImage[9];
        rightImages = new GreenfootImage[9];
        leftImages = new GreenfootImage[9];
        //attack
        aupImages = new GreenfootImage[6];
        adownImages = new GreenfootImage[6];
        arightImages = new GreenfootImage[6];
        aleftImages = new GreenfootImage[6];

        //walk
        for(int i = 0; i < downImages.length; i++)//main charater walking down animation 
        {
            downImages[i] = new GreenfootImage("images/walk/down/down" + i + ".png");
            downImages[i].scale(size, size);
        }
        for(int i = 0; i < upImages.length; i++)//main charater walking up animation 
        {
            upImages[i] = new GreenfootImage("images/walk/up/up" + i + ".png");
            upImages[i].scale(size, size);
        }
        for(int i = 0; i < rightImages.length; i++)//main charater walking left and right animation 
        {
            rightImages[i] = new GreenfootImage("images/walk/right/right" + i + ".png");
            rightImages[i].scale(size, size);

            leftImages[i] = new GreenfootImage("images/walk/right/right" + i + ".png");
            leftImages[i].mirrorHorizontally();
            leftImages[i].scale(size, size);
        }

        //attack
        for(int i = 0; i < adownImages.length; i++)//main charater walking down animation 
        {
            adownImages[i] = new GreenfootImage("images/attack/down/down" + i + ".png");
            adownImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < aupImages.length; i++)//main charater walking up animation 
        {
            aupImages[i] = new GreenfootImage("images/attack/up/up" + i + ".png");
            aupImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < arightImages.length; i++)//main charater walking left and right animation 
        {
            arightImages[i] = new GreenfootImage("images/attack/right/right" + i + ".png");
            arightImages[i].scale(atkSize, atkSize);

            aleftImages[i] = new GreenfootImage("images/attack/right/right" + i + ".png");
            aleftImages[i].mirrorHorizontally();
            aleftImages[i].scale(atkSize, atkSize);
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
            if(curIndex == 6){
                curIndex = 0;
            }
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
            if(curIndex == 6){
                curIndex = 0;
            }
            actionTimer.mark();
        }
    }

    public void verticalAttack(){
        if(actionTimer.millisElapsed() > 100)
        {

            if (isFacingUp)
            {
                setImage(aupImages[curIndex]);
            }
            else
            {
                setImage(adownImages[curIndex]);
            }
            curIndex++;
            if(curIndex == 6){
                curIndex = 0;
            }
            actionTimer.mark();
        }
    }

    public void horizontalAttack(){
        if(actionTimer.millisElapsed() > 100)
        {
            if (isFacingRight)
            {
                setImage(arightImages[curIndex]);
            }
            else
            {
                setImage(aleftImages[curIndex]);
            }

            curIndex++;
            if(curIndex == 6){
                curIndex = 0;
            }
            actionTimer.mark();
        }
    }

    public void act()
    {
        super.act();

        //movement
        if(Greenfoot.isKeyDown("d")){//MainCharater moves right
            isFacingRight = true;
            moveRight();
            idleAction();
        }
        if(Greenfoot.isKeyDown("a")){//MainCharater moves left
            isFacingRight = false;
            moveLeft();
            idleAction();
        }
        if(Greenfoot.isKeyDown("w")){//MainCharater moves up
            int x = getX();
            int y = getY();
            moveUp();

            isFacingUp = true;
            idleActionTwo();
        }
        if(Greenfoot.isKeyDown("s")){//MainCharater moves down
            int x = getX();
            int y = getY();
            moveDown();
            
            isFacingUp = false;
            idleActionTwo();
        }
        
        //attack
        if(Greenfoot.isKeyDown("right")){//MainCharater moves right
            for(int i = 0; i < 6; i++){
                isFacingRight = true;
                horizontalAttack();
            }
        }
        if(Greenfoot.isKeyDown("left")){//MainCharater moves left
            for(int i = 0; i < 6; i++){
                isFacingRight = false;
                horizontalAttack();
            }
        }
        if(Greenfoot.isKeyDown("up")){//MainCharater moves up
            for(int i = 0; i < 6; i++){
                int x = getX();
                int y = getY();
                isFacingUp = true;
                verticalAttack();
            }
        }
        if(Greenfoot.isKeyDown("down")){//MainCharater moves down
            for(int i = 0; i < 6; i++){
                int x = getX();
                int y = getY();
                isFacingUp = false;
                verticalAttack();
            }
        }
    }
}