import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Infested extends JFrame
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    
    public String imagePath;
    
    public State state = State.INTRO;
    
    private Image i;
    
    public Infested()
    {
        super("Infested");
        
        imagePath = "res/images";
        
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        while (true)
        {
            repaint();
        }
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
        switch(state)
        {
            case INTRO:
                g.drawImage(new ImageIcon(loadImage("Logo")).getImage(), 100, 20, this);
                break;
        }
    }
    
//  I should probably make this throw an exception
    public String loadImage(String i)
    {
        if(new File(imagePath + i + ".png").exists())
            System.err.println("Image does not exist");
        return (imagePath + i + ".png");
    }
}
