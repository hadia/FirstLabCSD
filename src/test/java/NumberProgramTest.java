import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberProgramTest {
    NumberProgram objectNum;
    @Before
    public void setup()
    {
        objectNum = new NumberProgram();
    }
    @Test
    public void testFindBiggerNumber( ) {
        assertEquals(10.0,objectNum.findBiggerNumber(7,10),0);
        assertEquals(10.10,objectNum.findBiggerNumber(7.7,10.10),0);
        assertEquals(10.10,objectNum.findBiggerNumber(10.10,10.10),0);


    }
}
