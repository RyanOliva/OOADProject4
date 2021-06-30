package Vehicles;

public class Convertible extends CarDecorator{
    public Convertible (String licensePlate)
    {
        super (licensePlate);
    }

    @Override
    public void wash ()
    {
        super.wash();
        System.out.println(this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + "is Waxed" + ". " +
                           this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + "is Detailed" + ". " +
                           this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + "is Detailed Again" + ". ") ;

    }
}
