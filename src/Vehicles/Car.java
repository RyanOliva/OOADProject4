package Vehicles;
import java.util.*;

public abstract class Car extends Vehicle
{

    public Car (String licensePlate)
    {
        super (licensePlate);
    }

    @Override
    public void tuneUp() {
        Random r = new Random();
        int result = r.nextInt(100) ;
        if (result < 25){
            System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " sputters.");
        }
        else {
            System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " runs.");
        }

    }
}
