import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Infested extends JFrame implements KeyListener
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    
    public static String imagePath;
    
    public State state = State.INTRO;
    
    private Image i;

    CustomButton playButton;
    CustomButton quitButton;
    
    Background background;
    
    Player player;
    
    public boolean isDDown;
    public boolean isADown;
    public boolean isSpaceDown;
    
    public Infested()
    {
        super("Infested");
        
        imagePath = "res/images/";
        
        player = new Player(this);
        background = new Background(player);
        
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(state == State.INTRO)
                {
                    if(e.getX() <= playButton.x + playButton.width && e.getX() >= playButton.x &&
                            e.getY() <= playButton.y + playButton.height && e.getY() >= playButton.y)
                    {
                        state = State.GAME;
                        add(background);

                    }
                    else if(e.getX() <= quitButton.x + quitButton.width && e.getX() >= quitButton.x &&
                            e.getY() <= quitButton.y + quitButton.height && e.getY() >= quitButton.y)
                    {
                        if(JOptionPane.showConfirmDialog(null, "Are you sure you wish to quit playing?", "Quit?"
                                , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                        {
                            JOptionPane.showMessageDialog(null, "Goodbye!");
                            System.exit(0);
                        }
                    }
                }
            }
        });
        setVisible(true);
        
        while (true)
        {
            switch(state)
            {
                case INTRO:
                    
                    break;
                case GAME:
                    if(isDDown)
                    {
                        player.setX(player.getX() + 4);
                        background.distance += 4;
                        player.isForwards = true;
                        player.isWalking = true;
                    }
                    else if(isADown)
                    {
                        player.setX(player.getX() - 4);
                        background.distance -= 4;
                        player.isForwards = false;
                        player.isWalking = true;
                    }
                    else
                        player.isWalking = false;
                    break;
            }
            
            background.update();

            try
            {
                Thread.sleep(20); //50 FPS
            }
            catch (InterruptedException ex)
            {
                catchException(ex);
            }
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
                try
                {
                    g.setColor(Color.GREEN);
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.drawImage(getImage("Logo"), 100, 50, 400, 200, this);
                    playButton = new CustomButton("Play Game", this);
                    playButton.setBounds(50, 250, 200, 100);
                    playButton.draw(g);
                    quitButton = new CustomButton("Quit Game", this);
                    quitButton.setBounds(350, 250, 200, 100);
                    quitButton.draw(g);
                }
                catch (FileNotFoundException e)
                {
                    setVisible(false);
                    catchException(e);
                }
                break;
            case GAME:
                background.render(g);
                break;
        }
    }
    
    public static Image getImage(String i) throws FileNotFoundException
    {
        String toReturn = imagePath + i + ".png";

        if(!new File(toReturn).exists())
            throw new FileNotFoundException(toReturn + " does not exist");

        return new ImageIcon(toReturn).getImage();
    }

    public static void catchException(Exception e)
    {
        StackTraceElement[] test = e.getStackTrace();
        JOptionPane.showMessageDialog(null,
                "An error has occurred and Infested needs to close. Sorry!\n\n--------DEBUG INFO--------\n"
                + e.getMessage() + "\n" + test[0].toString() + "\n" + test[1].toString()
                + "\nCurrently we do not have a business email, " +
                "but this game isn't even released to the public anyway, so it doesn't matter.",
                "Error", JOptionPane.ERROR_MESSAGE);

        System.out.println("INFESTED: ** An Exception occured. The stack trace is below. **");
        e.printStackTrace(System.err);

        System.exit(1);
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e)
    {

        switch(e.getKeyCode())
        {
            case VK_D:
                isDDown = true;
                break;
            case VK_A:
                isADown = true;
                break;
            case VK_SPACE:
                isSpaceDown = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case VK_D:
                isDDown = false;
                break;
            case VK_A:
                isADown = false;
                break;
            case VK_SPACE:
                isSpaceDown = false;
                break;
        }
    }
}
