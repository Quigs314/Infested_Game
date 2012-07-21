
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.ImageIcon;


public class Entity implements ActionListener
{
    public ArrayList<ImageIcon> forwardImages;
    public ArrayList<ImageIcon> backwardsImages;

    private Timer animTimer;

    private int animCycle;
    
    private int x, y, width, height;

    public Entity()
    {
        forwardImages = new ArrayList<>();
        backwardsImages = new ArrayList<>();
        
        animTimer = new  Timer(250, this);
        animTimer.start();
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getAnimCycle()
    {
        return animCycle;
    }

    public void setAnimCycle(int animCycle)
    {
        this.animCycle = animCycle;
    }

    public boolean isTouching(Entity e)
    {
        return (this.x <= e.x + e.width && this.x + this.width >= e.x &&
                this.y <= e.y + e.height && this.y + this.height >= e.y);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == animTimer)
        {
            if(animCycle + 1 < forwardImages.size())
                animCycle++;
            else
                animCycle = 0;
        }
    }
}
