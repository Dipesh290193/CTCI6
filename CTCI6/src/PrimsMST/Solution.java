package PrimsMST;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, ArrayList<Edge>> g = new HashMap<Integer, ArrayList<Edge>>();
        for(int i = 0 ; i < m ; i++){
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int w = in.nextInt();
            if(!g.containsKey(n1)){
                g.put(n1, new ArrayList<Edge>());
            }
            if(!g.containsKey(n2)){
                g.put(n2, new ArrayList<Edge>());
            }
            g.get(n1).add(new Edge(n1,n2,w));
            g.get(n2).add(new Edge(n2, n1,w));
        }
        int root = in.nextInt();
        LinkedList<Edge> edges = new LinkedList<Edge>();
        edges.addAll(g.get(root));
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(root);
        int mustEdges = 0;
        int totalWeight = 0;
        while(!edges.isEmpty() && mustEdges < n-1){
            Collections.sort(edges);
            Edge e = edges.removeFirst();
            if(!visited.contains(e.from) || !visited.contains(e.to)){
                mustEdges++;
                totalWeight+=e.weight;
                visited.add(e.to);
                for(Edge edge: g.get(e.to)){
                    if(!visited.contains(edge.to)){
                        edges.addLast(edge);
                    }
                }
            }
        }
        
        System.out.println(totalWeight);
    }
}

class Edge implements Comparable<Edge>{
	 int from;
	    int to;
	    int weight;
	      
	     public Edge(int from, int to, int weigth){
	       this.from =from;
	       this.to= to;
	       this.weight = weigth;
	    }
	    
		@Override
		public int compareTo(Edge o) {
			if(this.weight > o.weight){
				return 1;
			}
			else if(this.weight < o.weight){
				return -1;
			}
				
			return this.from+this.to+this.weight - o.from+o.to+o.weight;
		}
}
