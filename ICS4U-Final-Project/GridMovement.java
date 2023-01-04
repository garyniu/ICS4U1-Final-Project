import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class GridMovement extends Actor
{
    
    
    //each subclass object will have a position
    //world will access that position through a Pair, and will draw it onto the grid
    //position / movement will be taken care of through the classes isntead of the world
    
    protected int posx, posy;
    
    public void act()
    {
        // Add your action code here.
    }
    
    
    public Pair getCoord(){
        return new Pair(posx, posy);
    }
    
}
