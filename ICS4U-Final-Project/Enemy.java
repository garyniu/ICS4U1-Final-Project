import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

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

    private GreenfootImage CharImg;
    private Player p;
    private int playerRange = 45; //change

    
    public Enemy(int x, int y){
        
        super();
        
        //change x,y to xy coord on grid
        this.xc = x;
        this.yc = y;
        
        CharImg = new GreenfootImage("baby1.png");
        setImage(CharImg);
    }
    
    public void act()
    {
        super.act();

        ArrayList<Player> ps = (ArrayList)getWorld().getObjects(Player.class);
        p = ps.get(0);
        
        AttackPlayer();
        //setLocation(getX()+1, getY());
        
        //y++;
    }
    
    private void AttackPlayer(){
        int x = p.getX();
        int y = p.getY();
        //change to within size of a grid (put in vars)
        //System.out.println("x-coords: " + this.getX() + " " + x);
        //System.out.println("y-coords: " + this.getY() + " " + y);
        
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
