package calculator;

import java.util.Objects;

public class Exp {
    private String numberA;
    private String numberB;
    private String operation;
    private String numberType;


    public Exp() {

    }

    public Exp(String a, String b, String op, String type) {
        numberA = a;
        numberB = b;
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

    public String print() {
        return "Number a = " + this.numberA + "Operation = " + this.operation + "Number b =" + this.numberB + "Type: " + this.numberType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Exp exp = (Exp) o;
        return Objects.equals(numberA, exp.numberA) && Objects.equals(numberB, exp.numberB);
    }

//    @Override
//    public boolean equals(Object obj) {
//       if (obj == this) {
//            return true;
//        }
//       if (obj == null || obj.getClass() != this.getClass()) {
//            return false;
//        }
//
//        Exp exp = (Exp) obj;
//        return numberA == exp.numberA && operation == exp.operation && numberB == exp.numberB
////                && (numberB == exp.numberB
////                || (numberB != null && numberB.equals(exp.getNumberA())))
////                && (operation == exp.operation
////                || (operation != null && operation.equals(exp.getOperation())
//                //&& (numberType == exp.numberType
//                //|| (numberType != null && numberType.equals(exp.getNumberType())))
//       // ))
//        ;


    //}

    //public

}
