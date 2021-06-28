package Garage;

import java.util.ArrayList;
import Employees.*;

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

    public void begin ()
    {
        for (int i = this.open; i <= this.close; i++)
        {
            this.garage.updateTime (i);
        }
    }



    private String stringifyTime (int time) 
    {
        if (time > 12) return (Integer.toString(time - 12) + " PM");
        else return (Integer.toString(time) + " AM");
    }
}
