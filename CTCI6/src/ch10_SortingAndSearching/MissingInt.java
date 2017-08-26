package ch10_SortingAndSearching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingInt {

	public static void main(String args[])
	{
		
	}
	
	public static int missingInt(String fileName) throws FileNotFoundException
	{
		int[] bv = new int[(Integer.MAX_VALUE)+1/32];
		Scanner in = new Scanner(new FileReader(fileName));
		while(in.hasNextInt())
		{
			int i = in.nextInt();
			bv[i>>5] |= 1<<(i%32);
		}
		
		for(int i = 0; i < bv.length; i++)
		{
			for(int j = 0; j < 32; j++)
			{
				if((bv[i] & (1<<j))==0)
				{
					return i*32 + j;
				}
			}
		}
		return -1;
	}
}
