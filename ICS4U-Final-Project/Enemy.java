import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Enemy 
 * 
 * CREDITS:
 * Sounds:
 * EnemyGrunt.wav: (https://www.youtube.com/watch?v=ByfzLaSYLMw) + (MINECRAFT)
 * EnemyDeath: (https://www.youtube.com/watch?v=a9yNXR5OEcc) + (MINECRAFT)
 * EnemyDmg: (https://www.youtube.com/watch?v=C-rJZxBxCIE) + (MINECRAFT)
 * 
 * @author Gary Niu
 * @version January 20
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
    private int dtimer = 40, ogdtimer;
    private int type = 0;
    
    private static boolean dead = false;
    private boolean deaded = false;

    //Sounds for Enemy
    private GreenfootSound enemyIdle = new GreenfootSound("sounds/EnemyGrunt.wav");
    private GreenfootSound enemyDeath = new GreenfootSound("sounds/EnemyDeath.wav");
    private GreenfootSound enemyDmg = new GreenfootSound("sounds/EnemyDmg.wav");

    /**
     * Constructor for Enemy 
     * @param x X
     * @param y Y
     * @param type Type of enemy 
     */
    public Enemy(int xm, int ym, int type){
        super(xm, ym);
        //change x,y to xy coord on grid
        this.type = type;

        if (type == 0){
            CharImg = new GreenfootImage("baby1.png");
        } else if (type == 1){
            CharImg = new GreenfootImage("mushroom.png");
            hp = 200;
            dtimer = 30;
        } 

        CharImg.scale(42, 45);
        setImage(CharImg);

        ogdtimer = dtimer;

    }

    /**
     * Act Method
     */
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
        if(dead){
            enemyDeath.setVolume(30);
            enemyDeath.play();
            getWorld().removeObject(this);
        }
        
    }

    public static void isDead(){
        dead = true;
    }
    
    public int getHP(){
        return hp;
    }

    /**
     * Attack Player method for enemy 
     */
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
            if(Math.floor(Math.random() * 1000) == 1){
                enemyIdle.setVolume(20);
                enemyIdle.play();
            }
        }

        //System.out.println("damage");
        if (Math.sqrt(Math.abs(Math.pow(p.getX() - this.getX(), 2)) + Math.abs(Math.pow(p.getY() - this.getY(), 2))) < 40){
            if (dtimer <= 0){
                p.damagePlayer(5);
                dtimer = ogdtimer;
            }

        }

    }

    /**
     * Take Damage method for enemies
     * @param x Damage dealt
     */
    public void takeDamage(int x){
        hp -= x;
        enemyDmg.setVolume(30);
        enemyDmg.play();
    }

}
