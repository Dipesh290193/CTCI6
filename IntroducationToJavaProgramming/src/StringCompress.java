package src;

import java.util.Scanner;

public class StringCompress {
	
	public static void main(String args[])
	{
		Scanner out=new Scanner(System.in);
		System.out.println("Enter String");
		String str=out.next();
		char[] arr=str.toCharArray();
		StringBuilder result1=new StringBuilder();
		for(int i=0;i<arr.length;i++)
		{		
			int count=1;
			while(arr.length-1>i && arr[i]==arr[i+1])
			{
				count++;
				i++;
			}
			result1.append( String.valueOf(arr[i])+count);
		}
		System.out.println(result1);
		out.close();
	}
	
}
