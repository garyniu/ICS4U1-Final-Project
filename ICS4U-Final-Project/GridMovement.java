import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GridMovement extends Others
{

    protected int x = 0, y = 0; //IMPLEMENT GRID SPOTS
    protected int xc = 0, yc = 0;
    protected int gridSX, gridSY, gridXorigin, gridYorigin;
    private int VertShift = 0, horzShift = 0; //change to be a function of zoom (if adding)

    private int timeBWMoves = 100, lastTime = 0, ylastTime = 0;
    private int timer = 0, yTimer = 0;

    private int[][] valuearray;
    private Wall[][] blockArr;

    //if moving, set previous spot to 1 and new spot to 9
    //get coordinate of grid to move to
    //stay still or move in a circle until the user is close on grid
    //if user is 1 grid spot away, dont move anymore

    public GridMovement(){

        //fill in sizeOfGrid, and protected vars to start movement

        yTimer = timeBWMoves / 2;
        
        
    }
    
    public void addedToWorld(World world){
        valuearray = ((IceWorld)getWorld()).getMapArr();
        
        //gets coordinates of inital x positoins, and moves there
        x = ((IceWorld)getWorld()).getBlockCoord(xc, yc).getX();
        
    }

    public void act()
    {
        // Add your action code here.
        valuearray = ((IceWorld)getWorld()).getMapArr();
        
        timer++;
        yTimer = timer;
        
        System.out.println("cuurent x: " + x);

        //System.out.println("character movemnt: " + x + " " + y);

        //System.out.println(((IceWorld)getWorld()).getBlockCoord(4, 5).getX());
    }
    //MOVE TO GRID POSITIONS
    public void moveLeft(){

        int gridShiftx, gridShifty;

        if ((lastTime + timeBWMoves) < timer){

            if (valuearray[xc - 1][yc] == 1){
                xc -= 1;
                ((IceWorld)getWorld()).setGridPosition(xc, yc, 9);
                ((IceWorld)getWorld()).setGridPosition(xc+1, yc, 1);
                x = ((IceWorld)getWorld()).getBlockCoord(xc, yc).getX();
                lastTime = timer;
            }


        }
    }

    public void moveRight(){
        int gridShiftx, gridShifty;

        if ((lastTime + timeBWMoves) < timer){
            
            
            if (valuearray[xc - 1][yc] == 1){
                xc -= 1;
                ((IceWorld)getWorld()).setGridPosition(xc, yc, 9);
                ((IceWorld)getWorld()).setGridPosition(xc+1, yc, 1);
                x = ((IceWorld)getWorld()).getBlockCoord(xc, yc).getX();
                lastTime = timer;
            }
            

        }
    }

    public void moveUp(){
        int gridShiftx, gridShifty;

        if ((lastTime + timeBWMoves) < timer){

            //if (leftClear){

            y-=70;
            lastTime = timer;

            //move left
            // current x position - sizeOfGrid

            //}

        }
    }

    public void moveDown(){
        int gridShiftx, gridShifty;

        
        if ((lastTime + timeBWMoves) < timer){
            //System.out.println("test");
            //if (leftClear){

            y+=70;
            lastTime = timer;

            //move left
            // current x position - sizeOfGrid

            //}

        }
    }

    public Pair getCoords() {
        return new Pair(x, y);
    }

}
