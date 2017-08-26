package ch8_RecursionAndDyanamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	public static void main(String args[])
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(5);
		set.add(8);
		set.add(2);
		for(ArrayList<Integer> sets: getSubsets(set,0))
		{
			for(int i : sets)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		
		for(String s : getSubsets("abc"))
		{
			System.out.println(s);
		}
	}
	
	public static List<String> getSubsets(String s)
	{
		if(s == null)
		{
			return null;
		}
		List<String> subsets = new ArrayList<String>();
		if(s.length() == 0)
		{
			subsets.add("");
			return subsets;
		}
		return getSubsets(s , 0);
		
	}
	
	//solution for String
	//Time complexity is O(n2^n)
	public static List<String> getSubsets(String s, int index)
	{
		List<String> subsets = null;
		if(s.length() ==  index)
		{
			subsets = new ArrayList<String>();
			subsets.add("");
			return subsets;
		}
		List<String> sets = getSubsets(s, index+1);
		char ch = s.charAt(index);
		List<String> newsubsets = new ArrayList<String>();
		
		for(String str: sets)
		{
			newsubsets.add(str);
			newsubsets.add(ch+str);
		}
		return newsubsets;
		
	}
	
	//Book solution for integer of array
	//Time complexity is o(n2^n)
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
	{
		ArrayList<ArrayList<Integer>> allsubsets = null;
		if(set.size() == index)
		{
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else
		{
			allsubsets = getSubsets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets)
			{
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
}
