import java.util.*;

public class CompressString {

	public static void main(String args[])
	{
		Scanner out = new Scanner(System.in);
		String str=out.next();
		compressString(str);
		out.close();
	}
	
	public static void compressString(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)>0 && str.charAt(i)<=9)
			{
				int j=str.charAt(i);
				while(j>1)
				{
					System.out.print(str.charAt(i+1));
					j--;
				}
			}
			System.out.print(str.charAt(i));
		}
		
	}
}
