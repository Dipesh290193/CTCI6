package ch4_TreesAndGraphs;
import java.util.HashMap;

class TriesNode
{
	char ch;
	HashMap<Character, TriesNode> childrens;
	boolean isComplete;
	
	TriesNode(char ch)
	{
		this.ch =ch;
		childrens = new HashMap<>();
		this.isComplete = false;
	}
	
}

public class Tries {

	TriesNode root;
	 
	public Tries()
	{
		root = new TriesNode('*');
	}
	
	public void addSenetence(String sentence)
	{
		for(String word:sentence.split(" ,!.-"))
		{
			add(word);
		}
	}
	
	public void add(String word)
	{
		TriesNode current = root;
		for(char ch: word.toCharArray())
		{
			if(current.childrens.get(ch) == null)
				current.childrens.put(ch, new TriesNode(ch));
			current = current.childrens.get(ch);
		}
		
		current.isComplete =true;
	}
	
	public int getNumberOfWords(String str)
	{
		TriesNode current = root;
		for(char ch: str.toCharArray())
		{
			if(current.childrens.get(ch) == null)
				return 0;
			else
				current = current.childrens.get(ch);
		}
		
		return current.isComplete ? 1: 0 + getNumberOfWords(current);
	}
	
	private int getNumberOfWords(TriesNode node)
	{
		if(node.isComplete && node.childrens.size() == 0)
			return 1;
		int words =0;
		for(TriesNode n : node.childrens.values())
		{
			words += n.isComplete?1:0 + getNumberOfWords(n);
		}
		return words;
	}
	
	public boolean isValidPrefix(String prefix)
	{
		return lookup(prefix) != null;
	}
	
	private TriesNode lookup(String str)
	{
		TriesNode current = root;
		for(char ch: str.toCharArray())
		{
			if(current.childrens.get(ch) == null)
				return null;
			current = current.childrens.get(ch);
		}
		return current;
	}
	
	public boolean isValidWord(String word)
	{
		TriesNode leaf = lookup(word);
		return leaf == null ? false: leaf.isComplete;
	}
}
