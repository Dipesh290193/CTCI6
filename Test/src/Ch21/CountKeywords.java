package Ch21;

import java.util.*;

public class CountKeywords {

	public static void main(String args[])
	{
		Scanner out=new Scanner(System.in);
		System.out.println("Enter Java KeyWord");
		String str=out.nextLine();
		String[] keywords={"abstract","static","boolean","public"};
		
		//Set<String> keywordSet=new HashSet<>(Arrays.asList(keywords));
		String[] input=str.split(" ");
		//List<String> list=new ArrayList<>(Arrays.asList(keywords));
		Set<String> set=new LinkedHashSet<>(Arrays.asList(keywords));
		int count =0;
		for(int i=0;i<input.length;i++)
		{
			String word=input[i];
			if(set.contains(word))
			{
				count++;
			}
		}
		System.out.println("Total keywords: "+count);
		out.close();
	}
}
