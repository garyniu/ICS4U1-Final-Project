import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends FreeMovement
{
    //BUGS
    //holding down w/a/s/d with e breaks the game
    //has to hold down e to play attack animation
    //attack animation can start at random images
    //player attack animation happens twice in portal world

    //charater animation images
    private GreenfootImage[] upImages;
    private GreenfootImage[] downImages;
    private GreenfootImage[] rightImages;
    private GreenfootImage[] leftImages;
    //character attack animation images
    private GreenfootImage[] attackUpImages;
    private GreenfootImage[] attackDownImages;
    private GreenfootImage[] attackRightImages;
    private GreenfootImage[] attackLeftImages;

    //vertical+horizontal booleans
    private boolean isFacingUp, isFacingDown, isFacingLeft, isFacingRight = false;
    //diagonal booleans
    private boolean isFacingLeftUp, isFacingRightUp, isFacingLeftDown, isFacingRightDown;

    private int x, y;

    //animation image speed
    private SimpleTimer actionTimer;
    private int delay = 0;
    private int dashTime;

    private int size = 60;//quick way to adjust all the MainCharater's image sizes
    private int atkSize = 180;
    private int characterSpeed = 1;//quick way to adjust all the MainCharater's speed
    private int SprintSpeed = 2;//quick way to adjust all the MainCharater's sprint speed
    private boolean sprinting = false;

    public Player(int x, int y){
        super(x, y);
        //walk
        upImages = new GreenfootImage[9];
        downImages = new GreenfootImage[9];
        rightImages = new GreenfootImage[9];
        leftImages = new GreenfootImage[9];
        //attack
        attackUpImages = new GreenfootImage[6];
        attackDownImages = new GreenfootImage[6];
        attackRightImages = new GreenfootImage[6];
        attackLeftImages = new GreenfootImage[6];

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
        for(int i = 0; i < attackDownImages.length; i++)//main charater walking down animation 
        {
            attackDownImages[i] = new GreenfootImage("images/attack/down/down" + i + ".png");
            attackDownImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < attackUpImages.length; i++)//main charater walking up animation 
        {
            attackUpImages[i] = new GreenfootImage("images/attack/up/up" + i + ".png");
            attackUpImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < attackRightImages.length; i++)//main charater walking left and right animation 
        {
            attackRightImages[i] = new GreenfootImage("images/attack/right/right" + i + ".png");
            attackRightImages[i].scale(atkSize, atkSize);

            attackLeftImages[i] = new GreenfootImage("images/attack/right/right" + i + ".png");
            attackLeftImages[i].mirrorHorizontally();
            attackLeftImages[i].scale(atkSize, atkSize);
        }
        setImage(rightImages[0]);

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
        //posy-=2; 
        
        setLocationCam(posx, posy -= speed, Spawnx, Spawny);
        dir = "D";
    }
    public void moveDown(){
        //posy+=2;
        
        setLocationCam(posx, posy += speed, Spawnx, Spawny);
        dir = "U";
    }
    
    int curIndex = 0;
    //horizontal walking animation
    public void hAction()//controls the animation image speed for moving left and right
    {
        if(actionTimer.millisElapsed() > 100)
        {
            if (isFacingRight){
                setImage(rightImages[curIndex]);
            }else if(isFacingLeft){
                setImage(leftImages[curIndex]);
            }

            curIndex++;
            if(curIndex == 6){
                curIndex = 0;
            }
            actionTimer.mark();
        }
    }
    //vertical walking animation
    public void vAction()//controls the animation image speed for moving up and down
    {
        if(actionTimer.millisElapsed() > 100)
        {
            if (isFacingUp){
                setImage(upImages[curIndex]);
            }else if(isFacingDown){
                setImage(downImages[curIndex]);
            }
            
            curIndex++;
            if(curIndex == 6){
                curIndex = 0;
            }
            actionTimer.mark();
        }
    }

    //attack animation
    public void attack(){
        if(actionTimer.millisElapsed() > 100){
            if (isFacingRight){
                setImage(attackRightImages[curIndex]);
            }else if(isFacingLeft){
                setImage(attackLeftImages[curIndex]);
            }else if (isFacingUp){
                setImage(attackUpImages[curIndex]);
            }else if(isFacingDown){
                setImage(attackDownImages[curIndex]);
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
        x = getX();
        y = getY();
        String dashed = Greenfoot.getKey();

        //movement
        //a and d goes first so the horizontal walking animation always plays
        //when moving diagonally(looks better since there is no horizontal animation)
        if (Greenfoot.isKeyDown("a")){//detect left
            moveLeft();
            isFacingUp = false;
            isFacingDown = false;
            isFacingLeft = true;
            isFacingRight = false;
            hAction();
            if(Greenfoot.isKeyDown("w")){//detect up
                isFacingLeftUp = true;
                isFacingRightUp = false;
                isFacingLeftDown = false;
                isFacingRightDown = false;
            }else if(Greenfoot.isKeyDown("s")){//detect down
                isFacingLeftUp = false;
                isFacingRightUp = false;
                isFacingLeftDown = true;
                isFacingRightDown = false;
            }
        }
        if (Greenfoot.isKeyDown("d")){//detect right
            moveRight();
            isFacingUp = false;
            isFacingDown = false;
            isFacingLeft = false;
            isFacingRight = true;
            hAction();
            if(Greenfoot.isKeyDown("w")){//detect up
                isFacingLeftUp = false;
                isFacingRightUp = true;
                isFacingLeftDown = false;
                isFacingRightDown = false;
            }else if(Greenfoot.isKeyDown("s")){//detect down
                isFacingLeftUp = false;
                isFacingRightUp = false;
                isFacingLeftDown = false;
                isFacingRightDown = true;
            }
        }
        if (Greenfoot.isKeyDown("w")){//detect up
            moveUp();
            isFacingUp = true;
            isFacingDown = false;
            isFacingLeft = false;
            isFacingRight = false;
            vAction();
            if(Greenfoot.isKeyDown("a")){//detect left
                isFacingLeftUp = true;
                isFacingRightUp = false;
                isFacingLeftDown = false;
                isFacingRightDown = false;
            }else if(Greenfoot.isKeyDown("d")){//detect right
                isFacingLeftUp = false;
                isFacingRightUp = true;
                isFacingLeftDown = false;
                isFacingRightDown = false;
            }
        }
        if (Greenfoot.isKeyDown("s")){//detect down
            moveDown();
            isFacingUp = false;
            isFacingDown = true;
            isFacingLeft = false;
            isFacingRight = false;
            vAction();
            if(Greenfoot.isKeyDown("a")){//detect left
                isFacingLeftUp = false;
                isFacingRightUp = false;
                isFacingLeftDown = true;
                isFacingRightDown = false;
            }else if(Greenfoot.isKeyDown("d")){//detect right
                isFacingLeftUp = false;
                isFacingRightUp = false;
                isFacingLeftDown = false;
                isFacingRightDown = true;
            }
        }
        //plays attack animation when pressing e
        if(Greenfoot.isKeyDown("e")){
            attack();
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

        if(Greenfoot.isKeyDown(",")){
            FreeMovement.setPlayerSpeed(10);//sprinting speed
        }
        if(Greenfoot.isKeyDown(".")){
            FreeMovement.setPlayerSpeed(2);//walking speed
        }
        
        /*if("shift".equals(dashed))
        {
            System.out.println("player has dashed");
            if(isFacingUp == true)
            {
                if(dashTime == 0)
                {
                    characterSpeed = 2;
                }
                if(dashTime <= 30)
                {
                    characterSpeed += 5;
                    dashTime += 30;
                }
                if(dashTime >= 30)
                {
                    characterSpeed = 2;
                }
            }
        }

        if (Greenfoot.isKeyDown("shift"))
        {
            if(isFacingUp == true)
            {
                if(dashed == "shift")
                {

                }
                if(dashTime == 0)
                {
                    characterSpeed = 2;
                }
                if(dashTime <=30)
                {
                    dashTime++;
                    characterSpeed += 1;
                }
                if(dashTime >= 30)
                {
                    characterSpeed = 2;
                    dashTime = 0;
                }
            }
        }

        //attack
        if(Greenfoot.isKeyDown("right")){//MainCharater moves right
            for(int i = 0; i < 6; i++){
                isFacingRight = true;
                hAttack();
            }
        }
        if(Greenfoot.isKeyDown("left")){//MainCharater moves left
            for(int i = 0; i < 6; i++){
                isFacingRight = false;
                hAttack();
            }
        }
        if(Greenfoot.isKeyDown("up")){//MainCharater moves up
            for(int i = 0; i < 6; i++){
                int x = getX();
                int y = getY();
                isFacingUp = true;
                vAttack();
            }
        }
        if(Greenfoot.isKeyDown("down")){//MainCharater moves down
            for(int i = 0; i < 6; i++){
                int x = getX();
                int y = getY();
                isFacingUp = false;
                vAttack();
            }
        }*/
    }
}