import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Items here.
 * 
 * @author Victor
 * @version (a version number or a date)
 */
public class Items extends Others
{
    private GreenfootImage itemImage;
    private boolean chestCollected;
    private int timer;
    private int randomUpgradeChoice;
    private int randSpeedAdd;
    private Actor touched;
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
    public void act()
    {
        randomUpgradeChoice = Greenfoot.getRandomNumber(3);
        
        setLocation(200, 400);
        touched = getOneIntersectingObject(Player.class);
        upgrade();
    }
    public boolean givenUpgrade(Actor player)
    {
        if(touched != null)
        {
            chestCollected = true;
            return chestCollected;
        }
        return false;
    }
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
