package calculator;

public class Exp {
    private String numberA;
    private String numberB;
    private String operation;
    private String numberType;



    public Exp() {

    }

    public Exp(String a, String b, String op, String type) {
        numberA = a;
        numberB  = b;
        operation = op;
        numberType = type;
    }

    public String getNumberB() {
        return numberB;
    }

    public String getOperation() {
        return operation;
    }

    public String getNumberType() {
        return numberType;
    }

    public String getNumberA() {
        return numberA;
    }

    public String print(){
        return "Number a = " + this.numberA+ "Operation = " + this.operation + "Number b =" + this.numberB + "Type: " + this.numberType;
    }

    //public

}
