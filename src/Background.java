
import java.awt.Graphics;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Background extends JPanel{
    
    Player player;
    
    public int distance;
    
    public Background(Player p)
    {
        setSize(6000, Infested.HEIGHT);
        setLayout(null);
        
        player = p;
    }
    
    public void update()
    {
        setLocation(-distance, 0);
        invalidate();
    }
    
    public void render(Graphics g)
    {
        try {
            g.drawImage(new ImageIcon(Infested.loadImage("backgrounds/suburbs")).getImage(), 0, 0, this);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        g.drawImage(player.getImage(), player.x, player.y, player.width, player.height, this);
    }
}
