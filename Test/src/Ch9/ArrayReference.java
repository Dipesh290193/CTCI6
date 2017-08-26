package Ch9;

public class ArrayReference {

	public static void main(String args[])
	{
		int[] arr=new int[2];
		arr[0]=15;
		arr[1]=10;
		change(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
	}
	public static void change(int[] arr)
	{
		arr[0]=50;
		arr[1]=100;
	}
}
