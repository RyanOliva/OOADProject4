package Vehicles;

public class DetailDecorator extends WashDecorator{
    private Vehicle decorate;

    public DetailDecorator(String licensePlate, Vehicle vehicle) {
        super(licensePlate);
        this.decorate = vehicle;
    }
    @Override
    public void wash ()
    {
        this.decorate.wash ();
        System.out.println (this.getLicensePlate () + " waxed");
    }
}
