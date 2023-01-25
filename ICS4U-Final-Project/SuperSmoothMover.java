import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
/**
 * <p>A variation of an actor that maintains a precise location (using doubles for the co-ordinates
 * instead of ints).  This allows small precise movements (e.g. movements of 1 pixel or less)
 * that do not lose precision.</p>
 * 
 * <p>Modified by Jordan Cohen to include a precise rotation variable, as well as turn, setRotation 
 * and turnTowards methods.</p>
 * 
 * <p>To use this class, simply have all of the Actors that need to move smoothly inherit from this
 * class. This class adds new versions of move, turn and setLocation which take doubles. It also adds the
 * following methods to access the precise values:</p>
 * <ul>
 * <li><code>getPreciseX, getPreciseY -></code> Retrieves precise values</li>
 * <li><code>getPreciseRotation -></code> gets the precise angle</li>
 * <li><code>turnTowards (Actor) -></code> an added bonus - turn towards another Actor instead of an xy position</li>
 * </ul>
 * 
 * 
 * 
 * @author Poul Henriksen
 * @author Michael Kolling
 * @author Neil Brown
 * 
 * @version 3.1 -- Modefied by Gary Niu, based on Jordan Cohen's changes
 * 
 */
public abstract class SuperSmoothMover extends Actor
{
    private double exactX;
    private double exactY;
    private double rotation;
    private int xe, ye;

    /**
     * Set the internal rotation value to a new value.
     * 
     * @param rotation the precise new angle
     */
    public void setRotation (double rotation){
        this.rotation = rotation;
        super.setRotation ((int)(rotation + 0.5));
    }

    /**
     * Set the internal rotation value to a new value. This will override the method from Actor.
     * 
     * @param rotation the new angle
     */
    @Override
    public void setRotation (int rotation){
        this.rotation = rotation;
        super.setRotation(rotation);
    }

    /**
     * Set the internal rotation to face towards a given point. This will override the method from Actor.
     * 
     * @param x the x coordinate to face
     * @param y the y coordinate to face
     */
    @Override
    public void turnTowards (int x, int y){
        setRotation( Math.toDegrees(Math.atan2(y - getY() , x - getX())));
    }

    /**
     * A short-cut method that I (Jordan Cohen) always thought Greenfoot should have - use the
     * tuntToward method above to face another Actor instead of just a point. Keeps calling code
     * cleaner. 
     * 
     * @param a     The Actor to turn towards. 
     */
    public void turnTowards (Actor a){
        turnTowards (a.getX(), a.getY());
    }

    /**
     * Turn a specified number of degrees.
     * 
     * @param angle     the number of degrees to turn.
     */
    @Override
    public void turn (int angle){
        rotation += angle;
    }

    /**
     * Turn a specified number of degrees with precision.
     * 
     * @param angle     the precise number of degrees to turn
     */
    public void turn (double angle){
        rotation += angle;
    }

    /**
     * Set the location using exact coordinates.
     * 
     * @param x the new x location
     * @param y the new y location
     */
    public void setLocationCam(int x, int y, int spawnOffx, int spawnOffY)
    {
        int x2 = x;//gets where the man is trying to move
        int y2 = y;
        xe = x;
        ye = y;

        //System.out.println("x, y: " + x + " " + y);
        //System.out.println("world w + h: " + getWorld().getWidth() + " " + getWorld().getHeight());

        //System.out.println("moved: " + ( Math.floor(getWorld().getWidth()/2) - x) + " " + ( Math.floor(getWorld().getHeight()/2) - y));

        //fix this later or can be applied
        List<Others> everyone = getWorld().getObjects(Others.class);

        for (Others w : everyone){
            //w.setLocation(w.getX()+x2,w.getY()+y2);
            //System.out.println("gottenx: " + w.getX());

            //constant var in each wall object

            //System.out.println("toString: " + w.getOGCoords().toString());

            //System.out.println(w.getOGCoords().getX() + " " + w.getOGCoords().getY());

            w.setLocation(w.getOGCoords().getX() + (int)(Math.floor(getWorld().getWidth()/2) - x) + spawnOffx, w.getOGCoords().getY() + (int)(Math.floor(getWorld().getHeight()/2) - y) + spawnOffY);

            if (w.getClass() == Enemy.class){
                w.setLocation(((Enemy)w).getCoords().getX()+ (int)(Math.floor(getWorld().getWidth()/2) - x), ((Enemy)w).getCoords().getY()+ (int)(Math.floor(getWorld().getHeight()/2) - y));
            } else if (w.getClass() == BossEnemy.class){
                w.setLocation(((BossEnemy)w).getCoords().getX()+ (int)(Math.floor(getWorld().getWidth()/2) - x), ((BossEnemy)w).getCoords().getY()+ (int)(Math.floor(getWorld().getHeight()/2) - y));
            }

            //

        }

        if (getWorld() instanceof GameWorld){
            ((GameWorld)getWorld()).setThing(x2 + spawnOffx, y2+ spawnOffY);//moves the world back
        }

    }

    /**
     * Set the location using integer coordinates.
     * (Overrides the method in Actor.)    
     * 
     * @param x the new x location
     * @param y the new y location
     */
    /*@Override
    public void setLocation(int x, int y) 
    {
    exactX = x;
    exactY = y;
    super.setLocation(x, y);
    }*/

    /**
     * Return the exact x-coordinate (as a double).
     * 
     * @return double   the exact x coordinate, as a double
     */
    public double getPreciseX() 
    {
        return exactX;
    }

    /**
     * Return the exact y-coordinate (as a double).
     * 
     * @return double   the exact x coordinate, as a double
     */
    public double getPreciseY() 
    {
        return exactY;
    }

    /**
     * Gets the precise rotation amount of the actor 
     * @return double Returns rotation amount
     */
    public double getPreciseRotation (){
        return rotation;
    }

    /**
     * Gets the pair of coordinates of Actor 
     * @return Pair Coordinates
     */
    public Pair PMoved(){
        return new Pair(xe, ye);
    }

}
