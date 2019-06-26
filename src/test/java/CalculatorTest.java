
import calculator.Calculator;
import calculator.Exp;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    /**
     * Test addUser.
     */
    @Test
    public void whenUserThenAddUser() {
        Calculator calc = new Calculator();
        calc.parse("1 + 10");
        Exp exp = new Exp("1", "1", "+", "arabic");
        assertThat(calc.parse("1 + 1"), is(exp));
    }
}
