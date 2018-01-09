package Test;

public class DeteleString {
    public static  void main(String args[]){
        minDistance("sea","ate");
    }
    public static int minDistance(String word1, String word2) {
        int[] count =new int[26];
        for(char c : word1.toCharArray()){
            count[c - 'a']++;
        }
        int diff = 0;
        int common = 0;
        for(char c: word2.toCharArray()){
            count[c - 'a']--;
            if(count[c -'a']< 0){
                diff++;
            }
            else{
                common++;
            }
        }
        return diff+(word1.length()-common);

    }
}
