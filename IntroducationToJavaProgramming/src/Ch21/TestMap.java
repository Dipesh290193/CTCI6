package Ch21;

import java.util.*;

public class TestMap {

	public static void main(String args[])
	{
		Map<String, Integer> hashMap=new HashMap<>();
		hashMap.put("Dsp", 23);
		hashMap.put("Dipesh", 29);
		hashMap.put("Meet", 13);
		hashMap.put("Darshan", 5);
		hashMap.put("Sidd", 25);
		
		System.out.println("Hash Map Display:");
		System.out.print(hashMap+ "\n");
		for(Map.Entry<String, Integer> entry: hashMap.entrySet() )
		{
			System.out.print(entry.getKey()+" "+entry.getValue() +"\n");
		}
		
		Map<String, Integer> treeMap=new HashMap<>(hashMap);
		System.out.println("Tree Map Display");
		System.out.print(treeMap+"\n");
		
		Map<String, Integer> linkedMap=new LinkedHashMap<>();
		linkedMap.put("Dsp", 23);
		linkedMap.put("Dipesh", 29);
		linkedMap.put("Meet", 13);
		linkedMap.put("Darshan", 5);
		linkedMap.put("Sidd", 25);
		
		System.out.println("Linked Hash Map Display in insertion order");
		System.out.print(linkedMap+"\n");
		
		Map<String, Integer> linkedHashMap=new LinkedHashMap<>(16,0.75f,true);
		linkedHashMap.put("Dsp", 23);
		linkedHashMap.put("Dipesh", 29);
		linkedHashMap.put("Meet", 13);
		linkedHashMap.put("Darshan", 5);
		linkedHashMap.put("Sidd", 25);
		
		System.out.println("Birth date of Meet is "+linkedHashMap.get("Meet"));
		System.out.println("Linked Hash Map Display in accsess oreder");
		System.out.print(linkedHashMap+"\n");
		
		System.out.println("Size of Linked Hash Map: "+linkedHashMap.size());
		System.out.println("Remove from Liked Hash Map: "+linkedHashMap.remove("Meet"));
	}
}
