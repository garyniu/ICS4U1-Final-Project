import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fog extends Actor
{

    
    private int x, y;
    private GreenfootImage boundImage = new GreenfootImage ("fog.png");

    
    public Fog(){
        boundImage.scale(600, 500);
        setImage(boundImage);
    }

    public void act()
    {
        System.out.println("test");
    }
}
