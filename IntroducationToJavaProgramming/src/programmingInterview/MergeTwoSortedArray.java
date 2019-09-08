package programmingInterview;

import java.util.ArrayList;

public class MergeTwoSortedArray {

	public static void main(String args[])
	{
		ArrayList<Integer> a=new ArrayList<>();
		a.add(2);
		a.add(3);
		a.add(6);
		ArrayList<Integer> b=new ArrayList<>();
		b.add(2);
		b.add(2);
		b.add(2);
		b.add(4);
		b.add(7);
		b.add(9);
		merge(a, b);
		System.out.println(b.toString());
	}
	public static void merge(ArrayList<Integer> a, ArrayList<Integer>  b)
	{
		for (Integer integer : a) {
			merge(b,integer,0,b.size()-1);
		}
	}
	public static void merge( ArrayList<Integer> b, int k, int start, int end)
	{
		if(start>end)
			return;
		if(k<=b.get(start))
		{
			b.add(0,k);
		}
		if(k>=b.get(end))
		{
			b.add(b.size(), k);
		}
		int	mid=(start+end)/2;
		if(k==b.get(mid))
			b.add(mid,k);
		if(k<b.get(mid))
			merge( b,k,start,mid-1);
		if(k>b.get(mid))
			merge( b, k, mid+1, end);
			
	}
}
