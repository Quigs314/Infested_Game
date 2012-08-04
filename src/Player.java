import java.awt.Image;
import java.io.IOException;

public class Player extends Entity
{
    public static final int RANGE = 50;

    public int speed;
    public float fallSpeed;

    private Infested infested;
    
    boolean isWalking;
    boolean isForwards;
    boolean isJumping;

    Weapon currentWeapon;
    
    public Player(Infested i)
    {
        infested = i;

        speed = 6;
        fallSpeed = 0;  

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
   
    public void fall()
    {
        setY(getY() + (int)fallSpeed);
        //TODO: Replace statement with method for determining if player is on a platform
        if(getY() >= Infested.HEIGHT / 2)
        {
            fallSpeed = 0;
            isJumping = false;
        }
        else
        {
            fallSpeed += 0.5;
            isJumping = true;
        }
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
