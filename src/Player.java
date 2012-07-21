import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;

public class Player extends Entity
{
    
    Infested infested;
    
    boolean isWalking;
    boolean isForwards;
    boolean isJumping;
    
    public Player(Infested i)
    {
        infested = i;

        try
        {
            loadPlayerImages();
        }
        catch (IOException ex)
        {
            infested.catchException(ex);
        }
        
        setY(Infested.WIDTH / 2);
        setY(Infested.HEIGHT / 2);
        setWidth(100);
        setHeight(200);
        
        isForwards = true;
        isWalking = false;
        isJumping = false;
    }
    
    public void loadPlayerImages() throws IOException
    {
        forwardImages.add(new ImageIcon(Infested.getImage("player/WalkingRight1")));
        forwardImages.add(new ImageIcon(Infested.getImage("player/WalkingRight2")));
        forwardImages.add(new ImageIcon(Infested.getImage("player/WalkingRight3")));
        backwardsImages.add(new ImageIcon(Infested.getImage("player/WalkingLeft1")));
        backwardsImages.add(new ImageIcon(Infested.getImage("player/WalkingLeft2")));
        backwardsImages.add(new ImageIcon(Infested.getImage("player/WalkingLeft3")));
    }
    
    public Image getImage()
    {
        ImageIcon toReturn;
        
        if(isForwards)
        {
            if (isWalking)
                toReturn = forwardImages.get(getAnimCycle());
            else
                toReturn = forwardImages.get(0);
        }
        else
        {
            if (isWalking)
                toReturn = backwardsImages.get(getAnimCycle());
            else
                    toReturn = backwardsImages.get(0);
        }
        
        return toReturn.getImage();
    }
}
