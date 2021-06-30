package Garage;
import java.util.*;
import Employees.*;
import Vehicles.*;
import util.User;

public class Garage 
{
    // ENCAPSULATION: These three fields are encapsulated, and hidden from any outside classes.
    // The Garage contains a set of vehicles and a mechanic, and exactly how the garage does this is not relevant
    // outside the class. 
    private ArrayList <Vehicle> vehicles;
    private Mechanic mechanic = null;
    private User user = null;
    GarageClock gc;

    // Starts an empty list of vehicles, opens a hiring pool, and hires a mechanic
    public Garage ()
    {
        this.vehicles = new ArrayList <Vehicle>();
        this.user = User.getUserInstance();
        this.hireMechanic ();
        this.gc = new GarageClock (9, 20, this);
    }

    // ABSTRACTION: This method handles hiring of a mechanic, while hiding exactly how that's done.
    // It also calls a method that gets a name for a mechanic, that method is another example of abstraction as well.
    private void hireMechanic ()
    {
        this.mechanic = new Mechanic (this.user.getName());
    }

    // Handles a single workday at the garage
    public void performWorkDay (int dayNum)
    {
        this.gc.begin ();
    }

    // Allows addition of a vehicle
    public void addVehicle (VehicleType vt)
    {
        this.vehicles.add (VehicleFactory.create (vt));
    }
    
    // Allows removal of a vehicle via license plate.
    public void removeVehicle (String license)
    {
        // IDENTITY: Each vehicle has a unique license plate (guaranteed by VehicleFactory) and we can use that
        // identity to fullfill a vehicle deletion request to this garage if that license plate exists here. 
        vehicles.removeIf (vehicle -> (vehicle.getLicensePlate ().equals (license)));
    }

    // Gets called by the GarageClock
    public boolean updateTime (int time)
    {
        ListIterator<Vehicle> vIterator = this.vehicles.listIterator ();
        int task = this.user.getTaskSelection();
        while (vIterator.hasNext ())
        {
            Vehicle vehicle = vIterator.next ();

            switch (task)
            {
                case 1:
                    mechanic.unlock (vehicle);
                    break;
                case 2:
                    mechanic.wash(vehicle);
                    break;
                case 3:
                    mechanic.tuneUp(vehicle);
                    break;
                case 4:
                    mechanic.testDrive(vehicle);
                    if (vehicle instanceof Monster && vehicle.isCrashed ()) 
                    {
                        System.out.println ("Well, that was a good run working at the Garage... Unfortunately you crashed one of our Monster trucks and we're going to have to let you go. Good luck further.");
                        return false;
                    }
                    break;
                case 5:
                    mechanic.lock(vehicle);
                    break;
                case 6:
                    mechanic.clockOut(1);
                    return false;
            }
        }
        return true;
    }
}
