package src;

public class XlSheetColumnNumber {

	private static final char[] list={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static void main(String args[])
	{
		System.out.println(getColumn(2058));
	}
	public static String getColumn(int N)
	{
		try
		{
			String result="";
			int i,j;
			if(N<26)
			{
				return list[N-1]+result;
			}
			else if(N%26==0)
			{
				 i=(N/26)-1;
				 j=26;
				 result=list[j-1]+result;
				return getColumn(i)+result;
			}
			else
			{
				i=N/26;
				j=N-(26*i);
				result=list[j-1]+result;
				if(i>26)
				{
					return getColumn(i)+result;
				}
				result=list[i-1]+result;
			}
			return result;
		}
		catch(Exception e)
		{
			System.err.println("Number must be greater than 0");
			return null;
		}
	}
}
