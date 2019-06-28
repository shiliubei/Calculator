package calculator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Expression {
    private String numberA;
    private String numberB;
    private String operation;
    private String numberType;

    public Expression(String a, String b, String op, String type) {
        numberA = a;
        numberB = b;
        operation = op;
        numberType = type;
    }
    public Expression() {
    }

    public void execute() {
        double numA;
        double numB;
        Double result = 0d;

        if (numberType.equals("roman")) {
            numA = fromRomanToArabic(numberA);
            numB = fromRomanToArabic(numberB);
            result = operate(numA, numB, operation);
            numberType = "roman";
            if (result % 1 == 0) {
                String resultStr = "";
                int resultInt = result.intValue();
                if (resultInt < 0) {
                    resultStr = "-" + getRoman(resultInt * -1);
                } else {
                    resultStr = getRoman(resultInt);
                }
                System.out.println(resultStr);
            } else {
                System.out.println(numberA + "/" + numberB);
            }
        }
        if (numberType.equals("arabic")) {
            numA = Double.parseDouble(numberA);
            numB = Double.parseDouble(numberB);
            result = operate(numA, numB, operation);
            if (result % 1 == 0) {
                int resultInt = result.intValue();
                System.out.println(resultInt);
            } else {
                System.out.println(numberA + "/" + numberB);
            }
        }
    }

    private double operate(double a, double b, String op) {
        double result = 0;
        switch (op) {
            case "+": { result = a + b; return result; }
            case "-": { result = a - b; return result; }
            case "*": { result = a * b; return result; }
            case "/": { result = a / b; return result; }
        }
        return result;
    }

    private int fromRomanToArabic(String romanNumber) {
        int def;
        switch (romanNumber) {
            case "I": { def = 1; break; }
            case "II": { def = 2; break; }
            case "III": { def = 3; break; }
            case "IV": { def = 4; break; }
            case "V": { def = 5; break; }
            case "VI": { def = 6; break; }
            case "VII": { def = 7; break; }
            case "VIII": { def = 8; break; }
            case "IX": { def = 9; break; }
            case "X": { def = 10; break; }
            default: { def = 0; break; }
        }
        return def;
    }

    private String getRoman(int arabicNumber) {
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

    private String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Expression expression = (Expression) o;
        return Objects.equals(numberA, expression.numberA)
                && Objects.equals(numberB, expression.numberB)
                && Objects.equals(operation, expression.operation)
                && Objects.equals(numberType, expression.numberType);
    }
}
