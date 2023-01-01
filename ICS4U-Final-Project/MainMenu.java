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
    Label titleLabel = new Label("TITILED GAME", 90);
    PlayButton pb = new PlayButton();//play button
    
    
    
    public MainMenu()
    {    
        // Create a new world with 600x533 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground(new GreenfootImage("images/MainMenu.jpg"));
        addObject(titleLabel, 300, 200);
        addObject(pb, 210, 300);
        
    }
    
    public void act()
    {
        
        if (Greenfoot.mouseClicked(pb))// go to myWorld when playbutton is pressed
        {
            MyWorld GameWorld = new MyWorld();
            Greenfoot.setWorld(GameWorld);
        }
    }
}
