package Test;

import java.util.ArrayList;
import java.util.List;

public class ExclusiveTime {

    public static void main(String args[]){
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:start:6");
        exclusiveTime(2,logs);
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] times = new int[n];
        for(int i = 0 ; i < logs.size(); i++){
            String[] log = logs.get(i).split(":");
            int id = Integer.parseInt(log[0]);
            int time = Integer.parseInt(log[2]);
            if(log[1].equals("start")){
                times[id] = time;
            }
            else if(log[1].equals("end")){
                times[id] = time - times[id];
            }
        }
        return times;
    }
}
