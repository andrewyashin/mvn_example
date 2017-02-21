package junit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrew_yashin on 2/1/17.
 */
public class CalculatorTest {
    @Test
    public void division() throws Exception {
        Calculator calculator = new Calculator();
        int result = calculator.division(1,1);
        Assert.assertEquals(1, result);
    }

}