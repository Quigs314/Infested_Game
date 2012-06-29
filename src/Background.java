
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Background extends JPanel{
    
    public enum State
    {
        //The screen with the logo and starting game options
        INTRO,
        //Options, quit game, etc.
        MENU,
        //The game-play state
        GAME;
    }
    
    State state = State.INTRO;
    
    public Background()
    {
        setBounds(0, 0, 5000, 500);
        setBackground(Color.GREEN);
        setLayout(null);
    }
    
    public void paint(Graphics g)
    {
        switch(state)
        {
            case INTRO:
                ImageIcon img  = new ImageIcon("resources/images/Logo.png");
                g.drawImage(img.getImage(), 0, 0, 600, 500, this);
                break;
        }
    }
}
