package util;
import java.util.Scanner;
import Employees.*;
import Garage.*;

public class User {

    // Singleton User storage
    private static User singletonUserInstance = null;
    private String name;
    private Scanner input = new Scanner(System.in);
    private boolean didUnlock = false;
    private Mechanic reciever;
    private Garage invoker;

    // Asks the user for a name when creating a new user
    private User (Garage garage)
    {
        // Get user input name, and then create the instance
        System.out.print ("Please enter your name: ");
        this.name = this.input.nextLine(); 
        reciever = new Mechanic (this.name);
        this.invoker = garage;
    }

    // Returns the name of the user
    // Called like User.getUserInstance().getName()
    public String getName ()
    {
        return this.name;
    }

    // Get a task selection from the user
    public boolean waitForCommand ()
    {
        System.out.println ("You can perform one of the folloing tasks:");
        System.out.println ("1. Unlock");
        System.out.println ("2. Wash");
        System.out.println ("3. Tune-Up");
        System.out.println ("4. Test Drive");
        System.out.println ("5. Lock");
        System.out.println ("6. Leave");

        int selection = 0;
        while (selection < 1 || selection > 6)
        {
            System.out.print ("Which would like to perform (enter 1-5): ");
            try
            {
                selection = input.nextInt ();
                if (selection < 1 || selection > 6) System.out.println ("Please enter an option between 1 and 5.");
                else if (this.didUnlock == false && selection != 1) 
                {
                    System.out.println ("You may not perform that task unless the vehicles have been unlocked.");
                    selection = 0;
                }
                
                if (selection == 1) this.didUnlock = true;
            }
            catch (Exception e)
            {
                System.out.println ("You entered an invalid number, please try again!");
                input.next ();
            }
        }
        switch (selection)
        {
            case 1:
                this.invoker.setCommand (reciever::unlock);
                break;
            case 2:
                this.invoker.setCommand (reciever::wash);
                break;
            case 3:
                this.invoker.setCommand (reciever::tuneUp);
                break;
            case 4:
                this.invoker.setCommand (reciever::testDrive);
                break;
            case 5:
                this.invoker.setCommand (reciever::lock);
                break;
            case 6:
                System.out.println (this.getName () + " has left the garage!");
                return false;
        }
        return true;
    }

    // Only allows one user to exist at a time
    public static User getUserInstance (Garage garage)
    {
        if (singletonUserInstance == null) singletonUserInstance = new User (garage);
        return singletonUserInstance;
    }

}
