package Dijkstra;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            HashMap<Integer, ArrayList<Edge>> g = new HashMap<Integer, ArrayList<Edge>>();
            int n = in.nextInt();
            int m = in.nextInt();
            for(int a1 = 0; a1 < m; a1++){
                int x = in.nextInt();
                int y = in.nextInt();
                int r = in.nextInt();
                if(!g.containsKey(x)){
                    g.put(x, new ArrayList<Edge>());
                }
                if(!g.containsKey(y)){
                    g.put(y, new ArrayList<Edge>());
                }
                g.get(x).add(new Edge(x,y,r));
                g.get(y).add(new Edge(y, x,r));              
            }
            int root = in.nextInt();
            LinkedList<Edge> edges = new LinkedList<Edge>();
            edges.addAll(g.get(root));
            HashSet<Integer> visited = new HashSet<Integer>();
            visited.add(root);
            HashMap<Integer, HashSet<Edge>> mustEdges = new HashMap<Integer, HashSet<Edge>>();
            while(!edges.isEmpty() && mustEdges.size() < n){
                Collections.sort(edges);
                Edge e = edges.removeFirst();
                if(!visited.contains(e.from) || !visited.contains(e.to)){
                    if(!mustEdges.containsKey(e.from)){
                        mustEdges.put(e.from, new HashSet<Edge>());
                    }
                    if(!mustEdges.containsKey(e.to)){
                        mustEdges.put(e.to, new HashSet<Edge>());
                    }
                    mustEdges.get(e.from).add(new Edge(e.from, e.to, e.weight));
                    mustEdges.get(e.to).add(new Edge(e.to, e.from, e.weight));
                    visited.add(e.to);
                    for(Edge edge: g.get(e.to)){
                        if(!visited.contains(edge.to)){
                            edges.addLast(edge);
                        }
                    }
                }
            }
            
            for(int i = 1 ; i <= n ;i++){
                if(root != i){
                    HashSet<Integer> visit = new HashSet<Integer>();
                    int result = DFS(mustEdges, root, i, visit);
                    mustEdges.get(root).add(new Edge(root, i, result));
                    System.out.print(result+" ");
                }
            }
            System.out.println();
            
        }
    }
    
    public static int DFS(HashMap<Integer, HashSet<Edge>> graph, int s, int d, HashSet<Integer> visited){
        if(d == s){
            return 0;
        }
        visited.add(s);
       
        for(Edge e : graph.get(s)){
            if(!visited.contains(e.to)){
                int result = DFS(graph, e.to, d, visited);
                if(result != -1){
                    return e.weight+result;
                }
            }
        }
        
        return -1;
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
    
        @Override
        public boolean equals(Object o)
        {
            if(this == o)
                return true;
            if(!(o instanceof Edge))
                return false;
            Edge edge = (Edge) o;
            if(weight != edge.weight)
                return false;
            if(( from != 0 ? from != edge.from : edge.from != 0 ))
                return false;
            return to != 0 ? to == edge.to: edge.to == 0;

        }

        @Override
        public int hashCode()
        {
            int result = from != 0 ? from : 0;
            result = 31 * result + (to != 0 ? to : 0);
            result = 31 * result + weight;
            return result;
        }
}

