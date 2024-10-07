class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] r : edges){
            int i = r[0];
            int j = r[1];
            list.get(i).add(j);
            list.get(j).add(i);
        }
        
        return list;
    }
}
