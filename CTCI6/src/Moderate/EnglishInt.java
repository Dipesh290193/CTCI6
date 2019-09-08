package Moderate;

import java.util.HashMap;
import java.util.Map;

public class EnglishInt {
    static String[] englishRep = {"", "Thousand ", "Million ", "Billion ", "Trillion "};
    static Map<Integer, String> numbers = new HashMap<>();
    static {
        numbers.put(0, "");
        numbers.put(1, "One ");
        numbers.put(2, "Two ");
        numbers.put(3, "Three ");
        numbers.put(4, "Four ");
        numbers.put(5, "Five ");
        numbers.put(6, "Six ");
        numbers.put(7, "Seven ");
        numbers.put(8, "Eight ");
        numbers.put(9, "Nine ");
        numbers.put(10, "Ten ");
        numbers.put(11, "Eleven ");
        numbers.put(12, "Twelve ");
        numbers.put(13, "Thirteen ");
        numbers.put(14, "Fourteen ");
        numbers.put(15, "Fifteen ");
        numbers.put(16, "Sixteen ");
        numbers.put(17, "Seventeen ");
        numbers.put(18, "Eighteen ");
        numbers.put(19, "Nineteen ");
        numbers.put(20, "Twenty ");
        numbers.put(30, "Thirty ");
        numbers.put(40, "Forty ");
        numbers.put(50, "Fifty ");
        numbers.put(60, "Sixty ");
        numbers.put(70, "Seventy ");
        numbers.put(80, "Eighty ");
        numbers.put(90, "Ninety ");
    }

    public static void main(String args[]){
        int i = Integer.MAX_VALUE + Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
    }
    public static String englishInt(int number){
        if(number == 0){
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (number > 0){
            result = getHundred(number % 1000).append(" "+englishRep[index]).append(result);
            number = number/1000;
            index++;
        }
        return result.toString();
    }

    public static StringBuilder getHundred(int hundrednumber){
        StringBuilder result = new StringBuilder();
        if(hundrednumber == 0){
            return result;
        }
        if(hundrednumber  >= 100){
            int number = hundrednumber/100;
            result.append(numbers.get(number));
            result.append("Hundred");
        }

        int ten = hundrednumber % 100;
        if(ten == 0)
            return result;
        if(ten > 19){
            int digit  = ten / 10;
            result.append(numbers.get(digit*10));
            result.append(numbers.get(ten%10));
        }
        else{
            result.append(numbers.get(ten));
        }
        return result;
    }
}
