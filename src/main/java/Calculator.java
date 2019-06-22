
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Введите выражение вида \"число\" \"операция\" \"число\" ");
        String line = scnr.next();
        Parser parser = new Parser(line);
    }
}
