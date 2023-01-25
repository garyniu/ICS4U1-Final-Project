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
    private int playerRange = 25; //change
    private int attackDist = 150;
    private int hp = 100;
    private int dtimer = 40;

    public Enemy(int xm, int ym){
        super(xm, ym);
        //change x,y to xy coord on grid
        
        CharImg = new GreenfootImage("baby1.png");
        setImage(CharImg);
    }

    public void act()
    {
        super.act();
        dtimer--;
        ArrayList<Player> ps = (ArrayList)getWorld().getObjects(Player.class);
        p = ps.get(0);

        AttackPlayer();
        //setLocation(getX()+1, getY());
        
        //System.out.println("grid coords: " + xc + " " + yc);
        
        //y++;
        
        if (hp <= 1){
            getWorld().removeObject(this);
        }
    }

    private void AttackPlayer(){
        int x = p.getX();
        int y = p.getY();
        //change to within size of a grid (put in vars)
        //System.out.println("x-coords: " + this.getX() + " " + x);
        //System.out.println("y-coords: " + this.getY() + " " + y);

        //only in specific distance
        if (Math.sqrt(Math.abs(Math.pow(p.getX() - this.getX(), 2)) + Math.abs(Math.pow(p.getY() - this.getY(), 2))) < attackDist){
            
            //check if wall in frint of movement is empty
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
        
        
        System.out.println("damage");
        if (Math.sqrt(Math.abs(Math.pow(p.getX() - this.getX(), 2)) + Math.abs(Math.pow(p.getY() - this.getY(), 2))) < 40){
            if (dtimer <= 0){
                p.damagePlayer(5);
                dtimer = 40;
            }
            
        }

    }
    
    private void takeDamage(int x){
        hp -= x;
    }
    
}
