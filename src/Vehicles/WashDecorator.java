package Vehicles;

// A Vehicle subclass, but a superclass for all of the wash decorator subclasses
public abstract class WashDecorator extends Vehicle{

    public WashDecorator(String licensePlate, VehicleType vt) {
        super(licensePlate, vt);
    }


}
