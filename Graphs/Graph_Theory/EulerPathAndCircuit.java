public class EulerPathAndCircuit{
  public static void main(String[] args){
    int vertices = 5;
    List<List<Integer>> graph = new ArrayList<>();
    for(int i = 0; i < vertices; i++){
      graph.add(new ArrayList<>());
    }

    addEdge(graph, 0, 1);
    addEdge(graph, 1, 2);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);
    addEdge(graph, 4, 0);

    if(isEulerCircuit(graph, vertices)){
      System.out.println("The graph has an Euler Circuit.");
    } else if(isEulerPath(graph, vertices)){
      System.out.println("The graph has an Euler Path.");
    } else {
      System.out.println("The graph has neither an Euler Path nor an Euler Circuit");
    }
  }

  public static void addEdge(List<List<Integer>> graph, int u, int v){
    graph.get(u).add(v);
    graph.get(v).add(u);
  }

  public static boolean isEulerCircuit(List<List<Integer>> graph, int vertices){
    if(!isConnected(graph, vertices)) return false;

    for(int i = 0; i < vertices; i++){
      if(graph.get(i).size() % 2 != 0){
        return false;
      }
    }
    return true;
  }

  public static isEulerPath(List<List<Integer>> graph, int vertices){
    if(!isConnected(graph, vertices)) return false;

    int odd = 0;
    for(int i = 0; i < vertices; i++){
      if(graph.get(i).size() % 2 != 0){
        odd++;
    }
  }
  return odd == 2;
}

  public static boolean isConnected(List<List<Integer>> graph, int vertices){
    boolean[] visited = new boolean[vertices];
    int start = -1;

    for(int i = 0; i < vertices; i++){
      if(!graph.get(i).isEmpty()){
        start = i;
        break;
      }
    }

    if(start == -1) return true;

    dfs(graph, visited, start);

    for(int i = 0; i < vertices; i++){
      if(!visited[i] && !graph.get(i).isEmpty()){
        return false;
      }
    }
    return true;
  }

  public static void dfs(List<List<Integer>> graph, boolean[] visited, int node){
    visited[node] = true;
    for(int ngbr : graph.get(node)){
      if(!visited[ngbr]){
        dfs(graph, visited, ngbr);
      }
    }
  }
}

  

    


  
