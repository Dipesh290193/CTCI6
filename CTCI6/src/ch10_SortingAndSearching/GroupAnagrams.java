package ch10_SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {

	public static void main(String args[])
	{
		String[] array = {"meet","abcd","acdb","abc","eemt","cab",};
		sort(array);
		for(String s: array)
		{
			System.out.println(s);
		}
	}
	
	
	//Time Complexity is O(n^3) & Space complexity is O(MaxStringLength)
	public static void sortAnagram(String[] array)
	{
		
		for(int i = 0; i< array.length-1; i++)
		{	
			for(int j = i+1; j<array.length;j++)
			{
				if(isAnagram(array[i], array[j]))
				{
					swap(array,++i,j);
				}
			}
		}
	}
	
	public static boolean isAnagram(String s1, String s)
	{
		if(s1.length() != s.length())
			return false;
	
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : s1.toCharArray())
		{
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c)+1);
		}
		
		for(char c: s.toCharArray())
		{
			if(!map.containsKey(c))
				return false;
			else
			{
				map.put(c, map.get(c)-1);
				if(map.get(c) <= 0)
					map.remove(c);
			}
		}
		return map.size() == 0;
	}
	
	public static void swap(String[] array, int i , int j)
	{
		String temp = array[i];
		array[i] = array[j];
		array[j] =temp;
	}
	
	
	///Time complexity is O(n^2logn), Space complexity is O(n)
	public static void sort(String[] array)
	{
		HashMap<String, ArrayList<String>> mapList = new HashMap<String, ArrayList<String>>();
		for(String s: array)
		{
			String key = sortChars(s);
			if(!mapList.containsKey(key))
			{
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				mapList.put(key, list);
			}
			else
			{
				mapList.get(key).add(s);
			}
		}
		
		int index = 0;
		for(String key: mapList.keySet())
		{
			ArrayList<String> list = mapList.get(key);
			for(String s: list)
			{
				array[index] = s;
				index++;
			}
		}
	}
	public static String sortChars(String s)
	{
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
}
