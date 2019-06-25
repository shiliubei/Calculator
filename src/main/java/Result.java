public class Result {

    int res;
    String resStr;
    String type;

    public Result() {

    }

    public Result(int result, String numberType) {
        res = result;
        type = numberType;
        //if ()

    }

    public Result(String result, String numberType) {
        resStr = result;
        type = numberType;
    }

    public String print(){
        return "Result = " + this.res+  "Type: " + this.type;
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
}
