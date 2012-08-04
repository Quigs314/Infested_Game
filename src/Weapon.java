
public class Weapon {
    
    float damage;
    int delay;
    String name;
    Type type;
    
    public enum Type
    {
        BLUNT,
        SHARP,
        POISON,
        HEAT,
        ICE;
    }
    
    public Weapon(float damage, int delay, String name, Type type)
    {
        this.damage = damage;
        this.delay = delay;
        this.name = name;
        this.type = type;
    }
    
    public float getDamage()
    {
        return damage;
    }
    
    public int getDelay()
    {
        return delay;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Type getType()
    {
        return type;
    }
}