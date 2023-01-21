import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class FreeMovement extends SuperSmoothMover
{
    
    //each subclass object will have a position
    //world will access that position through a Pair, and will draw it onto the grid
    //position / movement will be taken care of through the classes isntead of the world
    
    //TODO
    //Need a reliable method to keep grid positions consistent
    
    
    protected int posx, posy, prevx, prevy;
    private static int speed = 2;
    private String dir = "L";
    //protected GreenfootImage CharImg;
    
    public FreeMovement(int x, int y){
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
    
    //movement
    public void moveLeft(){
        posx -= speed;
        dir = "R";
        wallCollision();
    }
    public void moveRight(){
        posx += speed;
        dir = "L";
        wallCollision();
    }
    public void moveUp(){
        //posy-=2; 
        
        setLocation(posx, posy -= speed);
        dir = "D";
        wallCollision();
    }
    public void moveDown(){
        //posy+=2;
        
        setLocation(posx, posy += speed);
        dir = "U";
        wallCollision();
    }
    
    public static void setPlayerSpeed(int spd){
        speed = spd;
    }
    
    public String getPrevMove()
    {
        return dir;
    }
    
    
    public void wallCollision()//When MainCharater touches Boundary, it stops MainCharater from moving further
    {
        int oldX = prevx;
        int oldY = prevy;
        super.setLocation(posx, posy);
        if(!getIntersectingObjects(Boundary.class).isEmpty())
        {
            switch (dir) {
                case "L":
                    moveLeft();
                    break;
                case "R":
                    moveRight();
                    break;
                case "U":
                    moveUp();
                    break;
                case "D": 
                    moveDown();
                    break;
            }
        }
    }
    
    
    public Pair getCoord(){
        return new Pair(posx, posy);
    }
    
}
