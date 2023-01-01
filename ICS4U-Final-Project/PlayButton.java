import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a button with the word "PLAY" on it
 * when pressed, brings the user to MyWorld(simulation)
 * 
 * @author Leo Xu
 * @version 1
 */
public class PlayButton extends Actor
{
    private GreenfootImage playImage = new GreenfootImage("images/LobbyWorld1/playButtonFade.png");
    
    /**
     * PlayButton constructor
     */
    public PlayButton()
    {
        setImage(playImage);
    }
    
    
    /**
     * Act method used to go to MyWorld by mouse click
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))//if mouse is hovering
        {
            setImage(new GreenfootImage("images/LobbyWorld1/playButton.png"));
        }
        
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))//if not hovering
        {
            setImage(new GreenfootImage("images/LobbyWorld1/playButtonFade.png"));
            
        }
    }
}

