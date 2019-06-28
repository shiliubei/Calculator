package calculator;

import java.util.Objects;

public class Result {

    int res;
    String resStr;
    String type;

    public Result() {

    }

//    public Result(int result, String numberType) {
//        res = result;
//        type = numberType;
//        //if ()
//
//    }

    public Result(String result, String numberType) {
        resStr = result;
        type = numberType;
    }

    public String print(){
        return "calculator.Result = " + this.resStr+  "Type: " + this.type;
    }



    public int getRes() {
        return res;
    }

    public String getResStr() {
        return resStr;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result = (Result) o;
        return Objects.equals(resStr, result.resStr) && Objects.equals(type, result.type);
    }
}
