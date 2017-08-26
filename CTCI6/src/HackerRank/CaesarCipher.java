package HackerRank;

public class CaesarCipher {


    public static void main(String[] args) {
        String s = "abzZX2-V";
        int k = 2;
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray())
        {   
            if((int) c >= 65 && (int) c <= 90)
            {
                int en = (int) c + k;
                if( en > 90)
                {
                    en = (en - 90) + 64;
                }
                result.append((char)en);
            }
            else if((int) c >= 97 && (int) c <= 122)
            {
                int en = (int) c + k;
                if( en > 122)
                {
                    en = (en - 122) + 96;
                }
                result.append((char)en);
            }
            else
            {
                result.append(c);
            }
        }
        System.out.println(result.toString());
    }
}
