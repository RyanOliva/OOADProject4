package Vehicles;

// Part of the decorator pattern
public class DetailDecorator extends WashDecorator{
    private Vehicle decorate;

    public DetailDecorator(String licensePlate, Vehicle vehicle, VehicleType vt) 
    {
        super(licensePlate, vt);
        this.decorate = vehicle;
    }

    // This calls it's decoratees wash method, and then appends it's own wash task.
    @Override
    public void wash ()
    {
        this.decorate.wash ();
        System.out.println ("It has been detailed.");
    }
}
