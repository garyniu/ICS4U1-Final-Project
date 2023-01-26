import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Parent class to allow the subclasses free and easy movement with little to no lag
 * holds all the main movement methods including up/down/left/right, spawn coordinates and wall collision
 * 
 * @author Justin Sin, Leo Xu, Victor Wei, Gary Lau
 * @versio 1.0
 */
public abstract class FreeMovement extends SuperSmoothMover
{
    
    //each subclass object will have a position
    //world will access that position through a Pair, and will draw it onto the grid
    //position / movement will be taken care of through the classes instead of the world
    
    //position/direction variables
    protected int posx, posy, prevx, prevy;
    protected int Spawnx = 0, Spawny = 0;
    protected static double speed = 2;
    protected String dir = "L";
    /**
     * Constructor 
     * @param x X value
     * @param y Y value
     */
    public FreeMovement(int x, int y){
        posx = x;
        posy = y;
        
        prevx = x;
        prevy = y;
        increaseSpeed(0.5);
    }
    /**
     * Act Method
     */
    public void act()
    {
        
        //code to check if it has moved, prevents unneeded runs
        //if posx or posy is different from its previous value
        if ((posx != prevx) || (posy != prevy)){
            
            prevx = posx;
            prevy = posy;
            
            //super.setLocation(posx, posy);
        }
        
                
        //System.out.println(posx + " " + posy);
        super.setLocationCam(posx, posy, Spawnx, Spawny);
        
        
        
        //System.out.println("test");
    }
    
    /**
     * Allows classes to change the spawn coordinates of whatever class it might be
     * @param x New x coordinate
     * @param y New y coordinate
     */
    public void changeSpawnCoords(int x, int y){
        Spawnx = x;
        Spawny = y;
    }
    
    /**
     * move left and detect for wall collision(boundary)
     */
    public void moveLeft(){
        posx -= speed;
        dir = "R";
        wallCollision();
    }
    
    /**
     * move right and detect for wall collision(boundary)
     */
    public void moveRight(){
        posx += speed;
        dir = "L";
        wallCollision();
    }
    
    /**
     * move up and detect for wall collision(boundary)
     */
    public void moveUp(){
        //posy-=2; 
        
        setLocationCam(posx, posy -= speed, Spawnx, Spawny);
        dir = "D";
        wallCollision();
    }
    
    /**
     * move down and detect for wall collision(boundary)
     */
    public void moveDown(){
        //posy+=2;
        
        setLocationCam(posx, posy += speed, Spawnx, Spawny);
        dir = "U";
        wallCollision();
    }
    
    /**
     * allows other classes to set the Player's speed
     * @param spd New Speed
     */
    public static void setPlayerSpeed(int spd){
        speed = spd;
    }
    
    /**
     * Increase Speed
     * @param increase Amount for speed to be increase by 
     */
    public static void increaseSpeed(double increase)
    {
        speed += increase;
    }
    
    /**
     * allows other classes to retrieve the previous move of the subclass
     * @return String Previous Move 
     */
    public String getPrevMove()
    {
        return dir;
    }
    
    /**
     * Wall collision code, when the subclass detects a boundary/wall, stop moving in that direction
     */
    public void wallCollision()//When MainCharater touches Boundary, it stops MainCharater from moving further
    {
        int oldX = prevx;
        int oldY = prevy;
        setLocationCam(posx, posy, Spawnx, Spawny);
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
    
    /**
     * allows other class to get coordinates of subclasses
     * @param Pair Pair of Coordinates
     */
    public Pair getCoord(){
        return new Pair(posx, posy);
    }
    
}
