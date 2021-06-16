package Employees;
import Vehicles.*;

public class Mechanic extends GarageEmployee
{
    private String name;

    public Mechanic (String name)
    {
        this.name = name;
    }

    @Override
    public void clockIn (int dayNum)
    {
        System.out.println ("Mechanic " + this.name + " arrives at Garage on Day " + dayNum + ".");
    }

    @Override
    public void clockOut (int dayNum)
    {
        System.out.println ("Mechanic " + this.name + " leaves Garage on Day " + dayNum + ".");
    }

    @Override
    public void unlock (Vehicle vehicle)
    {
        System.out.println ("Mechanic " + this.name + " unlocked " + vehicle.getLicensePlate () + ".");
        vehicle.unlock ();
    }

    @Override
    public void lock (Vehicle vehicle)
    {
        System.out.println ("Mechanic " + this.name + " locked " + vehicle.getLicensePlate () + ".");
        vehicle.lock ();
    }

    @Override
    public void wash (Vehicle vehicle)
    {
        System.out.println ("Mechanic " + this.name + " washed " + vehicle.getLicensePlate () + ".");
        vehicle.wash ();
    }

    @Override
    public void tuneUp (Vehicle vehicle)
    {
        System.out.println ("Mechanic " + this.name + " tuned up " + vehicle.getLicensePlate () + ".");
        vehicle.tuneUp ();
    }

    @Override
    public void testDrive (Vehicle vehicle)
    {
        System.out.println ("Mechanic " + this.name + " test drove " + vehicle.getLicensePlate () + ".");
        vehicle.testDrive ();
    }

    @Override
    public String getName ()
    {
        return this.name;
    }


}
