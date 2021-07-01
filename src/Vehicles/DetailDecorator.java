package Vehicles;

public class DetailDecorator extends WashDecorator{
    private Vehicle decorate;

    public DetailDecorator(String licensePlate, Vehicle vehicle, VehicleType vt) {
        super(licensePlate, vt);
        this.decorate = vehicle;
    }

    @Override
    public void wash ()
    {
        this.decorate.wash ();
        System.out.println ("It has been detailed.");
    }
}
