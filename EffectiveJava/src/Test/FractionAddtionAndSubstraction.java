package Test;

public class FractionAddtionAndSubstraction {

    public static void main(String args[]){
        System.out.println(fractionAddition("1/3-1/2"));
    }

    public static String fractionAddition(String expression) {
        if(expression == null || expression.length() == 0){
            return "";
        }
        String result = null;
        String second = "";
        char op = '\u0000';
        for(int i = 0; i< expression.length(); i++){
            if((expression.charAt(i) == '+' || expression.charAt(i) == '-') && i != 0){
                if(result == null){
                    result = second;
                    op = expression.charAt(i);
                    second = "";
                }
                else{
                    String[]  firstNums = result.split("/");
                    String[] secondNums = second.split("/");
                    result = fractionCompute(Integer.parseInt(firstNums[0]), Integer.parseInt(firstNums[1]), Integer.parseInt(secondNums[0]),Integer.parseInt(secondNums[1]), op);
                    op = expression.charAt(i);
                    second = "";
                }
            }
            else{
                second+=expression.charAt(i);
            }
        }
        if(result == null){
            return second;
        }
        String[]  firstNums = result.split("/");
        String[] secondNums = second.split("/");
        return fractionCompute(Integer.parseInt(firstNums[0]), Integer.parseInt(firstNums[1]), Integer.parseInt(secondNums[0]),Integer.parseInt(secondNums[1]), op);

    }

    public static String fractionCompute(int firstNum, int firstDemo, int secondNum, int secondDemo, char op){
        int resultNum = 0;
        if(op == '+'){
            resultNum = (firstNum * secondDemo) + (secondNum * firstDemo);
        }
        else{
            resultNum = (firstNum * secondDemo) - (secondNum * firstDemo);
        }
        int demo = firstDemo * secondDemo;
        int gcd = GCD(demo, Math.abs(resultNum));

        return (resultNum/gcd)+"/"+(demo/gcd);
    }

    public static int GCD(int i, int j){
        if(j == 0){
            return i;
        }
        return GCD(j, i%j);
    }
}
