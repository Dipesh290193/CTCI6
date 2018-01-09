package Test;

import java.util.Stack;

public class EncodeString {

    public static void main(String args[]){
        decodeString("3[a]2[bc]");
    }

    public static String decodeString(String s) {
        Stack<Integer> k = new Stack<Integer>();
        Stack<String> encodes = new Stack<String>();
        String temp = "";
        for(int i = 0 ; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                String num = "";
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num+=s.charAt(i);
                    i++;
                }
                i--;
                k.push(Integer.parseInt(num));
            }
            else if(s.charAt(i) == '['){
                    encodes.push(temp);
                    temp="";
            }
            else if(s.charAt(i) == ']'){
                StringBuilder t = new StringBuilder(encodes.pop());
                int times =k.pop();
                while(times>0){
                    t.append(temp);
                    times--;
                }
                temp = t.toString();
            }

            else{
                temp+=s.charAt(i);
            }
        }
        return temp;
    }
}
