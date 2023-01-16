import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GridMovement extends Others
{
    
    protected int x = 0, y = 0;
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void moveLeft(){
        x--;
        
    }
    
    public void moveRight(){
        x++;
    }
    
    public void moveUp(){
        y--;
    }
    
    public void moveDown(){
        y++;
    }
    
    public Pair getCoords() {
        return new Pair(x, y);
    }
    
}
