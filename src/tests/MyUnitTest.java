package tests;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import Vehicles.Vehicle;
import Vehicles.VehicleType;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import util.*;
import Garage.*;
import Vehicles.*;


public class MyUnitTest 
{




    // test number 1
    @Test
    public void verifyUserInstantiation ()
    {
        InputStream backup = System.in;
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream("test name".getBytes());
        System.setIn(simulatedInput);

        Garage testGarage = new Garage ();
        assertEquals("test name", User.getUserInstance (testGarage).getName());

        System.setIn(backup);
    }
    @Test
    public void verifyMonsterInstanceOfDetail(){
        Vehicle testV= VehicleFactory.create(VehicleType.MONSTER);

        assertTrue(testV instanceof DetailDecorator);
    }
    @Test
    public void VerifyConvertibleInstanceOfDetail(){
        Vehicle testV= VehicleFactory.create(VehicleType.CONVERTIBLE);

        assertTrue(testV instanceof DetailDecorator);

    }
}