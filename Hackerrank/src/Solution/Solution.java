package Solution;

public class Solution {

    public static void main(String args[]) {
        String i = "   -dd ";
        System.out.print(myAtoi("-1.4"));
    }

    public static String decode(String encoded){
        if(encoded == null || encoded.length() == 0 || encoded.length() == 1)
            return "";
        StringBuilder sb = new StringBuilder();
        for(int i = encoded.length()-1; i >= 0 ; i--){
            int code = Integer.parseInt(encoded.charAt(i)+""+encoded.charAt(--i));
            if((code > 0 && code < 32) || (code > 32 && code < 65) || (code > 90 && code <97)){
                code = (code*10) + Character.getNumericValue(encoded.charAt(--i));
            }
            sb.append(Character.toString((char)code));
        }
        return sb.toString();
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0){
            return 0;
        }
        boolean negative = false;
        boolean firstNumber = false;
        boolean positive = false;
        String result = "";
        for(int i = 0; i < str.length() ; i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                result += Character.getNumericValue(c);
                if(Long.parseLong(result) > Integer.MAX_VALUE)
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                firstNumber = true;
            }
            else if((result.length() != 0 && c == '.'))
            {
                return negative? -Integer.parseInt(result): Integer.parseInt(result);
            }
            else if(c == '-' && !firstNumber){
                if(positive || negative)
                    return 0;
                else
                    negative = true;
            }
            else if(c == '+' && !firstNumber){
                if(negative || positive)
                    return 0;
                else
                    positive = true;
            }
            else{
                break;
            }
        }
        if(result.length() == 0){
            return 0;
        }
        return negative? -Integer.parseInt(result): Integer.parseInt(result);
    }
}
