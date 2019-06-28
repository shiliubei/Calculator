package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    String line;


    final Pattern arabic = Pattern.compile("(10|[1-9])");
    final Pattern roman = Pattern.compile("(I|II|III|IV|V|VI|VII|VIII|IX|X)+");
    final Pattern operation = Pattern.compile("\\+|-|\\*|/");
    final Pattern arabicExpression = Pattern.compile("^([1-9]|10)(\\s)+(\\+|-|\\*|/)(\\s)+([1-9]|10)$");
    final Pattern romanExpression = Pattern.compile("^(I|II|III|IV|V|VI|VII|VIII|IX|X){1}(\\s)+(\\+|-|\\*|/){1}(\\s)+(I|II|III|IV|V|VI|VII|VIII|IX|X){1}$");

    public Parser(String line) {
        this.line = line;
    }
    public Parser() {
    }
    public Exp parse(String line) {

        String a = "0";
        String b = "0";
        String op = "0";
        String type = "0";

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
                Exp exp = new Exp(a, b, op, type);
                return exp;
            }
            if (matcherRoman.find()) {
                type = "roman";
                a = matcherRoman.group();
                matcherRoman.find();
                b = matcherRoman.group();
                matcherOperation.find();
                op = matcherOperation.group();
                Exp exp = new Exp(a, b, op, type);
                return exp;
            }

        } else {
            System.out.println("Выражение не соответствует нужному виду");
        }

        Exp exp = new Exp("1", "1", "1", "1");
        return exp;

    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}