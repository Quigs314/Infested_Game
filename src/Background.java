import java.awt.Graphics;
import java.io.FileNotFoundException;

public class Background
{
    private int x;

    private Player player;
    
    public Background(Player p)
    {    
        player = p;
    }
    
    public void render(Graphics g, Infested i)
    {
        try
        {
            g.drawImage(Infested.getImage(DirConstants.BACKGROUNDS + "suburbs.png"), x, 0, i);
        }
        catch (FileNotFoundException e)
        {
            i.catchException(e);
        }

        g.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), i);
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getX()
    {
        return x;
    }
}
