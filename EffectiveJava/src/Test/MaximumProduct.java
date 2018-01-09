package Test;

import java.util.HashSet;
import java.util.Set;

public class MaximumProduct {
    public static void main(String args[]){
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(words));
    }
    public static int maxProduct(String[] words) {
        Set<Integer>[] count = new Set[26];
        for(int i = 0 ; i < words.length ; i++){
            for(char c: words[i].toCharArray()){
                if(count[c - 'a']==null){
                    count[c -'a']= new HashSet<Integer>();
                }
                count[c - 'a'].add(i);
            }
        }
        int result = 0;

        for(int i = 0 ; i < words.length; i++){
            int j = 0, k = i+1;
            for(; j < words[i].length(); ){
               for(;j < words[i].length() && k < words.length;){
                   if(count[words[i].charAt(j) - 'a'].contains(k)){
                       k++;
                       j = 0;
                   }
                   else{
                       j++;
                   }
               }
            }

        }
        return result;
    }
}
