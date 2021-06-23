package util;

import java.util.HashSet;
import java.util.Random;
import Vehicles.VehicleType;

public class LicensePlate 
{
    private static HashSet <String> licenses = new HashSet <String>();
    
    public static String get (VehicleType vt)
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
