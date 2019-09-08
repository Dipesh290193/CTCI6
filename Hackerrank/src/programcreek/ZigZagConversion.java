package programcreek;

public class ZigZagConversion {

    public static void main(String arghs[]){
        //System.out.println(zigzag("PAYPALISHIRING",3));
        Integer  i = new Integer(5);
        change(i);
        System.out.println(i);
    }

    public static void change(Integer i){
       i = 7;
    }

    public static String zigzag(String input, int row){
        if(input==null || input.length()== 1||row == 1){
            return input;
        }
        StringBuilder[] results = new StringBuilder[row];
        for(int i = 0 ; i <results.length;i++ ){
            results[i] = new StringBuilder();
        }
        int index=0;
        boolean forward = true;
        for(char c: input.toCharArray()){
            results[index] = results[index].append(c);
            if(forward && index < row){
                index++;
                if(index >= row){
                    index = index-2;
                    forward=false;
                }
            }
            else if(!forward &&  index >= 0){
                index--;
                if(index < 0){
                    index=index+2;
                    forward=true;
                }
            }

        }

        StringBuilder result=new StringBuilder();
        for(StringBuilder r : results){
            result.append(r);
        }
        return result.toString();
    }
}
