package src;

import java.util.Scanner;

public class IsUniqueSring {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		isUniqueString(str);
		sc.close();	
	}
	private static void isUniqueString(String str)
	{
		String temp="";
		for(int i=0;i<str.length();i++)
		{
			String ch=Character.toString(str.charAt(i));
			if(temp.contains(ch))
			{
				System.out.println("Not unique");
				return;
			}
			else
			{
				temp+=ch;
			}
		}
		System.out.println("Unique");
	}
}
