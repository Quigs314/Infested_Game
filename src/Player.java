import java.awt.Image;
import java.io.IOException;

public class Player extends Entity
{
    public static final int SPEED = 6, RANGE = 100;

    private Infested infested;
    
    boolean isWalking;
    boolean isForwards;
    boolean isJumping;

    public Player(Infested i)
    {
        infested = i;

        try
        {
            loadAnimationFrames(getClass());
        }
        catch (IOException ex)
        {
            infested.catchException(ex);
        }

        setWidth(100);
        setHeight(200);
        setX(Infested.WIDTH / 2 - getWidth() / 2);
        setY(Infested.HEIGHT / 2);
        
        isForwards = true;
        isWalking = false;
        isJumping = false;
    }
    
    public Image getImage()
    {
        Image toReturn;
        
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
                toReturn = backwardImages.get(getAnimCycle());
            else
                    toReturn = backwardImages.get(0);
        }

        return toReturn;
    }

    public int getDefaultX()
    {
        return Infested.WIDTH / 2 - getWidth() / 2;
    }
}
