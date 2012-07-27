import java.io.File;
import javax.sound.sampled.*;

public class Audio extends Thread
{
    //TODO: Add sound
    public static void playButtonSound(Infested i)
    {
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("C://Users//Brian//Documents//NetBeans Images//RPG//Music//.wav")));
            clip.start();
        }
        catch (Exception e)
        {
            i.catchException(e);
        }
    }
}