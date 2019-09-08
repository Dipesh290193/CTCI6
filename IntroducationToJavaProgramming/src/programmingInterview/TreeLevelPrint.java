package programmingInterview;

public class TreeLevelPrint {

	public static void main(String args[])
	{
		Tree t=new Tree(4);
		t.left=new Tree(2);
		t.left.left=new Tree(1);
		t.left.right=new Tree(3);
		t.right=new Tree(6);
		t.right.left=new Tree(5);
		t.right.right=new Tree(7);
		
		PrintTreeLevel(t, 0, 2);
	}
	public static void PrintTreeLevel(Tree t, int currentLvl,int desireLvl)
	{
		if(t==null || currentLvl > desireLvl)
			return;
		if(currentLvl == desireLvl)
		{
			System.out.print(t.value+ " ");
		}
		else
		{
			PrintTreeLevel(t.left, currentLvl+1, desireLvl);
			PrintTreeLevel(t.right,currentLvl+1,desireLvl);
		}
	}
}


