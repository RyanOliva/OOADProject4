package Employees;

public class GarageAnnouncer extends GarageEmployee 
{
    private String name;

    public GarageAnnouncer (String name)
    {
        this.name = name;
    }

    public void clockIn ()
    {
        System.out.println ("Goodmorning! The Announcer has arrived at the garage.");
    }

    public void clockOut ()
    {
        System.out.println ("The garage is closing! The Announcer is leaving the garage.");
    }

    @Override
    public String getName ()
    {
        return this.name;
    }

    // The announcer simply announces the upcoming state of the mechanic.
    // If the mechanic is leaving the garage should close
    // Only if the mechanic has arrived should the announcer be present (although the announcer doesn't deregistered from the mechanic)
    public void update (String state)
    {   
        if (state == "left") this.clockOut ();
        else if (state == "arrived") this.clockIn();
        else System.out.println ("This is the Garage Announcer! The mechanic is about to start " + state + " the vehicles.");
    }

    // Hook for announcing the time
    public void updateTime (String time)
    {
        System.out.println ("The time is now " + time + "!");
    }
    
}
