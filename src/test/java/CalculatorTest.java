
import calculator.Calculator;
import calculator.Exp;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    Calculator calc = new Calculator();

    /**
     * Test calculator.
     */
    @Test
    public void whenParse() {
        Exp exp = new Exp("10", "3", "+", "arabic");
        assertEquals(this.calc.parse("10 + 3"), exp);
    }
}
