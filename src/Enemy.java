
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public abstract class Enemy extends Entity{
    
    ArrayList<ImageIcon> movementImages = new ArrayList();
    ArrayList<ImageIcon> attackingImages = new ArrayList();
    ArrayList<ImageIcon> hurtImages = new ArrayList();
    
    int animation;
    
    public boolean isMoving;
    public boolean isAttacking;
    public boolean isHurt;
    
    public final int MOVEMENT = 1;
    public final int ATTACK = 2;
    public final int HURT = 3;
    
    public Enemy(String path, int x, int y)
    {
        super(path, x, y);
    }
    
    public Image getImage()
    {
        if(isMoving)
            return (movementImages.get(animation)).getImage();
        else if(isAttacking)
            return (attackingImages.get(animation).getImage());
        else
            return (hurtImages.get(animation).getImage());
    }
    
    public void cycleAnimation()
    {
        int max;
        if(isMoving)
            max = movementImages.size();
        else if(isAttacking)
            max = attackingImages.size();
        else
            max = hurtImages.size();
        
        if(animation < max)
            animation++;
        else
            animation = 0;
    }
    
    public void setImage(int type)
    {
        switch(type)
        {
            case MOVEMENT:
                isMoving = true;
                isAttacking = false;
                isHurt = false;
                break;
            case ATTACK:
                isMoving = false;
                isAttacking = true;
                isHurt = false;
                break;
            case HURT:
                isMoving = false;
                isAttacking = false;
                isHurt = true;
                break;
        }
    }
}
