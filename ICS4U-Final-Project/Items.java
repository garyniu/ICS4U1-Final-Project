import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for items 
 * 
 * @author Victor Wei
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
        
        //setLocation(200, 400);
        touched = getOneIntersectingObject(Player.class);
        if(getThePlayer(touched) != null)
        {
            getWorld().showText("detects player", 300, 300);
            chestCollected = true;
            upgrade();
        }
    }
    /**
     * Checks if an upgrade has been given to the player yet
     * @param player Player 
     * @return boolean If an upgrade has been given or not 
     */
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
        /*
        int randSpeedAdd = Greenfoot.getRandomNumber(5);
        double speedAdd = randSpeedAdd * 1.0;
        speedAdd /= 10;
        */
        return 3.0;
    }
    
    public void givenStamina(int add)
    {
        Player.gainStamina(100);
    }
    
    public void upgrade()
    {
        if(chestCollected != false)
        {
            if(randomUpgradeChoice == 0)
            {
                Player.giveSwordDamage(givenDamage());
                getWorld().showText("the player has gained damage", 300, 300);
                chestCollected = true;
            }
            if(randomUpgradeChoice == 1)
            {
                FreeMovement.increaseSpeed(0.5);
                getWorld().showText("the player has gained speed", 300, 300);
                chestCollected = true;
            }
            if(randomUpgradeChoice == 2)
            {
                givenStamina(100);
                getWorld().showText("the player has gained stamina", 300, 300);
                chestCollected = true;
            }
        } else {
            getWorld().showText("the player has already collected this item", 300, 300);
        }
        
    }
    
    public Actor getThePlayer(Actor player)
    {
        return getOneIntersectingObject(Player.class);
    }
}
