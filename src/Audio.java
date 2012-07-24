
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Audio extends Thread{
    //TODO: Add sound
    public static void playButtonSound(Infested i)
    {
        try {
            Clip clip = AudioSystem.getClip();
            File file = new File("C://Users//Brian//Documents//NetBeans Images//RPG//Music//.wav");
            AudioInputStream input = AudioSystem.getAudioInputStream(file);
            clip.open(input);
            clip.start();
        } catch (LineUnavailableException ex) {
            i.setVisible(false);
            Infested.catchException(ex);
        } catch (IOException ex){
            i.setVisible(false);
            Infested.catchException(ex);
        } catch (UnsupportedAudioFileException ex){
            i.setVisible(false);
            Infested.catchException(ex);
        }
    }
}