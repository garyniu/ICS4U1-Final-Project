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
    
    //gifs for a bunch of attacks
    GifImage brownBowUp = new GifImage("images/PlayerAnimations/bomAttack/brown/brownBowUp.gif");
    GifImage brownBowDown = new GifImage("images/PlayerAnimations/bomAttack/brown/brownBowDown.gif");
    GifImage brownBowRight = new GifImage("images/PlayerAnimations/bomAttack/brown/brownBowRight.gif");
    GifImage brownBowLeft = new GifImage("images/PlayerAnimations/bomAttack/brown/brownBowRight.gif");
    //GifImage bowRight = new GifImage("images/PlayerAnimations/bowAttack/right.gif");

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
    private int playerSpeed = 1;
    private int sprintSpeed = 2;
    private boolean sprinting = false;
    //player damage variables(for enemy)
    private int swordDamage = 10;
    private int spearDamage = 7;
    private int bowDamage = 5;//possibly not needed

    //animation image speed
    private SimpleTimer actionTimer;
    private int delay = 0;
    private int dashTime;

    //Player health points
    private static int hp = 100;
    private static int stamina = 500;
    private static boolean alive = true;//true=alive, false=dead

    //Player coordinates
    private Pair coords = new Pair(0, 0);

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

    public void addedToWorld(World world){
        getWorld().addObject(new Fog(), getWorld().getWidth()/2, getWorld().getHeight()/2);
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

                actionTimer.mark();
            }
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

    //damage for player
    public void damagePlayer(int dmg){//lose hp
        hp -= dmg;
        if(hp <= 0){
            hp = 0;
            alive = false;
        }
        GameWorld.updateHP(hp);
        IceWorld.updateHP(hp);
        SpiderWorld.updateHP(hp);
    }

    public void healPlayer(int heal){//gain hp
        hp += heal;
        if(hp > 100){
            hp = 100;
        }
        GameWorld.updateHP(hp);
        IceWorld.updateHP(hp);
        SpiderWorld.updateHP(hp);
    }

    //stamina change for player
    public void loseStamina(int lost){
        stamina -= lost;
        if(stamina <= 0){
            stamina = 0;
            FreeMovement.setPlayerSpeed(playerSpeed);
            sprinting = false;
        }
        GameWorld.updateStamina(stamina);
        IceWorld.updateStamina(stamina);
        SpiderWorld.updateStamina(stamina);
    }

    public void gainStamina(int gain){
        stamina += gain;
        if(stamina > 500){
            stamina = 500;
        }
        GameWorld.updateStamina(stamina);
        IceWorld.updateStamina(stamina);
        SpiderWorld.updateStamina(stamina);
    }

    public void act()
    {
        super.act();
        x = getX();
        y = getY();
        String dashed = Greenfoot.getKey();

        System.out.println("hp: " + hp);

        if (alive == false){
            Greenfoot.setWorld(new LossScreen());
        }

        //movement
        //a and d goes first so the horizontal walking animation always plays
        //when moving diagonally(looks better since there is no horizontal animation)
        if(Greenfoot.isKeyDown("a")){//detect left
            moveLeft();
            IceWorld.stopAttacking();
            isFacingUp = false;
            isFacingDown = false;
            isFacingLeft = true;
            isFacingRight = false;
            //plays attack animation when pressing e
            if(Greenfoot.isKeyDown("q")){//sword swing
                swordAttack();
                IceWorld.attacking();
                IceWorld.weapon(1);
            }
            if(Greenfoot.isKeyDown("e")){//spear thrust
                spearAttack();
                IceWorld.attacking();
                IceWorld.weapon(2);
            }
            if(Greenfoot.isKeyDown("r")){//bow shot
                bowAttack();
                IceWorld.attacking();
                IceWorld.weapon(3);
            }
            walk();
        }
        if(Greenfoot.isKeyDown("d")){//detect right
            moveRight();
            IceWorld.stopAttacking();
            isFacingUp = false;
            isFacingDown = false;
            isFacingLeft = false;
            isFacingRight = true;
            //plays attack animation when pressing e
            if(Greenfoot.isKeyDown("q")){//sword swing
                swordAttack();
                IceWorld.attacking();
                IceWorld.weapon(1);
            }
            if(Greenfoot.isKeyDown("e")){//spear thrust
                spearAttack();
                IceWorld.attacking();
                IceWorld.weapon(2);
            }
            if(Greenfoot.isKeyDown("r")){//bow shot
                bowAttack();
                IceWorld.attacking();
                IceWorld.weapon(3);
            }
            walk();
        }
        if(Greenfoot.isKeyDown("w")){//detect up
            moveUp();
            IceWorld.stopAttacking();
            isFacingUp = true;
            isFacingDown = false;
            isFacingLeft = false;
            isFacingRight = false;
            //plays attack animation when pressing e
            if(Greenfoot.isKeyDown("q")){//sword swing
                swordAttack();
                IceWorld.attacking();
                IceWorld.weapon(1);
            }
            if(Greenfoot.isKeyDown("e")){//spear thrust
                spearAttack();
                IceWorld.attacking();
                IceWorld.weapon(2);
            }
            if(Greenfoot.isKeyDown("r")){//bow shot
                bowAttack();
                IceWorld.attacking();
                IceWorld.weapon(3);
            }
            walk();
        }
        if(Greenfoot.isKeyDown("s")){//detect down
            moveDown();
            IceWorld.stopAttacking();
            isFacingUp = false;
            isFacingDown = true;
            isFacingLeft = false;
            isFacingRight = false;
            //plays attack animation when pressing e
            if(Greenfoot.isKeyDown("q")){//sword swing
                swordAttack();
                IceWorld.attacking();
                IceWorld.weapon(1);
            }
            if(Greenfoot.isKeyDown("e")){//spear thrust
                spearAttack();
                IceWorld.attacking();
                IceWorld.weapon(2);
            }
            if(Greenfoot.isKeyDown("r")){//bow shot
                bowAttack();
                IceWorld.attacking();
                IceWorld.weapon(3);
            }
            walk();
        }
        //attack
        if(Greenfoot.isKeyDown("q")){//sword swing
            swordAttack();
            IceWorld.attacking();
            IceWorld.weapon(1);
        }
        if(Greenfoot.isKeyDown("e")){//spear thrust
            spearAttack();
            IceWorld.attacking();
            IceWorld.weapon(2);
        }
        if(Greenfoot.isKeyDown("r")){//bow shot
            bowAttack();
            IceWorld.attacking();
            IceWorld.weapon(3);
        }
        //temp dmg and heal
        if(Greenfoot.isKeyDown("1")){
            damagePlayer(1);
        }
        if(Greenfoot.isKeyDown("2")){
            healPlayer(1);
        }
        //sprint
        if(Greenfoot.isKeyDown("Shift")){
            FreeMovement.setPlayerSpeed(sprintSpeed);//sprinting speed
            loseStamina(1);
            sprinting = true;
        }else{
            FreeMovement.setPlayerSpeed(playerSpeed);//walking speed
            gainStamina(1);
            sprinting = false;
        }
    }
}