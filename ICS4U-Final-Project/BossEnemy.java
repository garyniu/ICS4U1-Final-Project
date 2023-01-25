import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Boss Enemy 
 * 
 * @author Gary Niu 
 * @version January 20
 */
public class BossEnemy extends GridMovement
{
    
    //TODO 
    //logic for attacking player
    //movemnt / pathfinding

    private GreenfootImage CharImg;
    private Player p;
    private int playerRange = 45; //change
    /**
     * Constructor for Boss Enemy 
     * @param x X
     * @param y Y
     * @param gridSize Grid Dimensions
     */
    
    public BossEnemy(int x, int y, Pair gridSize){
        
        super(x, y);
        
        //change x,y to xy coord on grid
        this.x = x;
        this.y = y;
        
        CharImg = new GreenfootImage("AzhdahaScream.png");
        setImage(CharImg);
    }
    /**
     * Act Method 
     */
    public void act()
    {
        super.act();

        ArrayList<Player> ps = (ArrayList)getWorld().getObjects(Player.class);
        p = ps.get(0);
        
        AttackPlayer();
        //setLocation(getX()+1, getY());
        
        moveRight();
        
        //y++;
    }
    /**
     * Attack Player method 
     */
    private void AttackPlayer(){
       
        int x = p.getX();
        int y = p.getY();
        //change to within size of a grid (put in vars)
        //rpevent it from moving diagonally
        System.out.println("x-coords: " + this.getX() + " " + x);
        System.out.println("y-coords: " + this.getY() + " " + y);
        
        if (getX() < x && (getX() + playerRange < x)){
            moveRight();
        } else if (getX() > x && (getX() - playerRange > x)){
            moveLeft();
        } else if (getY() < y && (getY() + playerRange < y)){
            moveDown();
        } else if (getY() > y && (getY() - playerRange > y)){
            moveUp();
        }
        
    }
}
