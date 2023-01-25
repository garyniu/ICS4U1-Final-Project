import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Responsible for moving subclasses in a grid fashion using a grid provided from the World
 * 
 * @author Gary Niu 
 * @version January 12
 */
public class GridMovement extends Others
{

    protected int x = 0, y = 0; //IMPLEMENT GRID SPOTS
    protected int xc = 0, yc = 0;
    protected int gridSX, gridSY, gridXorigin, gridYorigin;
    private int VertShift = 0, horzShift = 0; //change to be a function of zoom (if adding)

    protected int timeBWMoves = 100, lastTime = 0, ylastTime = 0;
    private int timer = 0, yTimer = 0;

    private int[][] valuearray;
    private Wall[][] blockArr;

    //if moving, set previous spot to 1 and new spot to 9
    //get coordinate of grid to move to
    //stay still or move in a circle until the user is close on grid
    //if user is 1 grid spot away, dont move anymore
    /**
     * Constructor
     * @param xm X coordinate for Movement 
     * @param ym Y coordinate for Movement
     */
    public GridMovement(int xm, int ym){

        //fill in sizeOfGrid, and protected vars to start movement

        this.xc = xm;
        this.yc = ym;

        yTimer = timeBWMoves / 2;

    }
    public void addedToWorld(World world){
        valuearray = ((IceWorld)getWorld()).getMapArr();

        //gets coordinates of inital x positoins, and moves there

        
    }
    /**
     * Act Method 
     */
    public void act()
    {
        // Add your action code here.

        if (timer == 0){
            x = ((IceWorld)getWorld()).getBlockCoord(xc, yc).getX();    
            y = ((IceWorld)getWorld()).getBlockCoord(xc, yc).getY();

            //System.out.println("inital x-coord: " + x);

            ArrayList<Wall> w = (ArrayList<Wall>)getWorld().getObjects(Wall.class);
            Wall wa = w.get(0);

            gridSX = wa.getImage().getWidth()/2;
            gridSY = wa.getImage().getHeight()/2;

        }
        valuearray = ((IceWorld)getWorld()).getMapArr();

        
        
        timer++;
        yTimer = timer;

        ////System.out.println("cuurent x: " + x);

        ////System.out.println("character movemnt: " + x + " " + y);

        ////System.out.println("grid pos: " + ((IceWorld)getWorld()).getBlockCoord(xc, yc).getX() + " " + ((IceWorld)getWorld()).getBlockCoord(xc, yc).getY());

        ////System.out.println(((IceWorld)getWorld()).getBlockCoord(4, 5).getX());
    }
    /**
     * Method for moving left in the grid
     */
    public void moveLeft(){

        int gridShiftx, gridShifty;

        if ((lastTime + timeBWMoves) < timer){

            //System.out.println("move left");
            if (xc - 1 > 0){
                if (valuearray[yc][xc - 1] == 1){
                    xc -= 1;
                    ((IceWorld)getWorld()).setGridPosition(yc, xc, 9);
                    ((IceWorld)getWorld()).setGridPosition(yc, xc+1, 1);
                    x -= gridSX;
                    y -= gridSY;

                    lastTime = timer;
                }
            }


        }
    }
    /**
     * Method for moving right in the grid 
     */
    public void moveRight(){
        int gridShiftx, gridShifty;


        if ((lastTime + timeBWMoves) < timer){

            //System.out.println("move right");
            //System.out.println("Next coordspot: " + valuearray[xc + 1][yc]);
            //System.out.println("current cord: " + ((IceWorld)getWorld()).getBlockCoord(xc, yc).getX() + " " + ((IceWorld)getWorld()).getBlockCoord(xc, yc).getX());

            if (xc + 1 < valuearray.length){
                if (valuearray[yc][xc + 1] == 1){
                    xc += 1;
                    ((IceWorld)getWorld()).setGridPosition(yc, xc, 9);
                    ((IceWorld)getWorld()).setGridPosition(yc, xc-1, 1);

                    x += gridSX;
                    y += gridSY;

                    lastTime = timer;
                }
            }


        }

    }
    /**
     * Method for moving Up in the grid 
     */
    public void moveUp(){
        int gridShiftx, gridShifty;

        if ((lastTime + timeBWMoves) < timer){

            //if (leftClear){
            ////System.out.println("move up");   
            if (valuearray[yc-1][xc] == 1){
                yc -= 1;
                ((IceWorld)getWorld()).setGridPosition(yc, xc, 9);
                ((IceWorld)getWorld()).setGridPosition(yc+1, xc, 1);

                x += gridSX;
                y -= gridSY;

                lastTime = timer;
            }

            //move left
            // current x position - sizeOfGrid

            //}

        }
    }
    /**
     * Method for moving down in the grid 
     */
    public void moveDown(){
        int gridShiftx, gridShifty;

        if ((lastTime + timeBWMoves) < timer){
            ////System.out.println("test");
            //if (leftClear){
            //System.out.println("move down");          
            if (valuearray[yc+1][xc] == 1){
                yc += 1;
                ((IceWorld)getWorld()).setGridPosition(yc, xc, 9);
                ((IceWorld)getWorld()).setGridPosition(yc-1, xc, 1);

                x -= gridSX;
                y += gridSY;
                lastTime = timer;
            }

            //move left
            // current x position - sizeOfGrid

            //}

        }
    }
    /**
     * Get coordinates
     * @return Pair Pair of Coordinates
     */
    public Pair getCoords() {
        return new Pair(x, y);
    }

}
