import java.awt.Rectangle;
import javax.swing.ImageIcon;


public abstract class Entity
{
    private int x, y, width, height;
    private ImageIcon image;
    
    public Entity(String path, int x, int y)
    {
        image = new ImageIcon(path);
        this.x = x;
        this.y = y;
        init();
    }
    
    public boolean isTouching(int x, int y, int width, int height)
    {
        return(this.x + this.width >= x && this.x < x + width 
                && this.y + this.height > y && this.y < y + height);
    }
    
    public boolean isTouching(Rectangle rect)
    {
        return(x + width >= rect.x && x < rect.x + rect.width 
                && y + height > rect.y && y < rect.y + rect.height);
    }
    
    public abstract void init();
    public abstract void update();
}
