**Euler Path**:
* An Euler path is a trail in a graph that visits every edge exactly once.
  It exists if the graph is connected ans has exactly two vertices of odd degree
* Source and End node of the graph has odd number of edges
* Start Node : outdegree[node] - indegree[node] = 1;
* Destination Node : indegree[node] - outdegree[node] = 1;

**Euler Circuit**:
* An Euler circuit is a closed trail in a graph that visits every edge exactly once and starts
and ends at the same vertex. It exits if the graph is connected and all vertices have even degrees
