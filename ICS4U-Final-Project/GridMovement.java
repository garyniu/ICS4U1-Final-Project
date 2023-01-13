import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class GridMovement extends SuperSmoothMover
{
    
    //each subclass object will have a position
    //world will access that position through a Pair, and will draw it onto the grid
    //position / movement will be taken care of through the classes isntead of the world
    
    //TODO
    //Need a reliable method to keep grid positions consistent
    
    
    protected int posx, posy, prevx, prevy;
    //protected GreenfootImage CharImg;
    
    public GridMovement(int x, int y){
        posx = x;
        posy = y;
        
        prevx = x;
        prevy = y;
    }
    
    public void act()
    {
        
        //code to check if it has moved, prevents unneeded runs
        //if posx or posy is different from its previous value
        if ((posx != prevx) || (posy != prevy)){
            
            prevx = posx;
            prevy = posy;
            
            //super.setLocation(posx, posy);
        }
        
        System.out.println(posx + " " + posy);
        super.setLocation(posx, posy);
        
        //System.out.println("test");
    }
    
    //different methods for each direction or one method with input?
    public void moveLeft(){
        posx--;
        //System.out.println("test1");
    }
    
    public void moveRight(){
        posx++;
    }
    
    public void moveUp(){
        posy--;
    }
    
    public void moveDown(){
        posy++;
    }
    
    
    public Pair getCoord(){
        return new Pair(posx, posy);
    }
    
}
