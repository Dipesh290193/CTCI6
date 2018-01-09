package Test;

public class SortCharacterFrequency {
    public static void main(String args[]){
        System.out.println(frequencySort("tree"));
    }
    public static String frequencySort(String s) {
        int[] letters = new int[128];
        int maxCount = 0;
        for(char c: s.toCharArray()){

            letters[c]++;
            if(letters[c] > maxCount){
                maxCount = letters[c];
            }

        }
        StringBuilder sb = new StringBuilder();
        while(maxCount > 0){
            for(int i = 0; i < letters.length; i++){
                if(maxCount == letters[i]){
                    for(int j = 1 ; j<= maxCount; j++){
                        sb.append(Character.valueOf((char)i));
                    }
                }
            }
            maxCount--;
        }
        return sb.toString();
    }
}
