
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Введите выражение вида \"число\" \"операция\" \"число\" ");
        String line = scnr.nextLine();
        System.out.println(parse(line).print());
    }

    public static Exp parse(String line) {
        //Exp expression = new Exp();

        String a;
        String b;
        String op;
        String type;
        //String line;
        Pattern arabic = Pattern.compile("([1-9]|10)");
        Pattern roman = Pattern.compile("(I|II|III|IV|V|VI|VII|VIII|IX|X){1}");
        Pattern operation = Pattern.compile("\\+|-|\\*|/");
        Pattern arabicExpression = Pattern.compile("^([1-9]|10)(\\s)+(\\+|-|\\*)(\\s)+([1-9]|10)$");
        Pattern romanExpression = Pattern.compile("^(I|II|III|IV|V|VI|VII|VIII|IX|X){1}(\\s)+(\\+|-|\\*|/){1}(\\s)+(I|II|III|IV|V|VI|VII|VIII|IX|X){1}$");
        final String regex = "([1-9]|10){1}(\\s)+(\\+|-|\\*|\\/){1}(\\s)+([1-9]|10){1}";

        Matcher matcherArabic = arabic.matcher(line);
        Matcher matcherRoman = roman.matcher(line);
        Matcher matcherOperation = operation.matcher(line);
        Matcher matcherArabicExp = arabicExpression.matcher(line);
        Matcher matcherRomanExp = romanExpression.matcher(line);
        System.out.println("start");

        if (matcherArabicExp.find() || matcherRomanExp.find()) {
            if (matcherArabic.find()) {
                type = "arabic";
                a = matcherArabic.group();
                matcherArabic.find();
                b = matcherArabic.group();
                matcherOperation.find();
                op = matcherOperation.group();
                //System.out.printf("Number: %s Operation = %s Number b = %s Type = %s\n ", a, op, b, type);
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
                //System.out.printf("Number: %s Operation = %s Number b = %s Type = %s\n ", a, op, b, type);
                Exp exp = new Exp(a, b, op, type);
                return exp;
            }

        } else {
            System.out.println("Выражение не соответствует нужному виду");
        }

        Exp exp = new Exp("1","1","1","1");
        return exp;

    }

    public static Result Execute (Exp exp){
        String a = exp.getNumberA();
        String b = exp.getNumberB();
        String op = exp.getOperation();
        String type = exp.getNumberType();
        //int aNum = Integer.parseInt(a);
        //int bNum = Integer.parseInt(b);

        int numberA;
        int numberB;
        double result;
        if(type.equals("roman")){
           numberA = getRoman(a);
           numberB = getRoman(b);
           result = operate(numberA,numberB,op);
           if(result%1==0){
               Result res = new Result(result,type);
           } else {
               Result res = new Result(a +"/"+b,type);
           }
        }
        if(type.equals("arabic")){
            numberA = Integer.parseInt(a);
            numberB = Integer.parseInt(b);
            result = operate(numberA,numberB,op);
            if(result%1==0){
                Result res = new Result(result,type);
            } else {
                Result res = new Result(a +"/"+b,type);
            }
        }


        return new Result();
    }

    public static double operate (int a, int b, String op){
        double result = 0;
        switch(op){
            case "+": {result = a + b; break;}
            case "-": {result = a - b; break;}
            case "*": {result = a * b; break;}
            case "/": {result = a / b; break;}

        }
        return result;
    }

    public static int getRoman (String romanNumber) {
        int def;
        switch(romanNumber){

            case "I": {def = 1; break;}
            case "II": {def = 2; break;}
            case "III": {def = 3; break;}
            case "IV": {def = 4; break;}
            case "V": {def = 5; break;}
            case "VI": {def = 6; break;}
            case "VII": {def = 7; break;}
            case "VIII": {def = 8; break;}
            case "IX": {def = 9; break;}
            case "X": {def = 10; break;}
            default : {
             // createException("Число должно находиться в диапазоне от I до X включительно.");
                def = 0;
                break;
            }
        }
        return def;

    }

}
