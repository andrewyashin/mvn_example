package junit;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by andrew_yashin on 2/1/17.
 */
public class CalculatorTest1 {
    @Test public void division(){
        Calculator calculator = new Calculator();
        int result = calculator.division(1,1);
        assertEquals(1,result);
    }
}
