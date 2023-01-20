import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GridMovement extends Others
{
    
    protected int x = 0, y = 0;
    protected int gridSX, gridSY, gridXorigin, gridYorigin;
    private int VertShift = 0, horzShift = 0; //change to be a function of zoom (if adding)
    
    private int timeBWMoves = 100, lastTime = 0, ylastTime = 0;
    private int timer = 0, yTimer = 0;
    
    public GridMovement(Pair gridSize, Pair mapOrigin){
        
        //fill in sizeOfGrid, and protected vars to start movement
        
        gridSX = gridSize.getX();
        gridSY = gridSize.getY();
        
        
        gridXorigin = mapOrigin.getX();
        gridYorigin = mapOrigin.getY();
        
        System.out.println(gridSX + " " + gridSY + " " + gridXorigin + " " + gridYorigin);
        
        yTimer = timeBWMoves / 2;
        
    }
    
    public void act()
    {
        // Add your action code here.
        timer++;
        yTimer = timer;
        
    }
    
    //timer to prevent moving for too long
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
            System.out.println("test");
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
