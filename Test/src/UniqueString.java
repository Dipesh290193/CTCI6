import java.util.*;
public class UniqueString
{
	public static void main(String args[])
	{
		Scanner out=new Scanner(System.in);
		String str=out.next();
		System.out.println("Unique String is "+uniqueString(str));
		out.close();
	}
	
	public static String uniqueString(String str)
	{
	ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<str.length();i++)
		{
			if(!list.contains(String.valueOf(str.charAt(i))))
			{
				list.add(String.valueOf(str.charAt(i)));
			}
			for(int j=0;i>j;j++)
			{
				if(!list.contains(str.substring(j,i+1)))
				{
					list.add(str.substring(j,i+1));
				}
			}
		}
		list.remove(str);
		int length=0;
		int index=0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).length()>length)
			{
				length=list.get(i).length();
				index=i;
			}
		}
		return list.get(index);
	}	
}