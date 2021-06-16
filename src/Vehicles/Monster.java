package Vehicles;
import java.util.*;

public class Monster extends Truck 
{
    public Monster (String licensePlate)
    {
        super (licensePlate);
    }

    @Override
    public void testDrive ()
    {
        String result = "drives";
        Random rand = new Random ();
        if (rand.nextInt (10) < 2) 
        {
            this.crashed ();
            result = "crashed";
        }
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + result +".");
    }

}
