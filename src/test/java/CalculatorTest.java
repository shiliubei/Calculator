
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
    public void whenParseArabicAddition() {
        Exp exp = new Exp("5", "3", "+", "arabic");
        assertEquals(this.calc.parse("5 + 3"), exp);
    }
    @Test
    public void whenParseRomanAddition() {
        Exp exp = new Exp("I", "V", "+", "arabic");
        assertEquals(this.calc.parse("I + V"), exp);
    }
    @Test
    public void whenParseArabicTwoDigitNumberAddition() {
        Exp exp = new Exp("10", "3", "+", "arabic");
        assertEquals(this.calc.parse("10 + 3"), exp);
    }
    @Test
    public void whenParseRomanTwoSimbolNumberAddition() {
        Exp exp = new Exp("II", "VI", "+", "arabic");
        assertEquals(this.calc.parse("II + VI"), exp);
    }
    @Test
    public void whenParseRomanC() {
        Exp exp = new Exp("IX", "X", "+", "arabic");
        assertEquals(this.calc.parse("IX + X"), exp);
    }
}
