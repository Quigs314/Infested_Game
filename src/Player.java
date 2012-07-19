
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;


public class Player extends Entity{
    
    Infested infested;
    
    boolean isWalking;
    boolean isForwards;
    boolean isJumping;
    
    public Player(Infested i)
    {
        infested = i;
        try {
            loadPlayerImages();
        } catch (IOException ex) {
            infested.catchException(ex);
        }
        
        x = Infested.WIDTH / 2;
        y = Infested.HEIGHT / 2;
        width = 100;
        height = 200;
        
        isForwards = true;
        isWalking = false;
        isJumping = false;
    }
    
    public void loadPlayerImages() throws IOException
    {
        forwardImages.add(new ImageIcon(infested.loadImage("player/WalkingRight1")));
        backwardsImages.add(new ImageIcon(infested.loadImage("player/WalkingLeft1")));
    }
    
    public Image getImage()
    {
        ImageIcon toReturn;
        
        if(isForwards)
            toReturn = forwardImages.get(cycle);
        else
            toReturn = backwardsImages.get(cycle);
        
        return toReturn.getImage();
    }
}
