import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * A controllable character using the buttons WASD for movement
 * SHIFT for increased speed(sprinting)
 * Q and E for attacks that deal different damage to enemies
 * 
 * KNOWN ISSUES:
 * Bow does not work as intended, therefore it is commented out
 * attacking an enemy will cause all enemies to disappear
 * 
 * CREDITS:
 * Player Sprite:
 * Authors: bluecarrot16, Benjamin K. Smith (BenCreating), Evert, Eliza Wyatt (ElizaWy), TheraHedwig, MuffinElZangano, Durrani, Johannes Sj?lund (wulax), Stephen Challener (Redshrike), Matthew Krohn (makrohn), Manuel Riecke (MrBeast), Joe White, Michael Whitlock (bigbeargames), Johannes Sj�lund (wulax), Nila122, David Conway Jr. (JaidynReiman)
 * 
 * - body/bodies/male/universal/light.png: by bluecarrot16, Benjamin K. Smith (BenCreating), Evert, Eliza Wyatt (ElizaWy), TheraHedwig, MuffinElZangano, Durrani, Johannes Sj?lund (wulax), Stephen Challener (Redshrike). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/liberated-pixel-cup-lpc-base-assets-sprites-map-tiles
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * - https://opengameart.org/content/lpc-male-jumping-animation-by-durrani
 * - https://opengameart.org/content/lpc-runcycle-and-diagonal-walkcycle
 * - https://opengameart.org/content/lpc-revised-character-basics
 * 
 * - head/heads/human_male/universal/light.png: by bluecarrot16, Benjamin K. Smith (BenCreating), Stephen Challener (Redshrike). License(s): OGA-BY 3.0, CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/liberated-pixel-cup-lpc-base-assets-sprites-map-tiles
 * - https://opengameart.org/content/lpc-character-bases
 * 
 * - eyes/male/blue.png: by Matthew Krohn (makrohn), Stephen Challener (Redshrike). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/liberated-pixel-cup-lpc-base-assets-sprites-map-tiles
 * 
 * - hair/plain/male/black.png: by Manuel Riecke (MrBeast), Joe White. License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/liberated-pixel-cup-lpc-base-assets-sprites-map-tiles
 * - https://opengameart.org/content/ponytail-and-plain-hairstyles
 * 
 * - arms/armour/plate/male/iron.png: by Michael Whitlock (bigbeargames), Matthew Krohn (makrohn), Johannes Sj�lund (wulax). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * - http://opengameart.org/content/lpc-clothing-updates
 * 
 * - bauldron/male/walnut.png: by Nila122. License(s): GPL 2.0, GPL 3.0, CC-BY-SA 3.0. 
 * - https://opengameart.org/content/more-lpc-clothes-and-hair
 * 
 * - torso/clothes/longsleeve/male/black.png: by David Conway Jr. (JaidynReiman), Johannes Sj�lund (wulax). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * - http://opengameart.org/content/lpc-clothing-updates

 * - torso/armour/leather/male/black.png: by Johannes Sj�lund (wulax). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * - http://opengameart.org/content/lpc-clothing-updates
 * 
 * - cape/solid/female/black.png: by bluecarrot16, David Conway Jr. (JaidynReiman). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-curly-hair-elven-ears-white-cape-with-blue-trim-and-more
 * - https://opengameart.org/content/lpc-roman-armor
 * - http://opengameart.org/content/lpc-clothing-updates
 * 
 * - cape/solid_behind/black.png: by Nila122, David Conway Jr. (JaidynReiman). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-curly-hair-elven-ears-white-cape-with-blue-trim-and-more
 * - https://opengameart.org/content/lpc-roman-armor
 * 
 * - legs/armour/plate/male/steel.png: by bluecarrot16, Michael Whitlock (bigbeargames), Johannes Sj�lund (wulax). License(s): CC-BY-SA 3.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-medieval-fantasy-character-sprites
 * 
 * - feet/boots/male/black.png: by bluecarrot16, Nila122. License(s): CC-BY-SA 3.0, GPL 2.0, GPL 3.0. 
 * - https://opengameart.org/content/lpc-clothes-and-hair
 * - https://opengameart.org/content/lpc-santa
 * - http://opengameart.org/content/lpc-clothing-updates
 * 
 * @author Justin Sin, Victor Wei, Gary Niu
 * @versio 1.0
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

    //gifs for a bunch of animations
    //BROWN PLAYER
    //brown bow
    GifImage brownBowUp = new GifImage("images/PlayerAnimations/bowAttack/brown/brownBowUp.gif");
    GifImage brownBowDown = new GifImage("images/PlayerAnimations/bowAttack/brown/brownBowDown.gif");
    GifImage brownBowRight = new GifImage("images/PlayerAnimations/bowAttack/brown/brownBowRight.gif");
    GifImage brownBowLeft = new GifImage("images/PlayerAnimations/bowAttack/brown/brownBowLeft.gif");
    //brown sword
    GifImage brownSwordUp = new GifImage("images/PlayerAnimations/swordAttack/brown/brownSwordUp.gif");
    GifImage brownSwordDown = new GifImage("images/PlayerAnimations/swordAttack/brown/brownSwordDown.gif");
    GifImage brownSwordRight = new GifImage("images/PlayerAnimations/swordAttack/brown/brownSwordRight.gif");
    GifImage brownSwordLeft = new GifImage("images/PlayerAnimations/swordAttack/brown/brownSwordLeft.gif");
    //brown spear
    GifImage brownSpearUp = new GifImage("images/PlayerAnimations/spearAttack/brown/brownSpearUp.gif");
    GifImage brownSpearDown = new GifImage("images/PlayerAnimations/spearAttack/brown/brownSpearDown.gif");
    GifImage brownSpearRight = new GifImage("images/PlayerAnimations/spearAttack/brown/brownSpearRight.gif");
    GifImage brownSpearLeft = new GifImage("images/PlayerAnimations/spearAttack/brown/brownSpearLeft.gif");
    //brown walk
    GifImage brownWalkUp = new GifImage("images/PlayerAnimations/walk/brown/brownWalkUp.gif");
    GifImage brownWalkDown = new GifImage("images/PlayerAnimations/walk/brown/brownWalkDown.gif");
    GifImage brownWalkRight = new GifImage("images/PlayerAnimations/walk/brown/brownWalkRight.gif");
    GifImage brownWalkLeft = new GifImage("images/PlayerAnimations/walk/brown/brownWalkLeft.gif");

    //GOLD PLAYER
    //gold bow
    GifImage goldBowUp = new GifImage("images/PlayerAnimations/bowAttack/gold/goldBowUp.gif");
    GifImage goldBowDown = new GifImage("images/PlayerAnimations/bowAttack/gold/goldBowDown.gif");
    GifImage goldBowRight = new GifImage("images/PlayerAnimations/bowAttack/gold/goldBowRight.gif");
    GifImage goldBowLeft = new GifImage("images/PlayerAnimations/bowAttack/gold/goldBowLeft.gif");
    //gold sword
    GifImage goldSwordUp = new GifImage("images/PlayerAnimations/swordAttack/gold/goldSwordUp.gif");
    GifImage goldSwordDown = new GifImage("images/PlayerAnimations/swordAttack/gold/goldSwordDown.gif");
    GifImage goldSwordRight = new GifImage("images/PlayerAnimations/swordAttack/gold/goldSwordRight.gif");
    GifImage goldSwordLeft = new GifImage("images/PlayerAnimations/swordAttack/gold/goldSwordLeft.gif");
    //gold spear
    GifImage goldSpearUp = new GifImage("images/PlayerAnimations/spearAttack/gold/goldSpearUp.gif");
    GifImage goldSpearDown = new GifImage("images/PlayerAnimations/spearAttack/gold/goldSpearDown.gif");
    GifImage goldSpearRight = new GifImage("images/PlayerAnimations/spearAttack/gold/goldSpearRight.gif");
    GifImage goldSpearLeft = new GifImage("images/PlayerAnimations/spearAttack/gold/goldSpearLeft.gif");
    //gold walk
    GifImage goldWalkUp = new GifImage("images/PlayerAnimations/walk/gold/goldWalkUp.gif");
    GifImage goldWalkDown = new GifImage("images/PlayerAnimations/walk/gold/goldWalkDown.gif");
    GifImage goldWalkRight = new GifImage("images/PlayerAnimations/walk/gold/goldWalkRight.gif");
    GifImage goldWalkLeft = new GifImage("images/PlayerAnimations/walk/gold/goldWalkLeft.gif");

    //SILVER PLAYER
    //silver bow
    GifImage silverBowUp = new GifImage("images/PlayerAnimations/bowAttack/silver/silverBowUp.gif");
    GifImage silverBowDown = new GifImage("images/PlayerAnimations/bowAttack/silver/silverBowDown.gif");
    GifImage silverBowRight = new GifImage("images/PlayerAnimations/bowAttack/silver/silverBowRight.gif");
    GifImage silverBowLeft = new GifImage("images/PlayerAnimations/bowAttack/silver/silverBowLeft.gif");
    //silver sword
    GifImage silverSwordUp = new GifImage("images/PlayerAnimations/swordAttack/silver/silverSwordUp.gif");
    GifImage silverSwordDown = new GifImage("images/PlayerAnimations/swordAttack/silver/silverSwordDown.gif");
    GifImage silverSwordRight = new GifImage("images/PlayerAnimations/swordAttack/silver/silverSwordRight.gif");
    GifImage silverSwordLeft = new GifImage("images/PlayerAnimations/swordAttack/silver/silverSwordLeft.gif");
    //silver spear
    GifImage silverSpearUp = new GifImage("images/PlayerAnimations/spearAttack/silver/silverSpearUp.gif");
    GifImage silverSpearDown = new GifImage("images/PlayerAnimations/spearAttack/silver/silverSpearDown.gif");
    GifImage silverSpearRight = new GifImage("images/PlayerAnimations/spearAttack/silver/silverSpearRight.gif");
    GifImage silverSpearLeft = new GifImage("images/PlayerAnimations/spearAttack/silver/silverSpearLeft.gif");
    //silver walk
    GifImage silverWalkUp = new GifImage("images/PlayerAnimations/walk/silver/silverWalkUp.gif");
    GifImage silverWalkDown = new GifImage("images/PlayerAnimations/walk/silver/silverWalkDown.gif");
    GifImage silverWalkRight = new GifImage("images/PlayerAnimations/walk/silver/silverWalkRight.gif");
    GifImage silverWalkLeft = new GifImage("images/PlayerAnimations/walk/silver/silverWalkLeft.gif");

    //vertical + horizontal booleans
    private boolean isFacingUp, isFacingDown, isFacingLeft, isFacingRight = false;
    //diagonal booleans
    private boolean isFacingLeftUp, isFacingRightUp, isFacingLeftDown, isFacingRightDown;

    //location
    private int x, y;

    //player variables
    //player sizes(original image size)
    private int size = 60;//size for walking and bow animation
    private int atkSize = 180;//size for sword and spear animation
    //player speed variables
    private int playerSpeed = 1;
    private int sprintSpeed = 2;
    private boolean sprinting = false;
    //player damage variables(for enemy)
    private static int swordDamage = 40;
    private static int addedDamage;
    private int spearDamage = 50;
    private int bowDamage = 5;

    //animation image speed
    private SimpleTimer actionTimer;
    private int delay = 0;
    private int dashTime;

    //Player health points
    private int hp = 100;
    private static int stamina = 500;
    private static boolean alive = true;//true=alive, false=dead
    private int score = 10;
    private int timer = 40, ogtimer;

    //Player coordinates
    private Pair coords = new Pair(0, 0);
    
    private EnemySphere ed;
    
    /**
     * Constructor for Player
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Player(int x, int y){
        super(x, y);

        ogtimer = timer;
        
        ed = new EnemySphere();
        
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

        swordDamage = 10;

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
        //set default image as facing right
        setImage(rightImages[0]);
        //start timer for animations
        actionTimer = new SimpleTimer();
        actionTimer.mark();
        timer--;
    }

    /**
     * Increase score for Scoreboard
     */
    public void incrementScore(){
        score++;
    }
    
    public int getScore(){
        return score;
    }

    /**
     * add Player to world
     * @param world World 
     */
    public void addedToWorld(World world){
        getWorld().addObject(new Fog(), getWorld().getWidth()/2, getWorld().getHeight()/2);
    
    }

    /**
     * Movement code - move left when called
     */
    public void moveLeft(){
        posx -= speed;
        dir = "R";
    }

    /**
     * move right when called
     */
    public void moveRight(){
        posx += speed;
        dir = "L";
    }

    /**
     * move up when called
     */
    public void moveUp(){
        //posy-=2; 

        setLocationCam(posx, posy -= speed, Spawnx, Spawny);
        dir = "D";
    }

    /**
     * move down when called
     */
    public void moveDown(){
        //posy+=2;

        setLocationCam(posx, posy += speed, Spawnx, Spawny);
        dir = "U";
    }

    int curIndex = 0;
    int curIndex1 = 0;
    int curIndex2 = 0;
    int curIndex3 = 0;
    /**
     * plays the walking animation when called
     * actionTimer controls the animation image speed for moving up and down
     */
    public void walk()
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

    /**
     * sword attack animation
     * actionTimer controls the animation image speed for moving up and down
     */
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
                weaponSwing.setVolume(75);
                weaponSwing.play();
                curIndex1 = 0;
            }

            actionTimer.mark();
        }
    }

    /**
     * spear attack animation
     * actionTimer controls the animation image speed for moving up and down
     */
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
                weaponSwing.setVolume(75);
                weaponSwing.play();
                curIndex2 = 0;
            }

            actionTimer.mark();
        }
    }

    /**
     * bow attack animation
     * actionTimer controls the animation image speed for moving up and down
     */
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

    /**
     * allows other classes to set the damage the Player's sword does
     * @param dmg New damage for Player's sword
     */
    public void setSwordDamage(int dmg){//sword dmg
        this.swordDamage = dmg;
    }

    /**
     * allows other classes to set the damage the Player's spear does
     * @param dmg New damage for Player's spear
     */
    public void setSpearDamage(int dmg){//spear dmg
        this.spearDamage = dmg;
    }

    /**
     * allows other classes to set the damage the Player's bow does
     * @param dmg New damage for Player's bow 
     */
    public void setBowDamage(int dmg){//bow dmg
        this.bowDamage = dmg;
    }

    /**
     * allows other classes to set the damage the Player takes
     * @param dmg New damage that Player takes
     */
    public void damagePlayer(int dmg){//lose hp
        hp -= dmg;
        playerGrunt.setVolume(30);
        playerGrunt.play();
        if(hp <= 0){
            hp = 0;
            playerDeath.setVolume(30);
            playerDeath.play();
            alive = false;
        }
        IceWorld.updateHP(hp);
        SpiderWorld.updateHP(hp);
    }

    /**
     * allows other classes to set the amount of health the Player regains
     * @param heal Amount of health player regains 
     */
    public void healPlayer(int heal){//gain hp
        hp += heal;
        if(hp > 100){
            hp = 100;
        }
        IceWorld.updateHP(hp);
        SpiderWorld.updateHP(hp);
        incrementScore();
    }

    /**
     * allows other classes to set the the stamina Player loses
     * @param lost Amt of stamina player loses
     */
    public void loseStamina(int lost){
        stamina -= lost;
        if(stamina <= 0){
            stamina = 0;
            FreeMovement.setPlayerSpeed(playerSpeed);
            sprinting = false;
        }

        //GameWorld.updateStamina(stamina);

        IceWorld.updateStamina(stamina);
        SpiderWorld.updateStamina(stamina);
    }

    /**
     * allows other classes to set the the stamina Player gains
     * @param gain Amt of stamina Player gains 
     */
    public void gainStamina(int gain){
        stamina += gain;
        if(stamina > 500){
            stamina = 500;
        }

        //GameWorld.updateStamina(stamina);
        //IceWorld.updateStamina(stamina);
        //SpiderWorld.updateStamina(stamina);

        IceWorld.updateStamina(stamina);
        SpiderWorld.updateStamina(stamina);

    }

    private Enemy temp;
    private ArrayList <Enemy> en;

    /**
     * allows the Playerto detect when it collides with the Enemy Class
     */
    public void hitEnemy(){

        //if (timer <= 0){
        if(!(getObjectsInRange(200, Enemy.class).isEmpty())){
            System.out.println("gesters");
            en = (ArrayList<Enemy>)getObjectsInRange(200, Enemy.class);

            for (Enemy enemy : en){
                enemy.takeDamage(swordDamage);
                System.out.println("hp: " + enemy.getHP());

            }

                
            this.incrementScore();
        }
        timer = ogtimer;
        //}

    }

    /**
     * Adds damage to sword
     * @param add Amt of damage to add
     */
    public static void addDamage(int add)
    {
        swordDamage += add;
    }

    /**
     * Act method 
     */
    public void act()
    {
        super.act();
        x = getX();
        y = getY();
        String dashed = Greenfoot.getKey();

        //System.out.println("hp: " + hp);

        String lastKey = Greenfoot.getKey();
        if (alive == false){
            Greenfoot.setWorld(new LossScreen(score));
            alive = true;
        }

        //movement
        //a and d goes first so the horizontal walking animation always plays
        //when moving diagonally(looks better since there is no horizontal animation)
        if(Greenfoot.isKeyDown("a")){//detect left
            moveLeft();
            isFacingUp = false;
            isFacingDown = false;
            isFacingLeft = true;
            isFacingRight = false;
            //plays attack animation when pressing e
            if(Greenfoot.isKeyDown("q")){//sword swing
                swordAttack();
                hitEnemy();
            }
            if(Greenfoot.isKeyDown("e")){//spear thrust
                spearAttack();
                hitEnemy();
            }
            /*if(Greenfoot.isKeyDown("r")){//bow shot
            bowAttack();
            hitEnemy(10);
            }*/
            walk();
        }
        if(Greenfoot.isKeyDown("d")){//detect right
            moveRight();
            isFacingUp = false;
            isFacingDown = false;
            isFacingLeft = false;
            isFacingRight = true;
            //plays attack animation when pressing e
            if(Greenfoot.isKeyDown("q")){//sword swing
                swordAttack();
                hitEnemy();
            }
            if(Greenfoot.isKeyDown("e")){//spear thrust
                spearAttack();
                hitEnemy();
            }
            /*if(Greenfoot.isKeyDown("r")){//bow shot
            bowAttack();
            hitEnemy(10);
            }*/
            walk();
        }
        if(Greenfoot.isKeyDown("w")){//detect up
            moveUp();
            isFacingUp = true;
            isFacingDown = false;
            isFacingLeft = false;
            isFacingRight = false;
            //plays attack animation when pressing e
            if(Greenfoot.isKeyDown("q")){//sword swing
                swordAttack();
                hitEnemy();
            }
            if(Greenfoot.isKeyDown("e")){//spear thrust
                spearAttack();
                hitEnemy();
            }
            /*if(Greenfoot.isKeyDown("r")){//bow shot
            bowAttack();
            hitEnemy(10);
            }*/
            walk();
        }
        if(Greenfoot.isKeyDown("s")){//detect down
            moveDown();
            isFacingUp = false;
            isFacingDown = true;
            isFacingLeft = false;
            isFacingRight = false;
            //plays attack animation when pressing e
            if(Greenfoot.isKeyDown("q")){//sword swing
                swordAttack();
                hitEnemy();
            }
            if(Greenfoot.isKeyDown("e")){//spear thrust
                spearAttack();
                hitEnemy();
            }
            /*if(Greenfoot.isKeyDown("r")){//bow shot
            bowAttack();
            hitEnemy(10);
            }*/
            walk();
        }
        //attack
        if(Greenfoot.isKeyDown("q")){//sword swing
            swordAttack();
            hitEnemy();
        }
        if(Greenfoot.isKeyDown("e")){//spear thrust
            spearAttack();
            hitEnemy();
        }
        /*if(Greenfoot.isKeyDown("r")){//bow shot
        bowAttack();
        hitEnemy(10);
        }*/
        //sprint(hold to sprint)
        if(Greenfoot.isKeyDown("Shift")){
            FreeMovement.setPlayerSpeed(sprintSpeed);//sprinting speed
            loseStamina(1);//loses stamina when sprinting
            sprinting = true;
        }else{
            FreeMovement.setPlayerSpeed(playerSpeed);//walking speed

            //gainStamina(1);

            gainStamina(1);//gains stamina when not sprinting

            sprinting = false;
        }
        Actor chest = getOneIntersectingObject(Items.class);

        getWorld().showText(speed + "", 200, 400);

        if(chest != null)
        {
            int oldSpeed = 0;
            getWorld().showText(oldSpeed + "", 200, 200);
            oldSpeed += speed;
            //speed = 0;
            if("f".equals(lastKey))
            {
                getWorld().showText("The chest is near the player", 300, 300);
                speed += oldSpeed;
                FreeMovement.increaseSpeed(1);
            }
        }
    }
    
    
}