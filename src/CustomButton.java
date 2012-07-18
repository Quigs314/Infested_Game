
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;


public class CustomButton{
    
    int x, y, width, height;
    String label;
    Infested infested;
    ActionListener action;
    
    public CustomButton(String label, Infested i)
    {
        this.label = label;
        infested = i;
    }
    
    public CustomButton(int x, int y, int width, int height, Infested i)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        infested = i;
    }
    
    public CustomButton(Infested i)
    {
        infested = i;
    }
    
    public void setLabel(String label)
    {
        this.label = label;
    }
    
    public void setBounds(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void setSize(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    
    public void draw(Graphics g)
    {
        try {
            g.drawImage(new ImageIcon(infested.loadImage("Button1")).getImage(),x, y, width, height, null);
            g.setColor(Color.WHITE);
            g.drawString(label, x + (width / 2 - 50), y + (height / 2 + 5));
        } catch (FileNotFoundException ex) {
            infested.catchException(ex);
        }
    }
    
    public void setActionListener(ActionListener a)
    {
        action = a;
    }
}
