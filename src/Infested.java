import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Infested extends JFrame
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    
    public String imagePath;
    
    public State state = State.INTRO;
    
    private Image i;

    private Thread thread;

    public Infested()
    {
        super("Infested");
        
        imagePath = "res/images";
        
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        thread = new Thread()
        {
            @Override
            public void run()
            {
                while (true)
                {
                }
            }
        };

        thread.start();
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
                try
                {
                    g.drawImage(new ImageIcon(loadImage("Logo")).getImage(), 100, 50, 400, 200, this);
                }
                catch (FileNotFoundException e)
                {
                    catchException(e);
                }
                break;
        }
    }

    public String loadImage(String i) throws FileNotFoundException
    {
        String toReturn = imagePath + "/" + i + ".png";

        if(!new File(toReturn).exists())
            throw new FileNotFoundException(toReturn + " does not exist");

        return (toReturn);
    }

    public void catchException(Exception e)
    {
        JOptionPane.showMessageDialog(this, "An error has occured and Infested needs to close. Sorry!\n\n" +
                "--------DEBUG INFO--------\nThe Exception stack trace is in the console.", "Error", JOptionPane.ERROR_MESSAGE);

        System.out.println("INFESTED: ** An Exception occured. The stack trace is below. **");
        e.printStackTrace(System.err);

        System.exit(1);
    }
}
