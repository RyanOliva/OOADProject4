package Garage;
import java.util.*;
import Employees.*;
import Vehicles.*;

public class Garage 
{
    // ENCAPSULATION: These three fields are encapsulated, and hidden from any outside classes.
    // The Garage contains a set of vehicles and a mechanic, and exactly how the garage does this is not relevant
    // outside the class. 
    private ArrayList <Vehicle> vehicles;
    private Mechanic mechanic = null;
    private HiringPool hiringPool;

    // Starts an empty list of vehicles, opens a hiring pool, and hires a mechanic
    public Garage ()
    {
        this.vehicles = new ArrayList <Vehicle>();
        this.hiringPool = new HiringPool ();
        this.hireMechanic ();
    }

    // ABSTRACTION: This method handles hiring of a mechanic, while hiding exactly how that's done.
    // It also calls a method that gets a name for a mechanic, that method is another example of abstraction as well.
    public void hireMechanic ()
    {
        if (this.mechanic != null) System.out.println ("The garage may only have one mechanic hired at a time.");
        else this.mechanic = new Mechanic (this.hiringPool.getName());
    }

    // ABSTRACTION: This method handles firing of a mechanic, while hiding exactly how that's done.
    public void fireMechanic ()
    {
        if (this.mechanic == null) System.out.println ("The garage cannot fire a mechanic when one isn't hired.");
        else this.mechanic = null;
    }

    // This method returns the current mechanic, null if none hired.
    public Mechanic getMechanic ()
    {
        return this.mechanic;
    }

    // Handles a single workday at the garage
    public void performWorkDay (int dayNum)
    {
        this.mechanic.clockIn (dayNum);

        // We use a listiterator because sometimes we need to remove a vehicle during iteration
        ListIterator<Vehicle> vIterator = this.vehicles.listIterator ();
        while (vIterator.hasNext ())
        {
            Vehicle vehicle = vIterator.next ();
            // POLYMORPHISM: Some vehicles have different behaviour for the following methods.
            // When you call .tuneUp () on an instance of Car it could sputter, but we don't need to code for that
            // special case here.
            this.mechanic.unlock (vehicle);
            this.mechanic.wash (vehicle);
            this.mechanic.tuneUp (vehicle);
            this.mechanic.testDrive (vehicle);
            if (vehicle instanceof Monster && vehicle.isCrashed ())
            {
                this.fireMechanic ();
                this.hireMechanic ();
                vIterator.remove ();
                continue;
            }
            this.mechanic.lock (vehicle);
        }

        this.mechanic.clockOut (dayNum);
    }

    // Allows addition of a vehicle
    public void addVehicle (VehicleType vt)
    {
        this.vehicles.add (VehicleFactory.getVehicle (vt));
    }
    
    // Allows removal of a vehicle via license plate.
    public void removeVehicle (String license)
    {
        // IDENTITY: Each vehicle has a unique license plate (guaranteed by VehicleFactory) and we can use that
        // identity to fullfill a vehicle deletion request to this garage if that license plate exists here. 
        vehicles.removeIf (vehicle -> (vehicle.getLicensePlate ().equals (license)));
    }
}
