package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFiles {

    public static void main(String args[]){

        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> result =findDuplicate(paths);
        for(List<String> r : result){
            for(String s: r){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String path: paths){
            String[] directory = path.split(" ");
            String directoryPath = directory[0]+"/";
            for(int i = 1; i < directory.length ;i ++){
                String[] fileName = directory[i].split("\\(");
                String content = fileName[1];
                if(map.containsKey(content)){
                    map.get(content).add(directoryPath+fileName[0]);
                }
                else{
                    List<String> p = new ArrayList<>();
                    p.add(directoryPath+fileName[0]);
                    map.put(content,p);
                }
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(List<String> duplicates: map.values()){
            result.add(duplicates);
        }
        return result;
    }
}
