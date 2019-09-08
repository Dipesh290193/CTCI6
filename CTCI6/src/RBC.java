import java.util.ArrayList;
import java.util.List;

public class RBC {

    public static void main(String args[]){
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(13);
        list.add(10);
        list.add(21);
        list.add(20);
        //list.add(6);

        System.out.print(moves(list));

    }

    public static int moves(List<Integer> a){
        int moves = 0;
        int start = 0;
        int end = a.size()-1;
        while(start < end){
            int startValue= a.get(start);
            int endValue = a.get(end);
            if(startValue % 2 != 0 && endValue % 2 == 0 ){
                a.set(start,endValue);
                a.set(end, startValue);
                moves++;
                start++;
                end--;
            }
            else if(startValue % 2 == 0 && endValue % 2 == 0){
                start++;
            }
            else if(startValue % 2 != 0 && endValue % 2 != 0)
            {
                end--;
            }
            else{
                start++;
                end--;
            }

        }
        return moves;
    }
}
