import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringSpace {

	public static void main(String arsg[])
	{
		Map<String, Directory> maps=new HashMap<>();
		Scanner in= new Scanner(System.in);
		String s=in.nextLine();
		String[] arrStr=s.split("\n");
		String parent="";
		for(String str:arrStr)
		{
			if(str.contains("dir"))
			{
				int level=str.length()-str.trim().length();
				if(level==0)
				{
					parent+=str.trim()+"/";
				}
				maps.put(level+str.trim(), new Directory(level,parent));
			}
			else
			{
				//int level=
			}
		}
	}
	
	public static void getMin(String result, int length, String[] arr)
	{
		
	}
}
 class Directory
{
	int level;
	String name;
	
	public Directory(int level, String name) {
		this.level=level;
		this.name=name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
