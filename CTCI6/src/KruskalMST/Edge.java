package KruskalMST;

public class Edge implements Comparable<Edge>{
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
