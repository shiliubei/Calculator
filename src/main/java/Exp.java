public class Exp {
    private String numberA;
    private String numberB;
    private String operation;
    private String numberType;



    public Exp() {

    }

    public Exp(String a, String b, String op, String type) {
        a = numberA;
        b = numberB;
        op = operation;
        type = numberType;
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
        return "Number a" + this.numberA+ "Operation = " + this.operation + "Number b =" + this.numberB + "Type" + this.numberType;
    }

    //public

}
