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
    
    private int timer = 0;
    
    public Enemy(int x, int y){
        super(x, y);
        CharImg = new GreenfootImage("baby1.png");
        setImage(CharImg);
    }
    
    public void act()
    {
        timer++;
        
        if (timer % 60 == 0){
            this.moveDown();
        }
    }
}
