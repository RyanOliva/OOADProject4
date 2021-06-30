package Vehicles;

public class WaxDecorator extends WashDecorator{
    private Vehicle decorate;

    public WaxDecorator(String licensePlate, Vehicle vehicle) {
        super(licensePlate);
        this.decorate = vehicle;
    }
    @Override
    public void wash ()
    {
        this.decorate.wash ();
        System.out.println (this.getLicensePlate () + " waxed");
        System.out.println("It has been waxed");
    }
}
