package Vehicles;

public abstract class Motorcycle extends Vehicle 
{
    public Motorcycle (String licensePlate, VehicleType vt)
    {
        super (licensePlate, vt);
    }

    @Override
    public void testDrive ()
    {
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " ridden.");
    }
}
