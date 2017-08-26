package Ch21;

import java.util.*;

public class MapTest {

	public static void main(String args[])
	{
		Map<String, String> map=new LinkedHashMap<>();
		map.put("112", "Dsp");
		map.put("123", "Dipesh");
		map.put("112", "Dkp");
		map.put("143","dsp");
		System.out.println(map);
		System.out.println("Tree Map Display"+new TreeMap<String, String>(map));
	}
}
