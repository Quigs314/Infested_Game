import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class Entity implements ActionListener
{
    public ArrayList<Image> forwardImages;
    public ArrayList<Image> backwardImages;

    private Timer animTimer;

    private int animCycle;
    
    private int x, y, width, height;

    public Entity()
    {
        forwardImages = new ArrayList<>();
        backwardImages = new ArrayList<>();
        
        animTimer = new  Timer(150, this);
        animTimer.start();
    }

    public void loadAnimationFrames(Class classFromWhichThisMethodWasCalled) throws FileNotFoundException
    {
        Class c = classFromWhichThisMethodWasCalled;

        String animDir /*animation directory*/ = Infested.imagePath + Infested.toLowerCase(c.getName());
        File animFrames = new File(animDir);

        for(File frame : animFrames.listFiles())
            if(frame.getName().startsWith("Walking"))
            {
                String s = c.getName().toLowerCase() + "/" + frame.getName();

                if(frame.getName().startsWith("WalkingRight"))
                    forwardImages.add(Infested.getImage(s));
                else if(frame.getName().startsWith("WalkingLeft"))
                    backwardImages.add(Infested.getImage(s));
            }
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getX()
    {
        return x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getY()
    {
        return y;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getWidth()
    {
        return width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getHeight()
    {
        return height;
    }

    public void setAnimCycle(int animCycle)
    {
        this.animCycle = animCycle;
    }

    public int getAnimCycle()
    {
        return animCycle;
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
