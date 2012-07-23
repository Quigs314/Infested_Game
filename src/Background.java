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
    
    public void render(Graphics g, Infested i)
    {
        try
        {
            g.drawImage(Infested.getImage("backgrounds/suburbs.png"), -distance, 0, this);
        }
        catch (FileNotFoundException ex)
        {
            i.setVisible(false);
            Infested.catchException(ex);
        }

        g.drawImage(player.getImage(), player.getX() - distance, player.getY(), player.getWidth(), player.getHeight(), this);
    }
}
