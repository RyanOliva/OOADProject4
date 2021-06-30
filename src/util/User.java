package util;
import java.util.Scanner;

public class User {

    // Singleton User storage
    private static User singletonUserInstance = null;
    private String name;
    private Scanner input = new Scanner(System.in);
    private boolean didUnlock = false;

    // Asks the user for a name when creating a new user
    private User ()
    {
        // Get user input name, and then create the instance
        System.out.print ("Please enter your name: ");
        this.name = this.input.nextLine(); 
    }

    // Returns the name of the user
    // Called like User.getUserInstance().getName()
    public String getName ()
    {
        return this.name;
    }

    // Get a task selection from the user
    public int getTaskSelection ()
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
        return selection;
    }

    // Only allows one user to exist at a time
    public static User getUserInstance ()
    {
        if (singletonUserInstance == null) singletonUserInstance = new User ();
        return singletonUserInstance;
    }

}
