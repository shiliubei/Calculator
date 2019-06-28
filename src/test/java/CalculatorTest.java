
import calculator.Calculator;
import calculator.Exp;
import calculator.Parser;
import calculator.Result;
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
        Parser parser = new Parser();
        assertEquals(parser.parse("5 + 3"), exp);
    }
    @Test
    public void whenParseRomanAddition() {
        Exp exp = new Exp("I", "V", "+", "arabic");
        Parser parser = new Parser();
        assertEquals(parser.parse("I + V"), exp);
    }
    @Test
    public void whenParseArabicTwoDigitNumberAddition() {
        Exp exp = new Exp("10", "3", "+", "arabic");
        Parser parser = new Parser();
        assertEquals(parser.parse("10 + 3"), exp);
    }
    @Test
    public void whenParseRomanTwoSimbolNumberAddition() {
        Exp exp = new Exp("III", "VII", "+", "arabic");
        Parser parser = new Parser();
        assertEquals(parser.parse("III + VII"), exp);
    }
    @Test
    public void whenParseRomanC() {
        Exp exp = new Exp("IX", "X", "/", "arabic");
        Parser parser = new Parser();
        assertEquals(parser.parse("IX / X"), exp);
    }
    @Test
    public void whenGetResult() {
        Exp exp = new Exp("5", "3", "+", "arabic");
        Result res = new Result ("8", "arabic");
        assertEquals(calc.execute(exp), res);
    }
    @Test
    public void whenGetResultDevideArabic() {
        Exp exp = new Exp("5", "3", "/", "arabic");
        Result res = new Result ("5/3", "arabic");
        assertEquals(calc.execute(exp), res);
    }
    @Test
    public void whenGetResultDevideRoman() {
        Exp exp = new Exp("I", "V", "/", "roman");
        Result res = new Result ("I/V", "roman");
        assertEquals(calc.execute(exp), res);
    }
}
