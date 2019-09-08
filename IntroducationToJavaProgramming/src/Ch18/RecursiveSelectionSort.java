package Ch18;

public class RecursiveSelectionSort {

	public static void main(String args[])
	{
		double[] list={1,0.5,0.25,2,2.5,0.2,3};
		sort(list);
		for(int i=0;i<list.length;i++)
		{
			System.out.print(list[i]+",");
		}
	}
	public static void sort(double[] list)
	{
		sort(list,0,list.length-1);
	}
	public static void sort(double[] list,int low,int high)
	{
		if(low<high)
		{
			int indexofMin=low;
			double min=list[low];
			for(int i=low+1;i<=high;i++)
			{
				if(list[i]<min)
				{
					indexofMin=i;
					min=list[i];
				}
			}
			list[indexofMin]=list[low];
			list[low]=min;
			sort(list,low+1,high);
		}
	}
}
