import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * portal class used to teleport moving actors.
 * 
 * @author Leo Xu
 * @version 1
 */

public class Portal extends Others
{
    private Portal portal; // allows multiple portal in one world
    private boolean active; //used if this portal can be used
    private GreenfootImage portalImage = new GreenfootImage ("images/misc/hWall.png");
    
    public Portal()
    {
        portalImage.scale(50, 50);
        setImage(portalImage);
    }
    
    public void addedToWorld(World GameWorld){
        //System.out.println("wall pos: " + getX() + " " + getY());
        
        xg = getX();
        yg = getY();
    }
    
    public Portal(Portal portal)
    {
        this.setPortal(portal); 
        portal.setPortal(this); 
        portalImage.scale(50, 50);
        setImage(portalImage);
    }
    
    private void setPortal(Portal portal)
    {
        this.portal = portal; 
    }
    
    public Portal getPortal()
    {
        return this.portal; 
    }
    
    public void act()
    
    {
        
        Actor actor = getOneIntersectingObject(Player.class); //let portal know its tocuhing MainCharater
        if (!this.active && actor == null) this.active = true; //re-activates the portal;
        if (this.active && actor != null) portal.getActor(actor); //teleport MainCharater
        
        
    }
       
    public void getActor(Actor actor)
    {
        
        if (this.getWorld().equals(actor.getWorld()))
        {
            actor.setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2); 
         }
        else
        {
            this.getWorld().addObject(actor, getWorld().getWidth()/2, getWorld().getHeight()/2); 
            Greenfoot.setWorld(this.getWorld()); 
        }
        active = false; // de-activate portal and re-activates when MainCharacter leaves portal
    }
}
