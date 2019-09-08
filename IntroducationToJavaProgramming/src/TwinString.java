package src;

import java.util.HashMap;
import java.util.*;

public class TwinString {
    public static void main(String args[]) {
        String[] a = {"cdabab"};
        String[] b = {"abcdab"};
        /*for(String s : isTwinString(a,b)){
            System.out.print(s);
        }*/
        int i = Integer.MAX_VALUE;
        int mid = 1 + (i - 1)/2;
        System.out.print(mid);

    }

    public static String[] isTwinString(String[] a, String[] b) {
        int length = a.length;
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            if (a[i].length() != b[i].length()) {
                result[i] = "No";
                break;
            }
            Map<Character, Integer> oddMap = new HashMap<>();
            Map<Character, Integer> evenMap = new HashMap<>();
            for (int j = 0; j < a[i].length(); j++) {
                //Process String One
                if (j % 2 == 0) {
                    Character evenChar = a[i].charAt(j);
                    Integer evenCount = evenMap.get(evenChar);
                    if (evenCount == null || evenCount == 0) {
                        evenMap.put(evenChar, 1);
                    } else {
                        evenMap.put(evenChar, evenCount + 1);
                    }
                } else {
                    Character oddChar = a[i].charAt(j);
                    Integer oddCount = oddMap.get(oddChar);
                    if (oddCount == null || oddCount == 0) {
                        oddMap.put(oddChar, 1);
                    } else {
                        oddMap.put(oddChar, oddCount + 1);
                    }
                }
            }

            for (int k = 0; k < b[i].length(); k++) {
                if (k % 2 == 0) {
                    Character evenChar = b[i].charAt(k);
                    Integer evenCount = evenMap.get(evenChar);
                    if (evenCount == null || evenCount == 0) {
                        result[i] = "No";
                        break;
                    } else if (evenCount == 1) {
                        evenMap.remove(evenChar);
                    }else{
                        evenMap.put(evenChar, evenCount-1);
                    }
                } else {
                    Character oddChar = b[i].charAt(k);
                    Integer oddCount = oddMap.get(oddChar);
                    if (oddCount == null || oddCount == 0) {
                        result[i] = "No";
                        break;
                    } else if (oddCount == 1) {
                        oddMap.remove(oddChar);
                    }else{
                        oddMap.put(oddChar, oddCount-1);
                    }
                }
            }
            if(oddMap.size() == 0 && evenMap.size() ==0 ){
                result[i] = "Yes";
            }
        }
        return result;
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        // WRITE YOUR CODE HERE
        //ArrayList<ArrayList<Integer>> visited = new ArrayList<ArrayList<Integer>>();
        Boolean[][] visited = new Boolean[numRows][numColumns];
        LinkedList<ArrayList<Integer>> queue= new LinkedList<ArrayList<Integer>>();
        queue.add(new ArrayList<>(Arrays.asList(new Integer[]{0,0,0})));
        //visited.(0).get(0) = true;
        while(queue.size() != 0){
            ArrayList<Integer> current = queue.removeFirst();
            int row = current.get(0);
            int column = current.get(1);
            int level = current.get(2);
            if(area.get(row).get(column) == 9){
                return level;
            }
            if(visited[row][column]){
                visited[row][column] = true;
                //visited.get(row).get(column) = true;
                if(row > 0 && area.get(row-1).get(column) == 1){
                    //queue.add(Arrays.asList({row-1,column, level+1}));
                    queue.add(new ArrayList<>(Arrays.asList(new Integer[]{row-1,column, level+1})));
                }
                if(row < numRows-1 && area.get(row+1).get(column) == 1){
                    //queue.add(Arrays.asList({row+1,column, level+1}));
                    queue.add(new ArrayList<>(Arrays.asList(new Integer[]{row+1,column, level+1})));
                }
                    if(column > 0 && area.get(row).get(column -1) == 1){
                        //queue.add(Arrays.asList({row,column-1,level+1}));
                        queue.add(new ArrayList<>(Arrays.asList(new Integer[]{row,column-1,level+1})));
                    }
                    if(column < numColumns-1 && area.get(row).get(column+1) == 1){
                        //queue.add(Arrays.asList({row,column+1, level+1}));
                        queue.add(new ArrayList<>(Arrays.asList(new Integer[]{row,column+1, level+1})));
                    }
                }
            }
            return  -1;
        }
}
