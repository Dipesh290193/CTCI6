package HackerRank;

public class MarsExploration {

	public static void main(String[] args) {
        String S = "SOSSPSSQSSOR";
        int changeLetters = 0;
       // int numberOfSOS = s.length()/3;
        String sos = "SOS";
        
        
        for(int i=0; i < S.length(); i++){
            for(int j = 0 ; j < sos.length(); j++ ){
                if(S.charAt(i) != sos.charAt(j)){
                    changeLetters++; 
                }
                 i++;
            }
        }
        
        System.out.println(changeLetters);
    }
}
