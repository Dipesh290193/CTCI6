package HackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class KnightL {

	public static void main(String[] args) {
        int n = 5;
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        for(int i = 1 ; i < n; i++){
            for(int j = 1; j < n; j++){
                if(memo.containsKey(i+"-"+j)){
                    System.out.print(memo.get(i+"-"+j)+" ");
                }
                else{
                    /*HashMap<String, Integer> visited = new HashMap<String, Integer>();
		            HashSet<String> visiting = new HashSet<String>();*/
                    int paths = findPathsBFS(n, i , j);
                    System.out.print(paths+" ");
                    memo.put(i+"-"+j, paths);
                    memo.put(j+"-"+i, paths);
                }
            }
            System.out.println("");
        }
    }
	
	static int findPathsBFS(int n, int a, int b){
		LinkedList<Point> queue = new LinkedList<Point>();
		HashSet<String> visited = new HashSet<String>();
		queue.add(new Point(0,0,0));
		visited.add("0-0");
		while(queue.size() > 0){
			Point visit = queue.removeFirst();
			int r = visit.r;
			int c = visit.c;
			int path = visit.path;
			if(r+a <= n-1){
				
				if(c+b <= n-1){
					if(r+a == n-1 && c+b == n-1){
						return path + 1;
					}
					if(!visited.contains((r+a)+"-"+(c+b)))
					{
						visited.add((r+a)+"-"+(c+b));
						queue.addLast(new Point(r+a, c+b, path+1));
					}
					
				}
				if(c-b >= 0){
					if(!visited.contains((r+a)+"-"+(c-b)))
					{
						visited.add((r+a)+"-"+(c-b));
						queue.addLast(new Point(r+a, c-b, path+1));
					}
				}
			}
			if(r-a >= 0){
				
				if(c+b <= n-1){
					if(!visited.contains((r-a)+"-"+(c+b)))
					{
						visited.add((r-a)+"-"+(c+b));
						queue.addLast(new Point(r-a, c+b, path+1));
					}
				}
				if(c-b >= 0){
					if(!visited.contains((r-a)+"-"+(c-b)))
					{
						visited.add((r-a)+"-"+(c-b));
						queue.addLast(new Point(r-a, c-b, path+1));
					}
				}
			}
			if(r+b <= n-1){
				if(c+a <= n-1){
					if(r+b == n-1 && c+a == n-1){
						return path + 1;
					}
					if(!visited.contains((r+b)+"-"+(c+a)))
					{
						visited.add((r+b)+"-"+(c+a));
						queue.addLast(new Point(r+b, c+a, path+1));
					}
				}
				if(c-a >= 0){
					if(!visited.contains((r+b)+"-"+(c-a)))
					{
						visited.add((r+b)+"-"+(c-a));
						queue.addLast(new Point(r+b, c-a, path+1));
					}
				}
			}
			if(r-b >= 0){
				if(c+a <= n-1){
					if(!visited.contains((r-b)+"-"+(c+a)))
					{
						visited.add((r-b)+"-"+(c+a));
						queue.addLast(new Point(r-b, c+a, path+1));
					}
				}
				if(c-a >= 0){
					if(!visited.contains((r-b)+"-"+(c-a)))
					{
						visited.add((r-b)+"-"+(c-a));
						queue.addLast(new Point(r-b, c-a, path+1));
					}
				}
			}
		}
		return -1;
	}
	
	static class Point{
		int r, c, path;
		public Point(int r, int c, int path){
			this.r = r;
			this.c = c;
			this.path = path;
		}
		
		
	}
    
    static int findPaths(int n, int r, int c, int a, int b, HashMap<String, Integer> visited,
			HashSet<String> visiting) {
		if (r < 0 || c < 0 || r >= n || c >= n) {
			return -1;
		}
		if (r == n - 1 && c == n - 1) {
			return 1;
		}
		if (visiting.contains(r + "-" + c)) {
			return -1;
		}

		if (visited.containsKey(r + "-" + c)) {
			return visited.get(r + "-" + c);
		}

		visiting.add(r + "-" + c);
		int minWays = Integer.MAX_VALUE;

		int xayb = findPaths(n, r + a, c + b, a, b, visited, visiting)+1;

		if (xayb != 0 && minWays > xayb) {
			minWays = xayb;
		}

		int axyb = findPaths(n, r - a, c + b, a, b, visited, visiting)+1;

		if (axyb != 0 && minWays > axyb) {
			minWays = axyb;
		}
		
		int xaby = findPaths(n, r + a, c - b, a, b, visited, visiting)+1;

		if (xaby != 0 && minWays > xaby) {
			minWays = xaby;
		}
		
		int axby = findPaths(n, r - a, c - b, a, b, visited, visiting)+1;

		if (axby != 0 && minWays > axby) {
			minWays = axby;
		}
		
		int xbya = findPaths(n, r + b, c + a, a, b, visited, visiting)+1;

		if (xbya != 0 && minWays > xbya) {
			minWays = xbya;
		}
		
		int bxya = findPaths(n, r - b, c + a, a, b, visited, visiting)+1;

		if (bxya != 0 && minWays > bxya) {
			minWays = bxya;
		}
		
		int xbay = findPaths(n, r + b, c - a, a, b, visited, visiting)+1;

		if (xbay != 0 && minWays > xbay) {
			minWays = xbay;
		}
		
		int bxay = findPaths(n, r - b, c - a, a, b, visited, visiting)+1;

		if (bxay != 0 && minWays > bxay) {
			minWays = bxay;
		}
		visiting.remove(r + "-" + c);
		if(minWays == Integer.MAX_VALUE){
			visited.put(r+"-"+c, -1);
			return -1;
		}
		
		visited.put(r+"-"+c, minWays);
		return minWays;
	}
}
