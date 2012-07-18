
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.ImageIcon;


public class Entity implements ActionListener{
    
    ArrayList<ImageIcon> forwardImages;
    ArrayList<ImageIcon> backwardsImages;
    Timer timer;
    
    public int cycle;
    
    int x, y, width, height;
    
    public Entity()
    {
        forwardImages = new ArrayList<>();
        backwardsImages = new ArrayList<>();
        
        timer = new  Timer(5, this);
        
    }
    
    public boolean isTouching(Entity e)
    {
        return (this.x <= e.x + e.width && this.x + this.width >= e.x &&
                this.y <= e.y + e.height && this.y + this.height >= e.y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timer)
        {
            if(cycle - 1 < forwardImages.size())
                cycle++;
            else
                cycle = 0;
        }
    }
}
