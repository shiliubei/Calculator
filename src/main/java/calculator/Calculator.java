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
        parser.parse(line).evaluate();
    }

}
