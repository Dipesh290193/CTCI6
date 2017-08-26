package Ch19;

public class GenericSort {

	public static void main(String args[])
	{
		String[] str={"Dipesh","Malav","meet","Abc","z","1"};
		Integer[] in={1,123,145,1000,0,-1};
		System.out.println("Before sort");
		print(str);
		System.out.println();
		System.out.println("Integer");
		print(in);
		sort(str);
		sort(in);
		System.out.println();
		System.out.println("After Sort String");
		print(str);
		System.out.println();
		System.out.println("After Sort Integer");
		print(in);
	}
	//Time Complexity O(n^2)
	public static <E extends Comparable<E>> void sort(E[] list)
	{
		E currentmin;
		int currentminindex;
		
		for(int i=0;i<list.length-1;i++)
		{
			currentmin=list[i];
			currentminindex=i;
			for(int j=i+1;j<list.length;j++)
			{
				if(currentmin.compareTo(list[j])>0)
				{
					currentmin=list[j];
					currentminindex=j;
				}
			}
			if(currentminindex != i)
			{
				list[currentminindex]=list[i];
				list[i]=currentmin;
			}
		}
	}
	public static <E> void print(E[] list)
	{
		for(int i=0;i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}
	}
}
