import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JPanel;

public class Background extends JPanel
{
    private Player player;
    
    public Background(Player p)
    {
        setSize(6000, Infested.HEIGHT);
        setLayout(null);
        
        player = p;
    }
    
    public void update()
    {
    }
    
    public void render(Graphics g)
    {
        try
        {
            g.drawImage(Infested.getImage("backgrounds/suburbs.png"), getLocation().x, getLocation().y, this);
        }
        catch (FileNotFoundException ex)
        {
            Infested.catchException(ex);
        }

        g.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
    }
}
