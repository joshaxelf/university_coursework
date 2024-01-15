import java.util.ArrayList;

public class DiGraphAdjacentMatrix implements DiGraphADT {

    // 2D array to store the adjacency matrix
    private int[][] adjacencyMatrix;
    // Declare number of nodes in the graph
    private int numNodes;
    // Declare number of edges in the graph
    private int numEdges;

    // Initialise with number of nodes
    public DiGraphAdjacentMatrix(int numNodes) {
        this.numNodes = numNodes;
        this.numEdges = 0;

        // Create adjacency matrix to fit amount of nodes
        this.adjacencyMatrix = new int[numNodes][numNodes];
    }

    // Get amount of nodes in the graph
    @Override
    public int nNodes() {
        return numNodes;
    }

    // Get amount of edges for graph
    @Override
    public int nEdges() {
        return numEdges;
    }

    // Add an edge from node1 to node2
    @Override
    public boolean addEdge(int node1, int node2) {

        // Check if an edge exists
        // If 0, add edge, return true
        if (adjacencyMatrix[node1][node2] == 0) {
            adjacencyMatrix[node1][node2] = 1;
            numEdges++;
            return true;
        } else {
            // If the edge already exists, return false
            return false;
        }
    }

    // Check if there is an edge between nodes
    @Override
    public boolean isEdge(int node1, int node2) {

        // Check if edge between nodes
        return adjacencyMatrix[node1][node2] == 1;
    }

    // Get successor nodes
    @Override
    public ArrayList<Integer> successors(int node) {

        // Make list of nodes
        ArrayList<Integer> successors = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {

            // If there is an edge, add the successor node to the list  [column][rows]
            if (adjacencyMatrix[node][i] == 1) {
                successors.add(i);
            }
        }
        return successors;
    }

    // Get the predecessor nodes
    @Override
    public ArrayList<Integer> predecessors(int node) {

        // Create a list for predecessor nodes
        ArrayList<Integer> predecessors = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {

            // If there is an edge, add the predecessor node to the list, [column][rows]
            if (adjacencyMatrix[i][node] == 1) {
                predecessors.add(i);
            }
        }
        return predecessors;
    }

    // Get outDegree of nodes
    @Override
    public int outDegree(int node) {
        return successors(node).size();
    }

    // Get inDegree of nodes
    @Override
    public int inDegree(int node) {
        return predecessors(node).size();
    }
}
