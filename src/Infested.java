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

    private boolean isDDown, isADown, isSpaceDown, isWDown, paused;

    public static String imagePath;

    public State state = State.INTRO;

    private Image doubleBufferImage;

    private CustomButton playButton, quitButton;

    private Background background;

    private Player player;

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
                        if(player.getX() < player.getDefaultX() + Player.RANGE)
                            player.setX(player.getX() + player.speed);
                        else if(background.getX() > -(6000 - WIDTH))
                            background.setX(background.getX() - player.speed);

                        player.isForwards = true;
                        player.isWalking = true;
                    }
                    else if(isADown)
                    {
                        if(player.getX() > player.getDefaultX() - Player.RANGE)
                            player.setX(player.getX() - player.speed);
                        else if(background.getX() < 0)
                            background.setX(background.getX() + player.speed);

                        player.isForwards = false;
                        player.isWalking = true;
                    }
                    else
                        player.isWalking = false;

                    if(isWDown && !player.isJumping)
                        player.fallSpeed = -10;
                    
                    player.fall();

                    break;
            }
            

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
        doubleBufferImage = createImage(getWidth(), getHeight());
        render(doubleBufferImage.getGraphics());
        repaint();
        g.drawImage(doubleBufferImage, 0, 0, this);
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
                    int width = 400, height = 200;
                    g.drawImage(getImage("Logo.png"), WIDTH / 2 - width / 2, 50, width, height, this);
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
                background.render(g, this);
                break;

            case PAUSE:
                break;
        }
    }
    
    public static Image getImage(String fileWithExtension) throws FileNotFoundException
    {
        String toReturn = imagePath + fileWithExtension;

        if(!new File(toReturn).exists())
            throw new FileNotFoundException(toReturn + " does not exist");

        return new ImageIcon(toReturn).getImage();
    }

    //Used the make only the first letter lowercase
    public static String toLowerCase(String s)
    {
        return s.replace(s.charAt(0), Character.toLowerCase(s.charAt(0)));
    }

    public static void catchException(Exception e)
    {   
        StackTraceElement[] stackTrace = e.getStackTrace();

        JOptionPane.showMessageDialog(null,
                "An error has occurred and Infested needs to close. Sorry!\n\n--------DEBUG INFO--------\n"
                + e.getMessage() + "\n" + stackTrace[0].toString() + "\n" + stackTrace[1].toString()
                + "\nCurrently we do not have a business email, " +
                "but this game isn't even released to the public anyway, so it doesn't matter.",
                "Error", JOptionPane.ERROR_MESSAGE);

        System.out.println("INFESTED: ** An Exception occured. The stack trace is below. **");
        e.printStackTrace();

        System.exit(1);
    }

    public boolean isDDown()
    {
        return isDDown;
    }

    public void setDDown(boolean DDown)
    {
        isDDown = DDown;
    }

    public boolean isADown()
    {
        return isADown;
    }

    public void setADown(boolean ADown)
    {
        isADown = ADown;
    }

    public boolean isSpaceDown()
    {
        return isSpaceDown;
    }

    public void setSpaceDown(boolean spaceDown)
    {
        isSpaceDown = spaceDown;
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
            case VK_ESCAPE:
                paused = !paused;
                if(paused)
                    state = State.PAUSE;
                else state = State.GAME;
                break;
            case VK_W:
                isWDown = true;
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
            case VK_W:
                isWDown = false;
                break;
        }
    }
}
