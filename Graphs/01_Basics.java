import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList;

    // Constructor for creating an empty graph
    public Graph() {
        adjList = new HashMap<>();
    }
    // Method to add a new vertex
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Method to add an edge between two vertices
    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);  // For undirected graph
    }

    // Method to remove an edge

    public void removeEdge(int source, int destination) {
        List<Integer> srcList = adjList.get(source);
        List<Integer> destList = adjList.get(destination);
        if (srcList != null) srcList.remove(Integer.valueOf(destination));
        if (destList != null) destList.remove(Integer.valueOf(source));
    }

    // Method to remove a vertex
    public void removeVertex(int vertex) {
        List<Integer> adjacentVertices = adjList.get(vertex);
        if (adjacentVertices != null) {
            for (int adj : adjacentVertices) {
                adjList.get(adj).remove(Integer.valueOf(vertex));
            }
        }
        adjList.remove(vertex);
    }

    // DFS Helper
    private void dfsHelper(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (int adj : adjList.get(vertex)) {
            if (!visited.contains(adj)) {
                dfsHelper(adj, visited);
            }
        }
    }

    // Method to perform DFS
    public void dfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS traversal starting from vertex " + startVertex + ": ");
        dfsHelper(startVertex, visited);
        System.out.println();
    }

    // Method to perform BFS
    public void bfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        visited.add(startVertex);
        queue.offer(startVertex);
        
        System.out.print("BFS traversal starting from vertex " + startVertex + ": ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            for (int adj : adjList.get(vertex)) {
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    queue.offer(adj);
                }
            }
        }
        System.out.println();
    }

    // Print the adjacency list of the graph
    public void printGraph() {
        System.out.println("Adjacency List of the graph:");
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + ": ");
            for (int adj : adjList.get(vertex)) {
                System.out.print(adj + " ");
            }
            System.out.println();
        }
    }
}

public class GraphExample {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // Print graph
        graph.printGraph();

        // DFS traversal
        graph.dfs(1);

        // BFS traversal
        graph.bfs(1);

        // Deleting an edge between vertex 1 and 2

        System.out.println("Deleting edge between 1 and 2");
        graph.removeEdge(1, 2);
        graph.printGraph();

        // Deleting vertex 4
        System.out.println("Deleting vertex 4");
        graph.removeVertex(4);
        graph.printGraph();
    }
}

Output:

Adjacency List of the graph:
1: 2 3 
2: 1 4 
3: 1 4 
4: 2 3 5 
5: 4 
    
DFS traversal starting from vertex 1: 1 2 4 3 5 
BFS traversal starting from vertex 1: 1 2 3 4 5 
Deleting edge between 1 and 2
Adjacency List of the graph:
1: 3 
2: 4 
3: 1 4 
4: 2 3 5 
5: 4 
Deleting vertex 4
Adjacency List of the graph:
1: 3 
2: 
3: 1 
5: 
