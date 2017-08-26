package ch4_TreesAndGraphs;

public class TestTries {

	public static void main(String args[])
	{
		Tries tree  = new Tries();
		tree.add("cat");
		tree.add("cap");
		tree.add("come");
		tree.add("count");
		tree.add("apple");
		tree.add("apply");
		tree.add("applied");
		tree.add("api");
		tree.add("bite");
		tree.add("bike");
		
		System.out.println(tree.isValidWord("app"));
	}
}
