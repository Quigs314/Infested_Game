
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;


public class Infested extends JFrame{
    public boolean isUpPressed;
    public boolean isDownPressed;
    public boolean isLeftPressed;
    public boolean isRightPressed;
    
    Background background;
    
    public int distance;
    
    public Infested()
    {
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Infested");
        createKeyListener();
        
        background = new Background();
        
        add(background);
        
        setVisible(true);
    }

    private void createKeyListener() {
        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    isUpPressed = true;
                
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    isDownPressed = true;
                
                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                    isLeftPressed = true;
                
                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                    isRightPressed = true;
            }
            
            @Override
            public void keyReleased(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    isUpPressed = false;
                
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    isDownPressed = false;
                
                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                    isLeftPressed = false;
                
                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                    isRightPressed = false;
            }
        });
    }
}
