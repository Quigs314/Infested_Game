
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Background extends JPanel{
    
    Player player;
    
    public Background(Player p)
    {
        setSize(6000, Infested.HEIGHT);
        setLayout(null);
        
        player = p;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(player.getImage(), player.x, player.y, player.width, player.height, this);
    }
}
