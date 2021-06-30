package tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyUnitTest 
{
    @Test
    public void test ()
    {
        System.out.println("this test ran");
        assertEquals(6, 4);
    }
}