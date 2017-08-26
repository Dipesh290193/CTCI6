package KruskalMST;

import java.util.*;

public class KruskalAlgo {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		List<Edge> edges = new ArrayList<Edge>();
		for(int i = 0 ; i < m ; i++){
			int x = in.nextInt();
			int y= in.nextInt();
			int r = in.nextInt();
			edges.add(new Edge(x, y, r));
		}
		
		Collections.sort(edges);
		int mustEgdes  = 0;
		int totalWeight = 0;
		KruskalGraph g = new KruskalGraph(n);
		
		for(int i = 0 ; i < edges.size() && mustEgdes < n-1;i++){
			Edge e = edges.get(i);
			int n1 = e.from;
			int n2 = e.to;
			int w = e.weight;
			
			if(g.find(n1) != g.find(n2)){
				mustEgdes++;
				totalWeight+=w;
				g.union(n1, n2);
			}
		}
		System.out.println(totalWeight);
		in.close();
	}
	
	
	
}

class KruskalGraph{
	
	int[] nodes = null;
	
	public KruskalGraph(int n){
		nodes = new int[n+1];
		for(int i = 0 ; i < nodes.length; i++){
			nodes[i] = i;
		}
	}
	
	public int find(int node){
		if(nodes[node] == node){
			return node;
		}
		return find(nodes[node]);
	}
	
	public void union(int node1, int node2){
		int n1 = find(node1);
		int n2 = find(node2);
		nodes[n2] = n1;
	}
}

