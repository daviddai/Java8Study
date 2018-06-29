package lambda.study.test;

import lambda.study.StringManipulation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringManipulationTest {

    private StringManipulation stringManipulation;

    @Before
    public void init() {
        stringManipulation = new StringManipulation();
    }

    @Test
    public void testRemoveDigits() {
        Assert.assertEquals("It is expected to be Remove Digits", "Remove Digits", stringManipulation.removeDigits("Rem1o2ve Di3g4its9"));
    }

}
