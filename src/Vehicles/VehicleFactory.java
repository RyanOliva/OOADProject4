package Vehicles;
import util.*;

public class VehicleFactory 
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
                WaxDecorator wax1 = new WaxDecorator (license, monster);
                WaxDecorator wax2 = new WaxDecorator (license, wax1);
                PolishDecorator polish = new PolishDecorator (license, wax2);
                DetailDecorator detail = new DetailDecorator (license, polish);
                return detail;
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
                Convertible convertible = new Convertible(license);
                WaxDecorator wax = new WaxDecorator (license, convertible);
                DetailDecorator detail1 = new DetailDecorator (license, wax);
                DetailDecorator detail2 = new DetailDecorator (license, detail1);
                return detail2;
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
