import Garage.*;
import Vehicles.*;

public class Project4
{
    public static void main (String[] args)
    {
        // Create a new garage
        Garage garage = new Garage ();

        // Add one of each vehicle type
        for (VehicleType vt : VehicleType.values ())
        {
            garage.addVehicle(vt);
        }

        // Perform a single workday at the garage
        garage.performWorkDay (1);
    }
}