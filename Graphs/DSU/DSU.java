class DSU{
  private int[] parent;

  public DSU(int n){
    parent = new int[n];
    for(int i = 0; i < n; i++){
      parent[i] = i;
    }
  }

 public int find(int x){
   if(x == parent[x]){
     return x;
   }
   return find(parent[x]);
 }

public void union(int x, int y){
  int rootX = find(x);
  int rootY = find(y);
  if(rootX != rootY){
    parent[rootX] = rootY;
  }
 }
}
