package Employees;
import java.util.ArrayList;

import Vehicles.*;

public class Mechanic extends GarageEmployee
{
    private String name;

    // An ArrayList of observers

    public Mechanic (String name)
    {
        this.name = name;
    }

    public void clockIn (int dayNum)
    {
        System.out.println (this.name + " arrives at Garage on Day " + dayNum + ".");

    }

    public void clockOut (int dayNum)
    {
        System.out.println (this.name + " leaves Garage on Day " + dayNum + ".");

    }

    public void unlock (Vehicle vehicle)
    {

        System.out.println (this.name + " unlocked " + vehicle.getLicensePlate () + ".");
        vehicle.unlock ();
    }

    public void lock (Vehicle vehicle)
    {

        System.out.println (this.name + " locked " + vehicle.getLicensePlate () + ".");
        vehicle.lock ();
    }

    public void wash (Vehicle vehicle)
    {

        System.out.println (this.name + " washed " + vehicle.getLicensePlate () + ".");
        vehicle.wash ();
    }

    public void tuneUp (Vehicle vehicle)
    {

        System.out.println (this.name + " tuned up " + vehicle.getLicensePlate () + ".");
        vehicle.tuneUp ();
    }

    public void testDrive (Vehicle vehicle)
    {
        System.out.println (this.name + " test drove " + vehicle.getLicensePlate () + ".");
        vehicle.testDrive ();
    }

    @Override
    public String getName ()
    {
        return this.name;
    }


}
