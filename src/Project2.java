import java.util.Scanner;
import Garage.*;
import Vehicles.*;

public class Project2
{
    public static void main (String[] args)
    {
        // Get user input days
        int numberOfDays = getDays ();
        Garage garage = new Garage ();

        // Add two of each vehicle type
        for (VehicleType vt : VehicleType.values ())
        {
            garage.addVehicle(vt);
            garage.addVehicle(vt);
        }

        // Iterate over each day
        for (int i = 1; i <= numberOfDays; i++ )
        {
            garage.performWorkDay (i);
        }
    }

    // Gets and validate a user entered number
    public static int getDays ()
    {
        Scanner input = new Scanner (System.in);
        int numberOfDays = 0;
        while (numberOfDays <= 0)
        {
            System.out.print ("Enter a number of days: ");
            try
            {
                numberOfDays = input.nextInt ();
                if (numberOfDays <= 0) System.out.println ("Please enter a number greater than zero!");
            }
            catch (Exception e)
            {
                System.out.println ("You entered an invalid number, please try again!");
                input.next ();
            }
        }
        return numberOfDays;
    }
}