package calculator;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String line;


    final private Pattern arabic = Pattern.compile("(10|[1-9])");
    final private Pattern roman = Pattern.compile("(I|II|III|IV|V|VI|VII|VIII|IX|X)+");
    final private Pattern operation = Pattern.compile("\\+|-|\\*|/");
    final private Pattern arabicExpression = Pattern.compile("^([1-9]|10)(\\s)+(\\+|-|\\*|/)(\\s)+([1-9]|10)$");
    final private Pattern romanExpression = Pattern.compile("^(I|II|III|IV|V|VI|VII|VIII|IX|X)(\\s)+(\\+|-|\\*|/)(\\s)+(I|II|III|IV|V|VI|VII|VIII|IX|X)$");

    public Parser(String line) {
        this.line = line;
    }

    public Parser() {
    }

    public Expression parse(String line) {

        String a;
        String b;
        String op;
        String type;

        Matcher matcherArabic = arabic.matcher(line);
        Matcher matcherRoman = roman.matcher(line);
        Matcher matcherOperation = operation.matcher(line);
        Matcher matcherArabicExp = arabicExpression.matcher(line);
        Matcher matcherRomanExp = romanExpression.matcher(line);

        if (matcherArabicExp.find() || matcherRomanExp.find()) {
            if (matcherArabic.find()) {
                type = "arabic";
                a = matcherArabic.group();
                matcherArabic.find();
                b = matcherArabic.group();
                matcherOperation.find();
                op = matcherOperation.group();
                Expression expression = new Expression(a, b, op, type);
                return expression;
            }
            if (matcherRoman.find()) {
                type = "roman";
                a = matcherRoman.group();
                matcherRoman.find();
                b = matcherRoman.group();
                matcherOperation.find();
                op = matcherOperation.group();
                Expression expression = new Expression(a, b, op, type);
                return expression;
            }

        }
        throw new NoSuchElementException("Выражение не соответствует нужному виду");

    }

}