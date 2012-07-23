import java.awt.Graphics;
import java.io.FileNotFoundException;
import javax.swing.JPanel;

public class Background extends JPanel
{
    Player player;
    
    public int distance;
    
    public Background(Player p)
    {
        setSize(6000, Infested.HEIGHT);
        setLayout(null);
        
        player = p;
    }
    
    public void render(Graphics g)
    {
        try
        {
            g.drawImage(Infested.getImage("backgrounds/suburbs"), -distance, 0, this);
        }
        catch (FileNotFoundException ex)
        {
            Infested.catchException(ex);
        }

        g.drawImage(player.getImage(), player.getX() - distance, player.getY(), player.getWidth(), player.getHeight(), this);
    }
}
