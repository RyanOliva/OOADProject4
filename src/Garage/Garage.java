package Garage;
import java.util.*;
import Vehicles.*;
import util.*;

public class Garage 
{
    // ENCAPSULATION: These three fields are encapsulated, and hidden from any outside classes.
    // The Garage contains a set of vehicles and a mechanic, and exactly how the garage does this is not relevant
    // outside the class. 
    private ArrayList <Vehicle> vehicles;
    private User user = null;
    GarageClock gc;
    private Command command;

    // Starts an empty list of vehicles, opens a hiring pool, and hires a mechanic
    public Garage ()
    {
        this.vehicles = new ArrayList <Vehicle>();
        this.user = User.getUserInstance(this);
        this.gc = new GarageClock (9, 20, this);
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

    // Accept a new command, doesn't matter from who.
    public void setCommand (Command command)
    {
        this.command = command;
    }

    // Gets called by the GarageClock
    public boolean updateTime (int time)
    {
        ListIterator<Vehicle> vIterator = this.vehicles.listIterator ();

        // Wait for a user to select a task. If the user returns true then a command was set and we can continue forward
        if (!this.user.waitForCommand()) return false;

        // Iterate over the vehicles in the garage
        while (vIterator.hasNext ())
        {
            Vehicle vehicle = vIterator.next ();

            // Execute the stored command (the garage is acting as the invoker)
            // The garage also doesn't know who the reciever is, since that was set by whoever set the command (in this case the user (or client))
            this.command.execute(vehicle);

            if (vehicle.isCrashed ()) 
            {
                System.out.println ("Well, that was a good run working at the Garage... Unfortunately you crashed one of our Monster trucks and we're going to have to let you go. Good luck further.");
                return false;
            }
        }
        return true;
    }
}
