package UnionFind;

public class Solution {

}

class UF{
    private int[] id;

    private int[] size;

    public UF(int n){
        id = new int[n];
        size = new int[n];
        for(int i = 0 ; i < n; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p){
        int max = p;
        while(p != id[p]){
            if(id[p] > max)
                max = id[p];
            p = id[p];
        }
        return max;
    }

    private int root(int p){
        while(p != id[p]){
            p= id[p];
        }
        return p;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);
        if(size[rootP] < size[rootQ]){
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else{
           id[rootQ] = rootP;
           size[rootP] += size[rootQ];
        }
    }
}
