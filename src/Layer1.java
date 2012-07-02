
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Layer1 extends JPanel{
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
    
    Infested game;
    
    int dialougeNumber = 0;
    boolean isDialougeShowing = true;
    
    public Layer1(Infested game)
    {
        setBounds(0, 0, 5000, 500);
        setLayout(null);
        
        this.game = game;
    }
    
    public void update()
    {
        if(game.isSpacebarPressed)
        {
              isDialougeShowing = false;
              System.out.println("Clearing Dialouge");
        }
        repaint();
    }
    
    public void paint(Graphics g)
    {
        g.dispose();
        switch(state)
        {
            case INTRO:
                ImageIcon img  = new ImageIcon("resources/images/Logo.png");
                g.drawImage(img.getImage(), 50, 50, 500, 200, this);
                break;
            case GAME:
                if(isDialougeShowing)
                {
                    if(dialougeNumber == 0)
                        g.drawString("Welcome to Infested! Use the arrow keys to move. Press spacebar to clear this text.", 5, 400);
                }
                break;
        }
    }
}
