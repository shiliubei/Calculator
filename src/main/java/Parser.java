import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private Pattern arabic = Pattern.compile("([1-9]|10){1}");
    private Pattern roman = Pattern.compile("(I|II|III|IV|V|VI|VII|VIII|IX|X){1}");
    private Pattern operation = Pattern.compile("\\+|-|\\*|/");

    void parse  (String line){
        String a;
        String b;
        String op;
        //String line;

        Matcher matcherArabic = arabic.matcher(line);
        Matcher matcherRoman = roman.matcher(line);
        Matcher matcherOperation = operation.matcher(line);

        if ((matcherArabic.groupCount() == 2 && matcherOperation.groupCount() == 1)
                || (matcherRoman.groupCount() == 2 && matcherOperation.groupCount() == 1)) {
            if (matcherArabic.find()) {
                a = matcherArabic.group(1);
                b = matcherArabic.group(2);
            }
            if (matcherRoman.find()) {
                a = matcherRoman.group(1);
                b = matcherRoman.group(2);
            }
            op = matcherOperation.group(1);

        } else {
            //createExeption("Не соответствует нужному виду");
        }
    }


    public Parser(String line) {



    }
}