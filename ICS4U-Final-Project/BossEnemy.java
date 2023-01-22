import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class BossEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossEnemy extends GridMovement
{
    
    //TODO 
    //logic for attacking player
    //movemnt / pathfinding

    private GreenfootImage CharImg;
    private Player p;
    private int playerRange = 45; //change

    
    public BossEnemy(int x, int y, Pair gridSize, Pair mapOrigin){
        
        super(gridSize, mapOrigin);
        
        //change x,y to xy coord on grid
        this.x = x;
        this.y = y;
        
        CharImg = new GreenfootImage("AzhdahaScream.png");
        setImage(CharImg);
    }
    
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
