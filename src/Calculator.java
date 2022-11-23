public class Calculator {
    private String str;

    public Calculator(String str){
        this.str = str;
    }

    public int findOperation(){
        int length = str.length();
        int nonNumbers[] = {};
        for (int i = 0; i < str.length(); i++){
            int plusIndex = str.indexOf("+");
            int minusIndex = str.indexOf("-");
            int multiplyIndex = str.indexOf("*");
            int divideIndex = str.indexOf("/");
        }
    }

}
