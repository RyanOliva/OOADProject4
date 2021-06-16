package Vehicles;

public abstract class Motorcycle extends Vehicle 
{
    public Motorcycle (String licensePlate)
    {
        super (licensePlate);
    }

    @Override
    public void testDrive ()
    {
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " ridden.");
    }
}
