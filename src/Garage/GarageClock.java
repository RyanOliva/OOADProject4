package Garage;
public class GarageClock 
{
    // When the garage opens and closes
    private int open, close;
    private Garage garage;

    public GarageClock (int open, int close, Garage garage)
    {
        this.open = open;
        this.close = close;
        this.garage = garage;
    }

    // Iterate through an entire day updating the garage every hour (or when the time changes)
    // It also prints the time
    // If the loop successfully iterates over the entire day, the garage will close.
    public void begin ()
    {
        for (int i = this.open; i < this.close; i++)
        {
            System.out.println ("\nIt is currently " + this.stringifyTime (i));
            if (!this.garage.updateTime (i)) return;
        }
        System.out.println ("\nIt is currently " + this.stringifyTime (this.close));
        System.out.println ("The Garage is closing for the day!");
    }

    // Turns 24-hour time into 12-hour time with AM or PM appended
    private String stringifyTime (int time) 
    {
        if (time > 12) return (Integer.toString(time - 12) + " PM");
        else return (Integer.toString(time) + " AM");
    }
}
