package Employees;
import Vehicles.Vehicle;
public abstract class GarageEmployee 
{
    private String name;
    abstract void clockIn (int dayNum);
    abstract void clockOut (int dayNum);
    abstract void unlock (Vehicle vehicle);
    abstract void lock (Vehicle vehicle);
    abstract void wash (Vehicle vehicle);
    abstract void tuneUp (Vehicle vehicle);
    abstract void testDrive (Vehicle vehicle);
    abstract String getName ();
}
