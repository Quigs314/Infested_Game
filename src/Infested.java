import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

public class Infested extends JFrame
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    
    private State state;
    
    private Image i;
    
    public Infested()
    {
        super("Infested");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
        i = createImage(getWidth(), getHeight());
        render(i.getGraphics());
        repaint();
        g.drawImage(i, 0, 0, this);
    }
    
    public void render(Graphics g)
    {
    }
}
