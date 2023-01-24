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
    //has to hold down e to play attack animation
    //attack animation can start at random images

    //charater animation images
    private GreenfootImage[] upImages;
    private GreenfootImage[] downImages;
    private GreenfootImage[] rightImages;
    private GreenfootImage[] leftImages;
    //character attack animation images
    //sword
    private GreenfootImage[] swordAttackUpImages;
    private GreenfootImage[] swordAttackDownImages;
    private GreenfootImage[] swordAttackRightImages;
    private GreenfootImage[] swordAttackLeftImages;
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

    //vertical + horizontal booleans
    private boolean isFacingUp, isFacingDown, isFacingLeft, isFacingRight = false;
    //diagonal booleans
    private boolean isFacingLeftUp, isFacingRightUp, isFacingLeftDown, isFacingRightDown;

    //location
    private int x, y;

    //player variables
    //player sizes(orignal image size)
    private int size = 60;//size for walking and bow animation
    private int atkSize = 180;//size for sword and spear animation
    //player speed variables
    private int playerSpeed = 2;
    private int sprintSpeed = 5;
    private boolean sprinting = false;
    //player damage variables(for enemy)
    private int swordDamage = 10;
    private int spearDamage = 7;
    private int bowDamage = 5;//possibly not needed

    //animation image speed
    private SimpleTimer actionTimer;
    private int delay = 0;
    private int dashTime;

    public Player(int x, int y){
        super(x, y);
        //walk
        upImages = new GreenfootImage[9];
        downImages = new GreenfootImage[9];
        rightImages = new GreenfootImage[9];
        leftImages = new GreenfootImage[9];
        //sword attack
        swordAttackUpImages = new GreenfootImage[6];
        swordAttackDownImages = new GreenfootImage[6];
        swordAttackRightImages = new GreenfootImage[6];
        swordAttackLeftImages = new GreenfootImage[6];
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

        //sword attack
        for(int i = 0; i < swordAttackDownImages.length; i++)//main charater walking down animation 
        {
            swordAttackDownImages[i] = new GreenfootImage("images/PlayerAnimations/swordAttack/down/down" + i + ".png");
            swordAttackDownImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < swordAttackUpImages.length; i++)//main charater walking up animation 
        {
            swordAttackUpImages[i] = new GreenfootImage("images/PlayerAnimations/swordAttack/up/up" + i + ".png");
            swordAttackUpImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < swordAttackRightImages.length; i++)//main charater walking left and right animation 
        {
            swordAttackRightImages[i] = new GreenfootImage("images/PlayerAnimations/swordAttack/right/right" + i + ".png");
            swordAttackRightImages[i].scale(atkSize, atkSize);

            swordAttackLeftImages[i] = new GreenfootImage("images/PlayerAnimations/swordAttack/right/right" + i + ".png");
            swordAttackLeftImages[i].mirrorHorizontally();
            swordAttackLeftImages[i].scale(atkSize, atkSize);
        }

        //spear attack
        for(int i = 0; i < spearAttackDownImages.length; i++)//main charater walking down animation 
        {
            spearAttackDownImages[i] = new GreenfootImage("images/PlayerAnimations/spearAttack/down/down" + i + ".png");
            spearAttackDownImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < spearAttackUpImages.length; i++)//main charater walking up animation 
        {
            spearAttackUpImages[i] = new GreenfootImage("images/PlayerAnimations/spearAttack/up/up" + i + ".png");
            spearAttackUpImages[i].scale(atkSize, atkSize);
        }
        for(int i = 0; i < spearAttackRightImages.length; i++)//main charater walking left and right animation 
        {
            spearAttackRightImages[i] = new GreenfootImage("images/PlayerAnimations/spearAttack/right/right" + i + ".png");
            spearAttackRightImages[i].scale(atkSize, atkSize);

            spearAttackLeftImages[i] = new GreenfootImage("images/PlayerAnimations/spearAttack/right/right" + i + ".png");
            spearAttackLeftImages[i].mirrorHorizontally();
            spearAttackLeftImages[i].scale(atkSize, atkSize);
        }

        //bow attack
        for(int i = 0; i < bowAttackDownImages.length; i++)//main charater walking down animation 
        {
            bowAttackDownImages[i] = new GreenfootImage("images/PlayerAnimations/bowAttack/down/down" + i + ".png");
            bowAttackDownImages[i].scale(size, size);
        }
        for(int i = 0; i < bowAttackUpImages.length; i++)//main charater walking up animation 
        {
            bowAttackUpImages[i] = new GreenfootImage("images/PlayerAnimations/bowAttack/up/up" + i + ".png");
            bowAttackUpImages[i].scale(size, size);
        }
        for(int i = 0; i < bowAttackRightImages.length; i++)//main charater walking left and right animation 
        {
            bowAttackRightImages[i] = new GreenfootImage("images/PlayerAnimations/bowAttack/right/right" + i + ".png");
            bowAttackRightImages[i].scale(size, size);

            bowAttackLeftImages[i] = new GreenfootImage("images/PlayerAnimations/bowAttack/right/right" + i + ".png");
            bowAttackLeftImages[i].mirrorHorizontally();
            bowAttackLeftImages[i].scale(size, size);
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

    //sword attack animation
    public void swordAttack(){
        if(actionTimer.millisElapsed() > 100){
            if (isFacingRight){
                setImage(swordAttackRightImages[curIndex1]);
            }else if(isFacingLeft){
                setImage(swordAttackLeftImages[curIndex1]);
            }else if (isFacingUp){
                setImage(swordAttackUpImages[curIndex1]);
            }else if(isFacingDown){
                setImage(swordAttackDownImages[curIndex1]);
            }

            curIndex1++;
            if(curIndex1 == 6){
                curIndex1 = 0;
            }

            actionTimer.mark();
        }
    }
    //spear attack animation
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
    //set weapon damage
    public void setSwordDamage(int dmg){//sword dmg
        this.swordDamage = dmg;
    }

    public void setSpearDamage(int dmg){//spear dmg
        this.spearDamage = dmg;
    }

    public void setBowDamage(int dmg){//bow dmg
        this.bowDamage = dmg;
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
        if(Greenfoot.isKeyDown("q")){//sword swing
            swordAttack();
            //based on current x and y value, find grid
            //set certain distance around grid as damage
            //collision with monster = damage
        }
        if(Greenfoot.isKeyDown("e")){//spear thrust
            spearAttack();
            //based on current x and y value, find grid
            //set certain distance around grid as damage
            //collision with monster = damage
        }
        if(Greenfoot.isKeyDown("r")){//bow shot
            bowAttack();

            int dir = 0;
            if(isFacingUp){
                dir = 1;
            }else if(isFacingDown){
                dir = 2;
            }else if(isFacingLeft){
                dir = 3;
            }else if(isFacingRight){
                dir = 4;
            }

            GameWorld.spawnArrow(getX(), getY(), dir);
        }

        /*//sprint toggling with shift key (works weird)
        if(!sprinting){
        if(Greenfoot.isKeyDown("Shift")){
        FreeMovement.setPlayerSpeed(sprintSpeed);//sprinting speed
        sprinting = true;
        }
        }else if(sprinting){
        if(Greenfoot.isKeyDown("Shift")){
        FreeMovement.setPlayerSpeed(playerSpeed);//walking speed
        sprinting = false;
        }
        }*/

        if (Greenfoot.isKeyDown("Shift")){ 
            if(!sprinting){
                FreeMovement.setPlayerSpeed(sprintSpeed);//sprinting speed
                sprinting = true;
            }else{
                FreeMovement.setPlayerSpeed(playerSpeed);//walking speed
                sprinting = false;
            }
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