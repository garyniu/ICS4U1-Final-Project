import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GridMovement extends Others
{
    
    protected int x = 0, y = 0;
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
    
    public GridMovement(Pair gridSize){
        
        //fill in sizeOfGrid, and protected vars to start movement
        
        gridSX = gridSize.getX();
        gridSY = gridSize.getY();
        
        
        //gridXorigin = mapOrigin.getX();
        //gridYorigin = mapOrigin.getY();
        
        //System.out.println(gridSX + " " + gridSY + " " + gridXorigin + " " + gridYorigin);
        
        yTimer = timeBWMoves / 2;
        
        
    }
    
    protected void addedToWorld(World world){
        valuearray = ((IceWorld)getWorld()).getMapArr();
        blockArr = ((IceWorld)getWorld()).getBlockArr();
        
        for (int[] arr : valuearray){
            for(int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        

        //System.out.print(blockArr[1][1].getImage().getWidth() + " " + blockArr[1][1].getImage().getHeight() + " ");
        
        for (int i = 0; i < valuearray.length; i++){
            for (int j = 0; j < valuearray[i].length; j++){
                if (valuearray[i][j] == 1){
                    System.out.print(blockArr[i][j].getImage().getWidth() + " " + blockArr[i][j].getImage().getHeight() + " ");
                }
                
            }
            System.out.println();
        }
        
    
    }
    
    public void act()
    {
        // Add your action code here.
        timer++;
        yTimer = timer;
        
        //System.out.println("character movemnt: " + x + " " + y);
        
        
        
        
    }
    
    //timer to prevent moving for too long
    //CHANGE ALL TO CHECK FOR COLLISION IN 2D ARR, AND 
    //MOVE TO GRID POSITIONS
    public void moveLeft(){
        
        int gridShiftx, gridShifty;
        
        if ((lastTime + timeBWMoves) < timer){
            
            //if (leftClear){
            
                x-=70;
                lastTime = timer;
                
                //move left
                // current x position - sizeOfGrid
                
            //}
            
        }
    }
    
    public void moveRight(){
        int gridShiftx, gridShifty;
        
        
        if ((lastTime + timeBWMoves) < timer){
            
            
            
            //if (leftClear){
            
                x+=70;
                
                lastTime = timer;
                
                //move left
                // current x position - sizeOfGrid
                
            //}
            
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
