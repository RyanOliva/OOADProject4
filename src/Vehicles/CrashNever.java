package Vehicles;

// This crash strategy always returns false when a vehicle is checking if it crashed
public class CrashNever extends CrashStrategy
{
    public boolean isCrashed ()
    {
        return false;
    }
}
