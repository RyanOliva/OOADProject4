package Vehicles;
import java.util.Random;

// This crash strategy has a 20% of crashing whatever vehicle it is connected to
public class CrashChance extends CrashStrategy
{
    public boolean isCrashed ()
    {
        Random rand = new Random ();
        if (rand.nextInt (10) < 2) return true;
        else return false;
    }
}
