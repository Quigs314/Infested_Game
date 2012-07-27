import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;

public class CustomButton
{
    
    int x, y, width, height;
    String label;
    Infested infested;
    
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
        try
        {
            g.drawImage(Infested.getImage("Button1.png"),x, y, width, height, null);
            g.setColor(Color.WHITE);
            g.drawString(label, x + (width / 2 - 50), y + (height / 2 + 5));
        }
        catch (FileNotFoundException ex)
        {
            infested.catchException(ex);
        }
    }
}
