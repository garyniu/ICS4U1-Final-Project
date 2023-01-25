import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for items 
 * 
 * @author Gary Niu
 * @version January 18
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
    public Items(int x, int y)
    {
        itemImage = new GreenfootImage("pixelChest.png");
        itemImage.scale(75, 60);
        setImage(itemImage);
        
    }
    /**
     * Act Method 
     */
    public void act()
    {
        randomUpgradeChoice = Greenfoot.getRandomNumber(4);
        
        setLocation(100, 100);
        touched = getOneIntersectingObject(Player.class);
        if(this.givenUpgrade(touched) != false)
        {
            if(randomUpgradeChoice == 0)
            {
                Player.addDamage(givenDamage());
            }
            if(randomUpgradeChoice == 1)
            {
                //FreeMovement.increaseSpeed(givenSpeed());
            }
        }
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
            this.chestCollected = true;
            return this.chestCollected;
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
    /*
    public double givenSpeed()
    {
        int randSpeedAdd = Greenfoot.getRandomNumber(5);
        randSpeedAdd = (double)randSpeedAdd;
        randSpeedAdd /= 10;
        return randSpeedAdd;
    }
    */
}
