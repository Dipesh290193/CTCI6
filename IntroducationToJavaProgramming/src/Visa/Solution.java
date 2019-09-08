package src.Visa;

public class Solution {
    public static void main(String args[]){
        String rex = "[a-z]{1,6}([_]{0,1})([0-9]{0,4})@hackerrank.com";
        String str = "julia0_@hackerrank.com";
        System.out.print(str.matches(rex));
    }
}
