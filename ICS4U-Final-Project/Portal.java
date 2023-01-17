import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * This Portal Actor allows player to travel across different worlds
 * 
 * @author Leo Xu
 * @date jan 1 2023
 * 
 */

public class Portal extends Others
{
    private Portal portal; // allows multiple portal in one world
    private boolean active; //used if this portal can be used
    private GreenfootImage portalImage = new GreenfootImage ("images/tardis.png");
    
    public Portal()
    {
        portalImage.scale(100, 100);
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
        portalImage.scale(100, 100);
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
        Actor actor = getOneIntersectingObject(TestMovementNPC.class); //let portal know its tocuhing MainCharater
        if (!this.active && actor == null) this.active = true; //re-activates the portal;
        if (this.active && actor != null) portal.getActor(actor); //teleport MainCharater
        
        
    }
       
    public void getActor(Actor actor)
    {
        if (this.getWorld().equals(actor.getWorld()))
        {
            actor.setLocation(this.getX(), this.getY()); 
         }
        else
        {
            this.getWorld().addObject(actor, this.getX(), this.getY()); 
            Greenfoot.setWorld(this.getWorld()); 
        }
        active = false; // de-activate portal and re-activates when MainCharater leaves portal
    }
}
