package HackerRank;

import java.util.Scanner;

public class CommentCode {

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
        while(in.hasNextLine())
        {
            String s = in.nextLine();
            if(s.startsWith("//"))
            {
                System.out.println(s);
            }
            else if(s.startsWith("/*"))
            {
                while(!s.endsWith("*/"))
                {
                	System.out.println(s);
                    s= in.nextLine();
                }
               System.out.println(s);
            }
        }
        in.close();
	}
}
