package BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i = 0 ; i < q ; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            Graph g = new Graph(n);
            
            for(int j = 0 ; j < m ; j++){
                int node1 = in.nextInt();
                int node2 = in.nextInt();
                g.addEdge(node1, node2);
            }
            int root = in.nextInt();
            for(int k = 1; k <= n ; k++){
                if(k != root){
                    if(g.nodes.get(root).connectedNodes.contains(k)){
                        System.out.print("6 ");
                    }
                    else{
                        int path = BFS(g, root, k);
                        if(path  != -1){
                            System.out.print(path*6+" ");
                        }
                        else{
                            System.out.print("-1 ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
    
    public static int BFS(Graph g, int root, int target){
    	//LinkedList<Integer> current = new LinkedList<Integer>
        LinkedList<Integer> nextVisit = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextVisit.add(root);
        visited.add(root);
        int c = 0;
        int count = 1;
        int level = 0;
        while(!nextVisit.isEmpty()){
            int n = nextVisit.removeFirst();
            Node node = g.nodes.get(n);;
            if(node.connectedNodes.contains(target)){
                return level+1;
            }
            count--;
           
            for(int i: node.connectedNodes){
                if(!visited.contains(i)){
                    nextVisit.addLast(i);
                    visited.add(i);
                    c++;
                }
            }
            if(count == 0){
                level++;
                count = c;
                c = 0;
            }
        }
        return -1;
    }
}

class Graph{
   HashMap<Integer, Node> nodes;
    public Graph(int n){
        nodes = new HashMap<Integer, Node>();
        for(int i = 1 ; i <= n ; i++){
            nodes.put(i, new Node(i));
        }
    }
    
    public void addEdge(int node1, int node2){
        nodes.get(node1).connectedNodes.add(node2);
        nodes.get(node2).connectedNodes.add(node1);
    }
}

class Node{
    int num;
    HashSet<Integer> connectedNodes;
    public Node(int n){
        this.num = n;
        connectedNodes = new HashSet<Integer>();
    }
}
