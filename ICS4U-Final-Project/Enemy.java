import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends GridMovement
{
    
    //TODO 
    //logic for attacking player
    //movemnt / pathfinding

    private GreenfootImage CharImg;

    
    public Enemy(int x, int y){
        
        this.x = x;
        this.y = y;
        
        CharImg = new GreenfootImage("baby1.png");
        setImage(CharImg);
    }
    
    public void act()
    {
        
        System.out.println("enemy loc: " + getX() + " " + getY());
        
        System.out.println("perceivec loc: " + x + " " + y);
        
        
        //setLocation(getX()+1, getY());
        moveLeft();
        //y++;
    }
}
