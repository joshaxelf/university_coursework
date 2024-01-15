import java.util.ArrayList;

public class DiGraphAdjacentList implements DiGraphADT {

    private ArrayList<ArrayList<Integer>> adjacentList;

    // Declare number of nodes in the graph
    private int numNodes;

    public DiGraphAdjacentList(int numNodes) {

        // Initiate our Adjacent List
        adjacentList = new ArrayList<>(numNodes);

        // Create empty lists for nodes
        for (int i = 0; i < numNodes; i++) {
            adjacentList.add(new ArrayList<>());
        }

        this.numNodes = numNodes;
    }

    // Get amount of nodes in the graph
    @Override
    public int nNodes() {
        return numNodes;
    }

    // Get the amount of edges in the graph
    @Override
    public int nEdges() {

        // Count edges by adding size of all lists
        int numEdges = 0;
        for (int i = 0; i < numNodes; i++) {
            numEdges += adjacentList.get(i).size();
        }
        return numEdges;
    }

    // Add an edge from node1 to node2
    @Override
    public boolean addEdge(int node1, int node2) {

        // Check if edge already exists
        if (isEdge(node1, node2)) {
            return false;
        }

        // Add node2 to adjacentList for node 1, return edge exists
        adjacentList.get(node1).add(node2);
        return true;
    }

    // Verify edge between node1 and node2
    @Override
    public boolean isEdge(int node1, int node2) {
        return adjacentList.get(node1).contains(node2);
    }

    // Get the successor nodes
    @Override
    public ArrayList<Integer> successors(int node) {
        return new ArrayList<>(adjacentList.get(node));
    }

    // Get the predecessor nodes
    @Override
    public ArrayList<Integer> predecessors(int node) {

        // Create a new list for predecessor nodes
        ArrayList<Integer> predecessorNodes = new ArrayList<>();

        // Iteration to find predecessors
        for (int i = 0; i < numNodes; i++) {
            if (adjacentList.get(i).contains(node)) {
                predecessorNodes.add(i);
            }
        }
        return predecessorNodes;
    }

    // Get the out-degree of a node
    @Override
    public int outDegree(int node) {
        return adjacentList.get(node).size();
    }

    // Get the in-degree of a node
    @Override
    public int inDegree(int node) {
        return predecessors(node).size();
    }
}
