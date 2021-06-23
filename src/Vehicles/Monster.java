package Vehicles;

public class Monster extends Truck 
{
    public Monster (String licensePlate)
    {
        super (licensePlate);
    }

    // The crash chance has been delegated to the Vehicle superclass via strategy pattern
}
