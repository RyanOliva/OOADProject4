package Employees;
import java.util.ArrayList;

import Vehicles.*;

public class Mechanic extends GarageEmployee
{
    private String name;

    // An ArrayList of observers
    private ArrayList <GarageAnnouncer> observers;

    public Mechanic (String name)
    {
        this.name = name;
        observers = new ArrayList <GarageAnnouncer>();
    }

    // Add a new observer
    public void registerObserver (GarageAnnouncer observer)
    {
        this.observers.add (observer);
    }

    // Remove an observer if present in the registry
    public void removeObserver (GarageAnnouncer observer)
    {
        this.observers.removeIf(n -> (n == observer));
    }

    // Notifies all the obser of the mechanics state change
    public void notifyObservers (String state)
    {
        this.observers.forEach (observer -> observer.update (state));
    }

    public void clockIn (int dayNum)
    {
        System.out.println ("Mechanic " + this.name + " arrives at Garage on Day " + dayNum + ".");
        this.notifyObservers("arrived");
    }

    public void clockOut (int dayNum)
    {
        System.out.println ("Mechanic " + this.name + " leaves Garage on Day " + dayNum + ".");
        this.notifyObservers("left");
    }

    public void unlock (Vehicle vehicle)
    {
        this.notifyObservers("unlocking");
        System.out.println ("Mechanic " + this.name + " unlocked " + vehicle.getLicensePlate () + ".");
        vehicle.unlock ();
    }

    public void lock (Vehicle vehicle)
    {
        this.notifyObservers("locking");
        System.out.println ("Mechanic " + this.name + " locked " + vehicle.getLicensePlate () + ".");
        vehicle.lock ();
    }

    public void wash (Vehicle vehicle)
    {
        this.notifyObservers("washing");
        System.out.println ("Mechanic " + this.name + " washed " + vehicle.getLicensePlate () + ".");
        vehicle.wash ();
    }

    public void tuneUp (Vehicle vehicle)
    {
        this.notifyObservers("tuning up");
        System.out.println ("Mechanic " + this.name + " tuned up " + vehicle.getLicensePlate () + ".");
        vehicle.tuneUp ();
    }

    public void testDrive (Vehicle vehicle)
    {
        this.notifyObservers("test driving");
        System.out.println ("Mechanic " + this.name + " test drove " + vehicle.getLicensePlate () + ".");
        vehicle.testDrive ();
    }

    @Override
    public String getName ()
    {
        return this.name;
    }


}
