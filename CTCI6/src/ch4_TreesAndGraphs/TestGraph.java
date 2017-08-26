package ch4_TreesAndGraphs;

public class TestGraph {

	public static void main(String[] args)
	{
		UndirectedGraph<Character> g = new UndirectedGraph<>();
		Node<Character> a = new Node<Character>('a');
		Node<Character> b = new Node<Character>('b');
		Node<Character> c = new Node<Character>('c');
		Node<Character> d = new Node<Character>('d');
		Node<Character> e = new Node<Character>('e');
		Node<Character> f = new Node<Character>('f');
		
		g.addNode(a);
		g.addNode(b);
		g.addNode(c);
		g.addNode(d);
		g.addNode(e);
		g.addNode(f);
		/*Edge ab = new Edge(a, b, 7);
		Edge ac = new Edge(a, c, 9);
		Edge af = new Edge(a, f, 14);
		Edge cf = new Edge(c, f, 2);
		Edge fe = new Edge(f, e, 9);
		Edge bc = new Edge(b, c, 10);
		Edge ed = new Edge(e, d, 6);
		Edge cd = new Edge(c, b, 11);
		Edge bd = new Edge(b, d, 15);
		*/
		g.addEdge(a, b, 7);
		g.addEdge(a, c, 9);
		g.addEdge(a, f, 14);
		g.addEdge(c, f, 2);
		g.addEdge(f, e, 9);
		g.addEdge(b, c, 10);
		g.addEdge(e, d, 6);
		g.addEdge(c, b, 11);
		g.addEdge(b, d, 15);
		
		System.out.println(g.DFS(a, d));
		
		
	}
}
