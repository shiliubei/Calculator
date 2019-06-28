
import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
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
        Expression expression = new Expression("5", "3", "+", "arabic");
        Parser parser = new Parser();
        assertEquals(parser.parse("5 + 3"), expression);
    }
    @Test
    public void whenParseRomanAddition() {
        Expression expression = new Expression("I", "V", "+", "roman");
        Parser parser = new Parser();
        assertEquals(parser.parse("I + V"), expression);
    }
    @Test
    public void whenParseArabicTwoDigitNumberAddition() {
        Expression expression = new Expression("10", "3", "+", "arabic");
        Parser parser = new Parser();
        assertEquals(parser.parse("10 + 3"), expression);
    }
    @Test
    public void whenParseRomanTwoSimbolNumberAddition() {
        Expression expression = new Expression("III", "VII", "+", "roman");
        Parser parser = new Parser();
        assertEquals(parser.parse("III + VII"), expression);
    }
    @Test
    public void whenParseRomanC() {
        Expression expression = new Expression("IX", "X", "/", "roman");
        Parser parser = new Parser();
        assertEquals(parser.parse("IX / X"), expression);
    }

}
