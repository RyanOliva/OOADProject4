package Vehicles;
import java.util.*;

// ABSTRACT CLASS: This class is the superclass for all vehicle types.
// You cannot make an instance of a vehicle, but all vehicle are, well, vehicles. So they extend this class.
public abstract class Vehicle 
{
    private String licensePlate;
    private boolean isCrashed = false;

    public Vehicle (String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate ()
    {
        return this.licensePlate;
    }

    public void wash ()
    {
        String result = "shines";
        Random rand = new Random ();
        if (rand.nextInt (10) < 3) result = "sparkles";
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + result + ".");
    }

    public void unlock ()
    {
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " unlocked.");
    }

    public void lock ()
    {
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " locked.");
    }

    public void tuneUp ()
    {
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " runs.");
    }

    public void testDrive ()
    {
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " drives.");
    }

    public boolean isCrashed () 
    {
        return this.isCrashed;
    }

    public void crashed () 
    {
        this.isCrashed = true;
    }
}
