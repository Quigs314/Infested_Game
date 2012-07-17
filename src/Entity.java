
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Entity {
    
    ArrayList<ImageIcon> forwardImages;
    ArrayList<ImageIcon> backwardsImages;
    
    public int cycle;
    
    int x, y, width, height;
    
    public Entity()
    {
        forwardImages = new ArrayList<>();
        backwardsImages = new ArrayList<>();
    }
    
    public boolean isTouching(Entity e)
    {
        return (this.x <= e.x + e.width && this.x + this.width >= e.x &&
                this.y <= e.y + e.height && this.y + this.height >= e.y);
    }
}
