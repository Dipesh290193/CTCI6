package Ch27;

public class TestMyHashMap {
	
	public static void main(String args[])
	{
		MyMap<String, Integer> map=new MyHashMap<>();
		map.put("Dipesh", 23);
		map.put("Darshan", 27);
		map.put("Dsp", 24);
		map.put("Sidd", 22);
		map.put("Vish", 26);
		
		System.out.println("Entries in the map"+map);
		System.out.println("Age of darshan is "+map.get("Darshan"));
		System.out.println("Age of darshan is "+map.get("darshan"));
		System.out.println("Is Dsp in the map? "+map.containsKey("Dsp"));
		System.out.println("Is age 26 in the map? "+map.containsValue(26));
		map.remove("Sidd");
		System.out.println("After removing the Sidd"+map);
		map.clear();
		System.out.println(map);
	}

}
