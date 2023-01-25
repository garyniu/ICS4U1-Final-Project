import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Items here.
 * 
 * @author (your name) 
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
    public Items(int x, int y)
    {
        itemImage = new GreenfootImage("pixelChest.png");
        itemImage.scale(75, 60);
        setImage(itemImage);
        
    }
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
    public boolean givenUpgrade(Actor player)
    {
        if(touched != null)
        {
            this.chestCollected = true;
            return this.chestCollected;
        }
        return false;
    }
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
