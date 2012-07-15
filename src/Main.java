
public class Main {
    
    static Infested instance;
    
    public static void main(String[] args)
    {
        instance = new Infested();
    }
    
    public Infested getInstance()
    {
        return instance;
    }
}
