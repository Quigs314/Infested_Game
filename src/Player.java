import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;

public class Player extends Entity
{
    public int speed;
    public float fallSpeed;
    
    private Infested infested;
    
    public boolean isWalking;
    public boolean isForwards;
    public boolean isJumping;

    public Player(Infested i)
    {
        infested = i;

        speed = 6;
        fallSpeed = 0;
        
        try
        {
            loadPlayerImages();
        }
        catch (IOException ex)
        {
            Infested.catchException(ex);
        }
        
        setX(Infested.WIDTH / 2);
        setY(Infested.HEIGHT / 2);
        setWidth(100);
        setHeight(200);
        
        isForwards = true;
        isWalking = false;
        isJumping = false;
    }
    
    public void fall()
    {
        setY(getY() + (int)fallSpeed);
        //TODO: Replace statement with method for determining if player is on a platform
        if(getY() > Infested.WIDTH / 2 - 50)
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
