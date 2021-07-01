package tests;

import static org.junit.Assert.assertEquals;

import Employees.Mechanic;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import Vehicles.Vehicle;
import Vehicles.VehicleType;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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

        System.setIn(backup);

        assertEquals("test name", User.getUserInstance (testGarage).getName());
    }

    // test number 2
    @Test
    public void testUserForValidTasks () throws IOException {
        InputStream backup = System.in;
        String simulatedInput = "test name\n-1\n1\n0\n4\n8\ndog\n6";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Garage testGarage = new Garage ();
        testGarage.performWorkDay(1);
        System.setIn(backup);
    }


    // test number 3
    @Test
    public void testLicensePlateFirstLetter ()
    {
        for (VehicleType vt : VehicleType.values ())
        {
            assertEquals (LicensePlate.get (vt).charAt (0), vt.name ().charAt (0));
        }
    }

    // test number 4
    @Test
    public void testMonsterCrashStrategy ()
    {
        Vehicle test = VehicleFactory.create(VehicleType.MONSTER);
        assertEquals(test.getCrashStrategy() instanceof CrashChance, true);
    }

    // test number 5
    @Test
    public void testDefaultCrashStrategy ()
    {
        Vehicle test = VehicleFactory.create(VehicleType.BIKE);
        assertEquals(test.getCrashStrategy() instanceof CrashNever, true);
    }

    // test number 6
    @Test
    public void testMechanicInstantiation ()
    {
        Mechanic test = new Mechanic ("jim");
        assertEquals ("jim", test.getName ());
    }

    // test number 7
    @Test
    public void testCrashChance ()
    {
        Vehicle test = VehicleFactory.create(VehicleType.MONSTER);
        int timesCrashed = 0;
        while (!test.isCrashed())
        {
            test.testDrive ();
        }
    }

    // test number 8
    @Test
    public void testNormalVehicleFactory () throws IOException {
        Vehicle test = VehicleFactory.create(VehicleType.BIKE);
        assertEquals(test instanceof Bike, true);
    }

    // test number 9
    @Test
    public void verifyMonsterInstanceOfDetail(){
        Vehicle testV= VehicleFactory.create(VehicleType.MONSTER);

        assertTrue(testV instanceof DetailDecorator);
    }

    // test number 10
    @Test
    public void VerifyConvertibleInstanceOfDetail(){
        Vehicle testV= VehicleFactory.create(VehicleType.CONVERTIBLE);

        assertTrue(testV instanceof DetailDecorator);

    }

}