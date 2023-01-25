import greenfoot.World;
import greenfoot.*; 
import greenfoot.UserInfo;
import greenfoot.GreenfootImage;

/**
 * Write a description of class LossScreen here.
 * 
 * From mr cohen
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LossScreen extends World
{
    // instance variables - replace the example below with your own
    private UserInfo user;
    Button pb = new Button(new GreenfootImage("images/LobbyWorld1/playButton.png"), new GreenfootImage("images/LobbyWorld1/playButtonFade.png"));//play button

    private int score;
    /**
     * Constructor for objects of class LossScreen
     */
    public LossScreen(int score)
    {
        super(600, 500, 1, true);

        this.score = score;
        int highScore = 0;

        if (UserInfo.isStorageAvailable()) { // check if connected
            user = UserInfo.getMyInfo();
        }
        if (user != null){ // check if logged in
            highScore = user.getScore();
            if (score > highScore) {
                user.setScore(score);
                user.store();  // write back to server
            }

        } 

        
        
        addObject (new ScoreBoard(400, 300), 300, 250);

        addObject(pb, 300, 400);
    }

    public void act(){
        if (pb.getClick())// go to myWorld when playbutton is pressed
        {
            MainMenu gw = new MainMenu();
            Greenfoot.setWorld(gw);
        }
    }
}
