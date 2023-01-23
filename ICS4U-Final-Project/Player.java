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
    //longsword
    private GreenfootImage[] longswordAttackUpImages;
    private GreenfootImage[] longswordAttackDownImages;
    private GreenfootImage[] longswordAttackRightImages;
    private GreenfootImage[] longswordAttackLeftImages;
    //spear
    private GreenfootImage[] spearAttackUpImages;
    private GreenfootImage[] spearAttackDownImages;
    private GreenfootImage[] spearAttackRightImages;
    private GreenfootImage[] spearAttackLeftImages;
    //bow
    private GreenfootImage[] bowAttackUpImages;
    private GreenfootImage[] bowAttackDownImages;
    private GreenfootImage[] bowAttackRightImages;
    private GreenfootImage[] bowAttackLeftImages;

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
        //longsword attack
        longswordAttackUpImages = new GreenfootImage[6];
        longswordAttackDownImages = new GreenfootImage[6];
        longswordAttackRightImages = new GreenfootImage[6];
        longswordAttackLeftImages = new GreenfootImage[6];
        //spear attack
        spearAttackUpImages = new GreenfootImage[8];
        spearAttackDownImages = new GreenfootImage[8];
        spearAttackRightImages = new GreenfootImage[8];
        spearAttackLeftImages = new GreenfootImage[8];
        //bow attack
        bowAttackUpImages = new GreenfootImage[13];
        bowAttackDownImages = new GreenfootImage[13];
        bowAttackRightImages = new GreenfootImage[13];
        bowAttackLeftImages = new GreenfootImage[13];

        //walk
        for(int i = 0; i < downImages.length; i++)//main charater walking down animation 
        {
            downImages[i] = new GreenfootImage("images/PlayerAnimations/walk/down/down" + i + ".png");
            downImages[i].scale(size, size);
        }
        for(int i = 0; i < upImages.length; i++)//main charater walking up animation 
        {
            upImages[i] = new GreenfootImage("images/PlayerAnimations/walk/up/up" + i + ".png");
            upImages[i].scale(size, size);
        }
        for(int i = 0; i < rightImages.length; i++)//main charater walking left and right animation 
        {
            rightImages[i] = new GreenfootImage("images/PlayerAnimations/walk/right/right" + i + ".png");
            rightImages[i].scale(size, size);

            leftImages[i] = new GreenfootImage("images/PlayerAnimations/walk/right/right" + i + ".png");
            leftImages[i].mirrorHorizontally();
            leftImages[i].scale(size, size);
        }

        //longsword attack
        for(int i = 0; i < longswordAttackDownImages.length; i++)//main charater walking down animation 
        {
            longswordAttackDownImages[i] = new GreenfootImage("images/PlayerAnimations/longswordAttack/down/down" + i + ".png");
            longswordAttackDownImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < longswordAttackUpImages.length; i++)//main charater walking up animation 
        {
            longswordAttackUpImages[i] = new GreenfootImage("images/PlayerAnimations/longswordAttack/up/up" + i + ".png");
            longswordAttackUpImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < longswordAttackRightImages.length; i++)//main charater walking left and right animation 
        {
            longswordAttackRightImages[i] = new GreenfootImage("images/PlayerAnimations/longswordAttack/right/right" + i + ".png");
            longswordAttackRightImages[i].scale(atkSize, atkSize);

            longswordAttackLeftImages[i] = new GreenfootImage("images/PlayerAnimations/longswordAttack/right/right" + i + ".png");
            longswordAttackLeftImages[i].mirrorHorizontally();
            longswordAttackLeftImages[i].scale(atkSize, atkSize);
        }
        
        //spear attack
        for(int i = 0; i < longswordAttackDownImages.length; i++)//main charater walking down animation 
        {
            longswordAttackDownImages[i] = new GreenfootImage("images/PlayerAnimations/spearAttack/down/down" + i + ".png");
            longswordAttackDownImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < longswordAttackUpImages.length; i++)//main charater walking up animation 
        {
            longswordAttackUpImages[i] = new GreenfootImage("images/PlayerAnimations/spearAttack/up/up" + i + ".png");
            longswordAttackUpImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < longswordAttackRightImages.length; i++)//main charater walking left and right animation 
        {
            longswordAttackRightImages[i] = new GreenfootImage("images/PlayerAnimations/spearAttack/right/right" + i + ".png");
            longswordAttackRightImages[i].scale(atkSize, atkSize);

            longswordAttackLeftImages[i] = new GreenfootImage("images/PlayerAnimations/spearAttack/right/right" + i + ".png");
            longswordAttackLeftImages[i].mirrorHorizontally();
            longswordAttackLeftImages[i].scale(atkSize, atkSize);
        }
        
        //bow attack
        for(int i = 0; i < longswordAttackDownImages.length; i++)//main charater walking down animation 
        {
            longswordAttackDownImages[i] = new GreenfootImage("images/PlayerAnimations/longswordAttack/down/down" + i + ".png");
            longswordAttackDownImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < longswordAttackUpImages.length; i++)//main charater walking up animation 
        {
            longswordAttackUpImages[i] = new GreenfootImage("images/PlayerAnimations/longswordAttack/up/up" + i + ".png");
            longswordAttackUpImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < longswordAttackRightImages.length; i++)//main charater walking left and right animation 
        {
            longswordAttackRightImages[i] = new GreenfootImage("images/PlayerAnimations/longswordAttack/right/right" + i + ".png");
            longswordAttackRightImages[i].scale(atkSize, atkSize);

            longswordAttackLeftImages[i] = new GreenfootImage("images/PlayerAnimations/longswordAttack/right/right" + i + ".png");
            longswordAttackLeftImages[i].mirrorHorizontally();
            longswordAttackLeftImages[i].scale(atkSize, atkSize);
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
    int curIndex1 = 0;
    int curIndex2 = 0;
    int curIndex3 = 0;
    //walking animation
    public void walk()//controls the animation image speed for moving up and down
    {
        if(actionTimer.millisElapsed() > 100)
        {
            if (isFacingUp){
                setImage(upImages[curIndex]);
            }else if(isFacingDown){
                setImage(downImages[curIndex]);
            }else if (isFacingRight){
                setImage(rightImages[curIndex]);
            }else if(isFacingLeft){
                setImage(leftImages[curIndex]);
            }
            
            curIndex++;
            if(curIndex == 9){
                curIndex = 0;
            }
            actionTimer.mark();
        }
    }

    //longsword attack animation
    public void longswordAttack(){
        if(actionTimer.millisElapsed() > 100){
            if (isFacingRight){
                setImage(longswordAttackRightImages[curIndex1]);
            }else if(isFacingLeft){
                setImage(longswordAttackLeftImages[curIndex1]);
            }else if (isFacingUp){
                setImage(longswordAttackUpImages[curIndex1]);
            }else if(isFacingDown){
                setImage(longswordAttackDownImages[curIndex1]);
            }
            
            curIndex1++;
            if(curIndex1 == 6){
                curIndex1 = 0;
            }
            
            actionTimer.mark();
        }
    }
    //speard attack animation
    public void spearAttack(){
        if(actionTimer.millisElapsed() > 100){
            if (isFacingRight){
                setImage(spearAttackRightImages[curIndex2]);
            }else if(isFacingLeft){
                setImage(spearAttackLeftImages[curIndex2]);
            }else if (isFacingUp){
                setImage(spearAttackUpImages[curIndex2]);
            }else if(isFacingDown){
                setImage(spearAttackDownImages[curIndex2]);
            }
            
            curIndex2++;
            if(curIndex2 == 8){
                curIndex2 = 0;
            }
            
            actionTimer.mark();
        }
    }
    //bow attack animation
    public void bowAttack(){
        if(actionTimer.millisElapsed() > 100){
            if (isFacingRight){
                setImage(bowAttackRightImages[curIndex3]);
            }else if(isFacingLeft){
                setImage(bowAttackLeftImages[curIndex3]);
            }else if (isFacingUp){
                setImage(bowAttackUpImages[curIndex3]);
            }else if(isFacingDown){
                setImage(bowAttackDownImages[curIndex3]);
            }
            
            curIndex3++;
            if(curIndex3 == 13){
                curIndex3 = 0;
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
            walk();
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
            walk();
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
            walk();
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
            walk();
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
            longswordAttack();
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