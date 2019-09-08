package Google;

import java.util.ArrayList;
import java.util.HashMap;

public class FindLongestWordInDirectory {

    public static void main(String args[]){
        String[] words = {"abxe", "blee", "aple", "bplee", "kangaroo"};
        System.out.println(findLogestWord("abppplee", words));
    }

    public static String findLogestWord(String s, String[] words){
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        String maxWord = "";
        for(String word: words){
            if(maxWord.length() < word.length()){
                int currentIndex = -1;
                int i = 0;
                for(; i < word.length(); i++){
                    char c = word.charAt(i);
                    if(map.containsKey(c) && map.get(c).size() > 0){
                        int index = findFirstMaxIndex(map.get(c),currentIndex);
                        if(index == -1){
                            break;
                        }
                        else{
                            currentIndex = index;
                        }
                    }
                    else{
                        break;
                    }
                }
                if( i >= word.length()){
                    maxWord = word;
                }
            }
        }
        return  maxWord;
    }

    public static int findFirstMaxIndex(ArrayList<Integer> array, int target){
        if(array != null && array.size() > 0)
            return findFirstMaxIndex(array,0,array.size()-1,target);
        return -1;
    }

    public static int findFirstMaxIndex(ArrayList<Integer> array, int start, int end, int target){
        if(start > end)
            return  -1;
        int mid = (start+end)/2;
        int value = -1;
        if(array.get(mid) < target){
            value = findFirstMaxIndex(array,mid+1,end,target);
        }
        else if(array.get(mid) > target){
            value = findFirstMaxIndex(array,start,mid-1, target);
        }
        if(value == -1 && array.get(mid)>target){
            return mid;
        }
        return value;
    }
}