import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends GridMovement
{
    //TODO 
    //Attacks(Justin)
    //Sprites(Justin)
    //Items(Victor)
    //Movement(Gary)
    
    private int timer = 0;
    
    public Player(int x, int y){
        super(x, y);
        CharImg = new GreenfootImage("images/animate1/down2.png");
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
