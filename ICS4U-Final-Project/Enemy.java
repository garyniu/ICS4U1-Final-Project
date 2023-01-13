import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Others
{
    
    //TODO 
    //logic for attacking player
    //movemnt / pathfinding

    private GreenfootImage CharImg;
    
    public Enemy(int x, int y){
        
        CharImg = new GreenfootImage("baby1.png");
        setImage(CharImg);
    }
    
    public void act()
    {
        //setLocation(getX()+1, getY());
    }
}
