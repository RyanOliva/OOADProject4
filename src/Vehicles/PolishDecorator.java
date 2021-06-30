package Vehicles;

public class PolishDecorator extends WashDecorator {
    private Vehicle decorate;

    public PolishDecorator(String licensePlate, Vehicle vehicle) {
        super(licensePlate);
        this.decorate = vehicle;
    }
    @Override
    public void wash ()
    {
        this.decorate.wash ();
        System.out.println (this.getLicensePlate () + " polished");
        System.out.println("It has been polished.");
    }
}

