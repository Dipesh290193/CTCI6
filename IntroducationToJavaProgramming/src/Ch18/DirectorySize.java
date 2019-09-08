package Ch18;

import java.io.File;
import java.util.Scanner;

public class DirectorySize {
	
	public static void main(String args[])
	{
		System.out.println("Enter Directory path");
		Scanner out=new Scanner(System.in);
		String directory=out.nextLine();
		System.out.println(getSize(new File(directory))+" bytes");
		out.close();
	}
	public static long getSize(File file)
	{
		long size=0;
		if(file.isDirectory())
		{
			File[] files=file.listFiles();
			for(int i=0;files != null && i<files.length;i++)
			{
				size+=getSize(files[i]);
			}
		}
		else
		{
			size+=file.length();
		}
		return size;
	}

}
