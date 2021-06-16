package Vehicles;
import java.util.*;

public class VehicleFactory {

    private static HashSet <String> licenses = new HashSet <String>();

    public static Vehicle getVehicle (VehicleType vt)
    {
        Vehicle newVehicle;
        String license = generateLicensePlate (vt);
        switch (vt)
        {
            case BIKE:
                newVehicle = new Bike (license);
                break;
            case MONSTER:
                newVehicle = new Monster (license);
                break;
            case TRIKE:
                newVehicle = new Trike (license);
                break;
            case SIDECAR:
                newVehicle = new Sidecar (license);
                break;
             case HATCHBACK:
                 newVehicle = new Hatchback (license);
                 break;
             case SUV:
                 newVehicle = new SUV (license);
                 break;
             case WAGON:
                 newVehicle = new Wagon (license);
                 break;
             case CONVERTIBLE:
                 newVehicle = new Convertible (license);
                 break;
             case PICKUP:
                 newVehicle = new Pickup (license);
                 break;
             case DELIVERY:
                 newVehicle = new Delivery (license);
                 break;
            case SCHOOLBUS:
                 newVehicle = new Schoolbus (license);
                 break;
            case SHUTTLEBUS:
                newVehicle = new Shuttlebus (license);
                break;
            default:
                System.out.println ("Something went horribly wrong. Attempted to create an unknown vehicle.");
                return null;
        }
        return newVehicle;
    }

    // This function generates a license plate for a new vehicle.
    // A license number starts with the first letter of the vehicle type and contains 5 random letters or numbers following it.
    // This method will return a unique license number (FOR THE INSTANCE OF A SINGLE PROGRAM) each time it is run.
    private static String generateLicensePlate (VehicleType vt)
    {

        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String license = "";

        // Create a random license number, if it is not unique then try again.
        while (true)
        {
            Random rand = new Random ();

            // Generate a string by randomly selecting from the hardcoded alphabet
            license =  "" + vt.toString ().charAt (0);
            for (int i = 0; i < 5; i++)
            {
                license += alpha.charAt (rand.nextInt (alpha.length ()));
            }

            // If the license number is unique, add it to the hashset and return it. Otherwise try again.
            if (!licenses.contains (license)) 
            {
                licenses.add (license);
                return license;
            }
        }
    }
}
