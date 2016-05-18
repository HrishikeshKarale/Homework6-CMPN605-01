/**
 * Node.java
 * @author Hrishikesh Karale
 * @id hhk9433
 * @date 04/6/2015
 * @version v1.1
 * 
 * This file should be compiled along with Dijkstra.java and Edges.java
 */

/**
 * This class implements the comparator so that we could compare two nodes
 * The primary function of this class is to store various information about 
 * the node such as its connecting edges previous node and keeping track of 
 * minimum weight or distance in our case. 
 */
class Node implements Comparable<Node> {
	//stores name of the node.
    private String name;
    //stores a list of connecting nodes
    private Edges[] linked;
    //stores node previously visited.
    private Node previousNode;
    //stores distance from current node
    private float minDistance =0;
    
    /**
     * getter method, returns the nth connecting node
     * @param position
     * @return
     */
    public Edges getEdge(int position) {
    	return linked[position];
    }
    
    /**
     * setter method. takes in an array of connecting Edges and stoers it in linked
     * @param edge
     */
    public void setEdges(Edges[] edge) {
    	linked=edge;
    }
    
    /**
     * getter method. returns an array of connecting edges 
     * @return
     */
    public Edges[] getEdgeList() {
    	return linked;
    }
    
    /**
     * Parameterized Constructor. Initializes name and minDistance as infinity.
     * @param argName
     */
    Node(String argName) { 
    	name = argName; 
    	minDistance=  Float.POSITIVE_INFINITY;
    }
    
    /**
     * getter method. returns previous connecting node
     * @return
     */
    public Node getPrevNode() {
    	return previousNode;
    }
    
    /**
     * setter method. sets previous node to the node passed as parameter to this method
     * @param node
     */
    public void setPrevNode(Node node) {
    	previousNode=node; 
    }
       
    /**
     * getter method. returns the min distance between nodes
     * @return
     */
    public float getMinDist() {
    	return minDistance;
    }
    
    /**
     * setter method. sets min distance between nodes as passed down by parameter.
     * @param number
     */
    public void setMinDist(float number) {
    	minDistance= number;
    }
    
    /**
     * returns name so that when called it would say it name rather than some address.
     * @Override(non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() { 
    	return name; 
    }
    
    /**
     * The comparatorto() is over ridden so that we could define it ourself.
     * here Float.compare(one, two) is used as a float cannot be accurately compared
     * by an == operator.
     * @Override
     */
    public int compareTo(Node other) {
        return Float.compare(minDistance, other.minDistance);
    }
}