package HackerRank;

import java.util.*;
import java.util.stream.StreamSupport;

public class CommonChild {

    public static void main(String args[]){
        //commonString("ELGGYJWKTDHLXsJRBJLRYEJWVSUFZKYHOIKBGTVUTTOCGMLEXWDSXEBKRZTQUVCJNGKKRMUUBACVOEQKBFFYBUQEMYNENKYYGUZSP", "FRVIFOVJYQLVZMFBNRUTIYFBMFFFRZVBYINXLDDSVMPWSQGJZYTKMZIPEGMVOUQBKYEWEYVOLSHCMHPAZYTENRNONTJWDANAMFRX");
        System.out.println(commonChild2("FRVIFOVJYQLVZMFBNRUTIYFBMFFFRZVBYINXLDDSVMPWSQGJZYTKMZIPEGMVOUQBKYEWEYVOLSHCMHPAZYTENRNONTJWDANAMFRX","ELGGYJWKTDHLXJRBJLRYEJWVSUFZKYHOIKBGTVUTTOCGMLEXWDSXEBKRZTQUVCJNGKKRMUUBACVOEQKBFFYBUQEMYNENKYYGUZSP"));
    }

    public static int commonChild2(String s1, String s2){
        Set<Integer>[] sets = new Set[26];
        for(int i = 0 ; i < 26 ; i++){
            sets[i] = new LinkedHashSet<Integer>();
        }

        for(int i = 0 ; i < s2.length(); i++){
            sets[s2.charAt(i) - 'A'].add(i);
        }
        int maxCommon = 0;
        for(int i = 0 ; i < s1.length(); i++){
            int pointer = -1;
            int common = 0;
            for(int  j = i ; j < s1.length() && pointer < s1.length() -1; j++){
                if(sets[s1.charAt(j) - 'A'].size()>0){
                    for(int in : sets[s1.charAt(j)- 'A']){
                        if(in > pointer){
                            pointer = in;
                            common++;
                            break;
                        }
                    }
                }
            }
            if(common > maxCommon){
                maxCommon =common;
            }
        }
        return maxCommon;
    }

   public static int commonChild(String s1, String s2){
        // Complete this function
        int maxCommon = 0;
        for(int i = 0; i < s1.length(); i++){
            int common = 0;
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    common++;
                    for(int m = i+1; m < s1.length(); m++){
                        for(int n = j+1; n < s2.length(); n++){
                            if(s1.charAt(m) == s2.charAt(n)){
                                common++;
                                j = n;
                                break;
                            }
                        }
                    }
                }
            }
            if(common > maxCommon){
                maxCommon = common;
            }
        }
        return maxCommon;
    }

    public static void commonString(String s1, String s2){
       System.out.println("s1 lenghth"+ s1.length());
        boolean[] one = new boolean[26];
        boolean[] two = new boolean[26];
        for(int i = 0 ; i < s1.length(); i++){
            one[s1.charAt(i) - 'A'] = true;
        }
        String newS2= "";
        for(int i = 0 ; i < s2.length(); i++){
            if(one[s2.charAt(i) - 'A']){
                two[s2.charAt(i) - 'A'] = true;
                newS2 += s2.charAt(i);
            }
        }

        String newS1= "";
        for(int i = 0 ; i < s1.length(); i++){
            if(two[s1.charAt(i) - 'A']){
                newS1 += s1.charAt(i);
            }
        }
        System.out.println(newS1.length());
        System.out.println(newS1);
        System.out.println(newS2);

        System.out.println(commonChild(newS1,newS2));
    }

}
