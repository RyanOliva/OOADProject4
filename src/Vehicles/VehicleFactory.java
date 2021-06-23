package Vehicles;
import util.*;

public abstract class VehicleFactory 
{

    // Creates a new vehicle of the given type.
    // Also calls the LicensePlate manager to generate a unique license plate for each vehicle.
    // Sets the crash strategy for the monster trucks.
    public static Vehicle create (VehicleType vt)
    {
        String license = LicensePlate.get (vt);
        switch (vt)
        {
            case BIKE:
                return new Bike (license);
            case MONSTER:
                Monster monster = new Monster (license);
                // Strategy pattern
                monster.setCrashStrategy(new CrashChance ());
                return monster;
            case TRIKE:
                return new Trike (license);
            case SIDECAR:
                return new Sidecar (license);
            case HATCHBACK:
                return new Hatchback (license);
            case SUV:
                return new SUV (license);
            case WAGON:
                return new Wagon (license);
            case CONVERTIBLE:
                return new Convertible (license);
            case PICKUP:
                return new Pickup (license);
            case DELIVERY:
                return new Delivery (license);
            case SCHOOLBUS:
                return new Schoolbus (license);
            case SHUTTLEBUS:
                return new Shuttlebus (license);
            default:
                System.out.println ("Something went horribly wrong. Attempted to create an unknown vehicle.");
                return null;
        }
    }
}
