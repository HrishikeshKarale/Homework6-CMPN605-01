/**
 * Edges.java
 * @author Hrishikesh Karale
 * @id hhk9433
 * @date 04/6/2015
 * @version v1.0
 * 
 * This file should be compiled along with Dijkstra.java and Node.java
 */

/**
 * This class is used to make and store edges between different Nodes.
 * It has various helpful methods such as getNode(), getWeight() etc
 */
class Edges {
	//stores node connected to cour current calling node
    private Node connectedNode;
    //stores weight of our connecting edge
    private float weight;
    
    /**
     * getter method, returns connecting node
     * @return
     */
    public Node getNode() {
    	return connectedNode;
    }

    /**
     * getter method, returns weight of the edge.
     * @return
     */
    public float getWeight() {
    	return weight;
    }
    
    /**
     * Parameterized Constructor
     * @param argTarget
     * @param argWeight
     */
    Edges(Node Target, float Weight) { 
    	connectedNode = Target; 
    	weight = Weight; 
    }
}
