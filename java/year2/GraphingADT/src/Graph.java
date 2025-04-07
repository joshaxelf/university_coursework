import java.util.ArrayList;

public class Graph implements GraphADT {

    // 2D array to store the adjacency matrix
    private boolean[][] adjacencyMatrix;
    // Declare number of nodes in the graph
    private int numNodes;

    public Graph(int n) {
        // Initialise Matrix
        adjacencyMatrix = new boolean[n][n];
        numNodes = n;
    }

    // Get number of nodes
    public int nNodes() {
        return numNodes;
    }

    // Get number of edges
    public int nEdges() {

        // Iteration to get amount of edges in Matrix
        int numEdges = 0;
        for (int i = 0; i < numNodes; i++) {
            for (int j = i + 1; j < numNodes; j++) {
                if (adjacencyMatrix[i][j]) {
                    numEdges++;
                }
            }
        }
        // Return edges halved as to avoid double counting as each edge counted twice
        return numEdges/2;
    }

    // Add edge and ensure symmetry
    public boolean addEdge(int node1, int node2) {
        if (isEdge(node1, node2)) {
            return false;
        }

        // Set both edges to true as symmetrical in undirected
        adjacencyMatrix[node1][node2] = true;
        adjacencyMatrix[node2][node1] = true;
        return true;
    }

    // Verify if edge between nodes
    public boolean isEdge(int node1, int node2) {
        return adjacencyMatrix[node1][node2] || adjacencyMatrix[node2][node1];
    }

    // Identify neighbours of nodes
    public ArrayList<Integer> neighbours(int node) {
        ArrayList<Integer> neighborNodes = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {

            // Iteration through rows of Matrix
            if (adjacencyMatrix[node][i]) {
                neighborNodes.add(i);
            }
        }
        return neighborNodes;
    }

    // Get degree of nodes
    public int degree(int node) {
        return neighbours(node).size();
    }
}