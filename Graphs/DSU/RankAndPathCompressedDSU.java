import java.util.*;

public class DSU{
    private int[] parent;
    private int[] rank;
    
    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);
        
        if(xParent == yParent){
            return;
        }
        
        if(rank[xParent] > rank[yParent]){
            parent[yParent] = xParent;
        } else if(rank[xParent] < rank[yParent]){
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}
