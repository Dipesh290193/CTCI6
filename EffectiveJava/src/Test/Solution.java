package Test;


import java.util.Stack;

public class Solution {

    public static void main(String args[]){
        String[] values= {"{}[]()","{[}]}","[{}]()","{{}}(()"};
        for(String s: braces(values)){
            System.out.println(s);
        }
    }

    public static String[] braces(String[] values){
        String[] result = new String[values.length];
        for(int i = 0 ; i < values.length; i++){
            result[i] = isBalance(values[i]);
        }
        return result;
    }

    public static String isBalance(String s){
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return "NO";
                }
                char close = stack.pop();
                if(c == ')' &&  close != '('){
                    return  "NO";
                }
                else if(c == '}' &&  close != '{'){
                    return "NO";
                }
                else if(c == ']' &&  close != '['){
                    return "NO";
                }
            }
        }
        if(!stack.isEmpty()){
            return "NO";
        }
        return "YES";
    }
}
