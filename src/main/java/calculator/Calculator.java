package calculator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Введите выражение вида \"число\" \"операция\" \"число\" ");
        String line = scnr.nextLine();
        Parser parser = new Parser();
        displayResult(execute(parser.parse(line)));
    }


    public static Result execute(Exp exp) {
        String a = exp.getNumberA();
        String b = exp.getNumberB();
        String op = exp.getOperation();
        String type = exp.getNumberType();
        Result res = new Result();
        double numberA;
        double numberB;
        Double result = 0d;

        if (type.equals("roman")) {
            numberA = fromRomanToArabic(a);
            numberB = fromRomanToArabic(b);
            result = operate(numberA, numberB, op);
            type = "roman";
            if (result % 1 == 0) {
                String resultStr = "";
                int resultInt = result.intValue();
                if(resultInt<0){
                    resultStr = "-"+getRoman(resultInt*-1);
                } else{
                    resultStr = getRoman(resultInt);
                }
                return  new Result(resultStr, type);
            } else {
                return  new Result(a + "/" + b,type );
            }
        }
        if (type.equals("arabic")) {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            result = operate(numberA, numberB, op);
            if (result % 1 == 0) {
                type = "arabic";
                int resultInt = result.intValue();

                return  new Result(resultInt+"", type);
            }
            {
                type = "arabic";
                return  new Result(a + "/" + b, type);
            }
        }


       return  res;
    }

    public static double operate(double a, double b, String op) {
        double result=5;
        switch (op) {
            case "+": {
                result = a + b;
                return result;
            }
            case "-": {
                result = a - b;
                return result;
            }
            case "*": {
                result = a * b;
                return result;
            }
            case "/": {
                result = a / b;
                return result;
            }

        }
        return result;
    }

    public static int fromRomanToArabic(String romanNumber) {
        int def;
        switch (romanNumber) {

            case "I": { def = 1; break; }
            case "II": { def = 2; break; }
            case "III": { def = 3; break; }
            case "IV": { def = 4; break; }
            case "V": { def = 5; break; }
            case "VI": { def = 6;break; }
            case "VII": { def = 7;break; }
            case "VIII": {
                def = 8;
                break;
            }
            case "IX": {
                def = 9;
                break;
            }
            case "X": {
                def = 10;
                break;
            }
            default: {
                def = 0;
                break;
            }
        }
        return def;

    }

    public static void displayResult(Result result) {
            System.out.println(result.getResStr());

    }

    public static String getRoman(int arabicNumber) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
            int matches = arabicNumber / entry.getValue();
            res += repeat(entry.getKey(), matches);
            arabicNumber = arabicNumber % entry.getValue();
        }
        return res;
    }

    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

}
