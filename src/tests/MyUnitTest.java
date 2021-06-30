package tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import util.*;
import Garage.*;

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
}