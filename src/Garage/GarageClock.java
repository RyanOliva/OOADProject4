package Garage;

import java.util.ArrayList;
import Employees.*;

public class GarageClock 
{
    // When the garage opens and closes
    private int open, close;
    private ArrayList <GarageAnnouncer> observers;
    private Garage garage;

    public GarageClock (int open, int close, Garage garage)
    {
        this.observers = new ArrayList<GarageAnnouncer>();
        this.open = open;
        this.close = close;
        this.garage = garage;
    }

    public void begin ()
    {
        for (int i = this.open; i <= this.close; i++)
        {
            this.notifyObservers (i);
            this.garage.updateTime (i);
        }
    }

    public void registerObserver (GarageAnnouncer observer)
    {
        this.observers.add (observer);
    }

    public void removeObserver (GarageAnnouncer observer)
    {
        this.observers.removeIf(n -> (n == observer));
    }

    private void notifyObservers (int time)
    {
        try 
        {
            this.observers.forEach(observer -> observer.updateTime (this.stringifyTime (time)));
        } 
        catch (Exception e)
        {
            System.out.println ("No registered observers.");
        }
    }

    private String stringifyTime (int time) 
    {
        if (time > 12) return (Integer.toString(time - 12) + " PM");
        else return (Integer.toString(time) + " AM");
    }
}
