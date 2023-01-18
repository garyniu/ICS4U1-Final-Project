import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GridMovement extends Others
{
    
    protected int x = 0, y = 0;
    protected int gridSX, gridSY, gridXorigin, gridYorigin;
    private int VertShift = 0, horzShift = 0; //change to be a function of zoom (if adding)
    
    private int timeBWMoves = 100, lastTime = 0;
    private int timer = 0;
    
    public GridMovement(Pair gridSize, Pair mapOrigin){
        
        //fill in sizeOfGrid, and protected vars to start movement
        
        gridSX = gridSize.getX();
        gridSY = gridSize.getY();
        
        
        gridXorigin = mapOrigin.getX();
        gridYorigin = mapOrigin.getY();
        
        System.out.println(gridSX + " " + gridSY + " " + gridXorigin + " " + gridYorigin);
        
        
    }
    
    public void act()
    {
        // Add your action code here.
        timer++;
        
        
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
        
        x++;
    }
    
    public void moveUp(){
        
        y--;
    }
    
    public void moveDown(){
        
        y++;
    }
    
    public Pair getCoords() {
        return new Pair(x, y);
    }
    
}
