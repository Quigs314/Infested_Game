
import java.awt.Graphics;
import java.io.FileNotFoundException;


public class LargeMeleeWeapon extends Weapon{
    
    public LargeMeleeWeapon(float damage, int delay, String name, Type type)
    {
        super(damage, delay, name, type);
    }
    
    public void draw(Graphics g, Infested i)
    {
        //TODO: Get weapon positioning correct
        try {
            g.drawImage(Infested.getImage(DirConstants.WEAPONS + name), 0, 0, null);
        } catch (FileNotFoundException ex) {
            i.catchException(ex);
        }
    }
}
