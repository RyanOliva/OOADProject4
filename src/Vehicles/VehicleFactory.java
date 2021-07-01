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
                return new Bike (license, VehicleType.BIKE);
            case MONSTER:
                Monster monster = new Monster (license, VehicleType.MONSTER);
                // Strategy pattern
                WaxDecorator wax1 = new WaxDecorator (license, monster, VehicleType.MONSTER);
                WaxDecorator wax2 = new WaxDecorator (license, wax1, VehicleType.MONSTER);
                PolishDecorator polish = new PolishDecorator (license, wax2, VehicleType.MONSTER);
                DetailDecorator detail = new DetailDecorator (license, polish, VehicleType.MONSTER);
                detail.setCrashStrategy(new CrashChance ());
                return detail;
            case TRIKE:
                return new Trike (license, VehicleType.TRIKE);
            case SIDECAR:
                return new Sidecar (license, VehicleType.SIDECAR);
            case HATCHBACK:
                return new Hatchback (license, VehicleType.HATCHBACK);
            case SUV:
                return new SUV (license, VehicleType.SUV);
            case WAGON:
                return new Wagon (license, VehicleType.WAGON);
            case CONVERTIBLE:
                Convertible convertible = new Convertible(license, VehicleType.CONVERTIBLE);
                WaxDecorator wax = new WaxDecorator (license, convertible, VehicleType.CONVERTIBLE);
                DetailDecorator detail1 = new DetailDecorator (license, wax, VehicleType.CONVERTIBLE);
                DetailDecorator detail2 = new DetailDecorator (license, detail1, VehicleType.CONVERTIBLE);
                return detail2;
            case PICKUP:
                return new Pickup (license, VehicleType.PICKUP);
            case DELIVERY:
                return new Delivery (license, VehicleType.DELIVERY);
            case SCHOOLBUS:
                return new Schoolbus (license, VehicleType.SCHOOLBUS);
            case SHUTTLEBUS:
                return new Shuttlebus (license, VehicleType.SHUTTLEBUS);
            default:
                System.out.println ("Something went horribly wrong. Attempted to create an unknown vehicle.");
                return null;
        }
    }
}
