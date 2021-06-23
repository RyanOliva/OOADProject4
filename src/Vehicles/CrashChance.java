package Vehicles;
import java.util.Random;

public class CrashChance extends CrashStrategy
{
    public boolean isCrashed ()
    {
        Random rand = new Random ();
        if (rand.nextInt (10) < 2) return true;
        else return false;
    }
}
