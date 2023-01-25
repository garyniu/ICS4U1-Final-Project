import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for items 
 * 
<<<<<<< HEAD
 * @author Victor
 * @version (a version number or a date)
=======
 * @author Victor Wei
 * @version January 18
>>>>>>> 37313bea1eee67fb8a9952ec6e646b00ff4e7f5a
 */
public class Items extends Others
{
    private GreenfootImage itemImage;
    private boolean chestCollected;
    private int timer;
    private int randomUpgradeChoice;
    private int randSpeedAdd;
    private Actor touched;

    

    /**
     * Constructor for Items 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Items()

    {
        itemImage = new GreenfootImage("pixelChest.png");
        itemImage.scale(75, 60);
        setImage(itemImage);
    }
    public void addedToWorld(World GameWorld)
    {
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    /**
     * Act Method 
     */
    public void act()
    {
        randomUpgradeChoice = Greenfoot.getRandomNumber(3);
        
        setLocation(200, 400);
        touched = getOneIntersectingObject(Player.class);
        upgrade();
    }
    /**
     * Checks if an upgrade has been given to the player yet
     * @param player Player 
     * @return boolean If an upgrade has been given or not 
     */
    public boolean givenUpgrade(Actor player)
    {
        if(touched != null)
        {
            chestCollected = true;
            return chestCollected;
        }
        return false;
    }
    /**
     * Returns damage to be dealt
     * @return int Damage to be added/dealt to player
     */
    public int givenDamage()
    {
        int randDmgAdd = Greenfoot.getRandomNumber(5);
        return randDmgAdd;
    }
    
    public double givenSpeed()
    {
        int randSpeedAdd = Greenfoot.getRandomNumber(5);
        double speedAdd = randSpeedAdd * 1.0;
        speedAdd /= 10;
        return speedAdd;
    }
    
    public void giveStamina(int add)
    {
        Player.gainStamina(100);
    }
    
    public void upgrade()
    {
        if(this.givenUpgrade(touched) != false)
        {
            if(randomUpgradeChoice == 0)
            {
                //Player.addDamage(givenDamage());
                getWorld().showText("the player has gained damage", 300, 300);
            }
            if(randomUpgradeChoice == 1)
            {
                //FreeMovement.increaseSpeed(givenSpeed());
                getWorld().showText("the player has gained speed", 300, 300);
            }
            if(randomUpgradeChoice == 2)
            {
                //giveStamina(100);
                getWorld().showText("the player has gained stamina", 300, 300);
            }
        }
    }
}
