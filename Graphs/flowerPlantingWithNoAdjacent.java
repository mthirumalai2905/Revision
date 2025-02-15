class Solution {
    List<List<Integer>> g;
    int color[];

    public int[] gardenNoAdj(int N, int[][] paths) {
        int m = 4;
        g = new ArrayList<>();
        color = new int[N];
        for(int i = 0; i < N; i++){
            g.add(new ArrayList<>());
        }
        for(int i = 0; i < paths.length; i++){
            g.get(paths[i][0] - 1).add(paths[i][1] - 1);
            g.get(paths[i][1] - 1).add(paths[i][0] - 1);
        }

        solve(m, 0, N);
        return color;
    }

    public boolean solve(int m, int v, int N){
        if(v == N) return true;

        for(int c = 1; c <= m; c++){
            if(isSafe(c,v)){
                color[v] = c;
                if(solve(m,v+1,N)) return true;
                color[v] = 0;
            }
        }
        return false;
    }

    public boolean isSafe(int c, int v){
        for(int i : g.get(v)){
            if(color[i] == c){
                return false;
            }
        }
            return true;
    }
}
