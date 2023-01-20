import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * This is the main menu of the game with buttons leading to play the game, and instructions/controls
 *
 * @author Leo Xu
 * @date June 15 2022
 *
 *
 */
public class MainMenu extends World
{
    Label titleLabel = new Label("Balls Gaming", 90);
    Button pb = new Button(new GreenfootImage("images/LobbyWorld1/playButton.png"), new GreenfootImage("images/LobbyWorld1/playButtonFade.png"));//play button
    
    
    
    public MainMenu()
    {    
        // Create a new world with 600x533 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground(new GreenfootImage("images/background/MainMenu.jpg"));
        addObject(titleLabel, 300, 200);
        addObject(pb, 210, 300);
        
    }
    
    public void act()
    {
        
        if (pb.getClick())// go to myWorld when playbutton is pressed
        {
            GameWorld gw = new GameWorld();
            Greenfoot.setWorld(gw);
        }
    }
}
