
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Infested extends JFrame implements ActionListener{
    
    public boolean isUpPressed;
    public boolean isDownPressed;
    public boolean isLeftPressed;
    public boolean isRightPressed;
    public boolean isSpacebarPressed;
    
    JButton startButton;
    
    Background background;
    Layer1 lay1;
    
    public int distance;
    
    public Infested()
    {
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Infested");
        createKeyListener();
        
        startButton = new JButton("Start Game!");
        startButton.setBounds(150, 250, 300, 50);
        startButton.addActionListener(this);
        
        background = new Background();
        
        lay1 = new Layer1(this);
        
        add(startButton);
        add(lay1);
        add(background);
        
        setVisible(true);
        
        setFocusable(true);
        
        while(true)
        {
            lay1.update();
            
            //Sets loop for 50 fps
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("Thread Inturupted");
            }
        }
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
                
                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                    isSpacebarPressed = true;
                
                System.out.println("Key Pressed");
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
                
                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                    isSpacebarPressed = false;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton)
        {
            lay1.state = Layer1.State.GAME;
            startButton.setVisible(false);
            background.setBackground(Color.CYAN);
            lay1.repaint();
            startButton.invalidate();
            background.invalidate();
        }
    }
}
