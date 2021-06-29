package Vehicles;

public class Monster extends TruckDecorator
{
    public Monster (String licensePlate)
    {
        super (licensePlate);
    }

    @Override
    public void wash() {
        super.wash();
        System.out.println(this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + "is Waxed" + ". " +
                this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + "is Waxed Again" + ". " +
                this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + "is Polished" + ". " +
                this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + "is Detailed" + ". ");
    }
    // The crash chance has been delegated to the Vehicle superclass via strategy pattern
}
