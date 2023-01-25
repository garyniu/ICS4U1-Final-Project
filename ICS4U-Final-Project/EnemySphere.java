import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visual CopyOfFog Effect
 * 
 * @author Gary Niu
 * @version January 24
 */
public class EnemySphere extends Actor
{

    
    private int x, y;
    private GreenfootImage boundImage = new GreenfootImage(100, 100);
    /**
     * Constructor for EnemySphere
     */
    
    public EnemySphere(){
        boundImage.setColor(Color.RED);
        boundImage.drawOval(100, 100, 70, 70);
        boundImage.fillOval(100, 100, 70, 70);
        
        setImage(boundImage);
    }
    /**
     * Act Method
     */
    public void act()
    {
        
    }
}
