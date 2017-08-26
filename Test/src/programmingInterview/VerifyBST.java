package programmingInterview;

class Tree
{
	public int value;
	public Tree left;
	public Tree right;
	public Tree(int value)
	{
		this.value=value;
		left=right=null;
	}
}
public class VerifyBST {

	public static void main(String args[])
	{
		Tree t=new Tree(4);
		t.left=new Tree(2);
		t.left.left=new Tree(1);
		t.left.right=new Tree(3);
		t.right=new Tree(6);
		t.right.left=new Tree(8);
		t.right.right=new Tree(7);
		
		System.out.println(isBST(t, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
	}
	public static boolean isBST(Tree t,int small, int large)
	{
		if(t==null)
			return true;
		if(t.value>small && t.value<large)
		{
			return isBST(t.left, small, t.value) && isBST(t.right,t.value,large);
		}
		else
		{
			return false;
		}
	}
	
}

