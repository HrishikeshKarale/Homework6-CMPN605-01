/**
 * Dijkstra.java
 * @author Hrishikesh Karale
 * @id hhk9433
 * @date 04/6/2015
 * @version v1.8
 * 
 * The source node and destination nodes are already fixed as per the problem
 * set by prof Mooman.
 * My program solution has been divided into three java files,Edges.java and 
 * Node.java should be compiled along with Dijkstra.java
 * Dijkstra.java contains the main()
 */

import java.util.*;

/**
 * This class consists of the main() along with other useful methods such as 
 * calculatePath() and shortestPath() which help in determining the shortest
 * path for dijkstras algorithm for  the given graph.
 *
 */
public class Dijkstra {
    /**
     * This method calculates the path from source node which is taken as a parameter.
     * It uses a queue to store possible paths and selects path based on the 
     * weight on the edge.
     * @param source
     */
	private void calculatePath(Node source) {
        //initializes minimum distance for source
		source.setMinDist(0);
        Queue<Node> nodeQueue = new PriorityQueue<Node>();
        //source node is added to the queue
      	nodeQueue.add(source);
      	Node v= null;
      	/*
      	 * this block of code, removes the first node in the queue and checks 
      	 * for possible edges connected to the node that was removed from the 
      	 * queue for analysis. It also checks if the path to be taken is the right
      	 * path and whether the weight is minimum or not
      	 */
		do {
			//removes the first Node from queue and stores it in u.
		    Node u = nodeQueue.poll();

		    //checks if the removed node has any edges or not.
		    if(u.getEdgeList()!=null) {
		    	
		    	/*
		    	 * Visit each edge exiting in u and look for suitable node which could
		    	 * be used as path
		    	 */
		    	for (int i=0; i<u.getEdgeList().length; i++ ) {
		        	//stores Edge from the list of Edges we get from u
		    		Edges e= u.getEdge(i);
		            //stores node connected to that edge
		    		v = e.getNode();
		    		//stores weight of the edge that connects the two nodes
		            float weight = e.getWeight();
		            //stores total weight of the path so far.
		            float distanceThroughU = u.getMinDist() + weight;
		            /* 
		             * if path distance is less than min distance then removes the current 
		             * node from queue AND store current node as previous node and add the 
		             * new node to the path queue.
		             */
		            if (distanceThroughU < v.getMinDist()) {
		            	nodeQueue.remove(v);
		            	v.setMinDist(distanceThroughU) ;
		            	v.setPrevNode(u);
		            	nodeQueue.add(v);
		            }
		        }
		    }
		}while (!nodeQueue.isEmpty());
    }
    

    /**
     * this method takes a Node as a parameter and tracks its previously connected Nodes.
     * @param connectedNode
     * @return
     */
    private List<Node> shortestPath(Node connectedNode) {
    	//ArrayList of nodes is created.
        List<Node> path = new ArrayList<Node>();
        
        /* 
         * This block of code makes an arraylist of all the previous nodes and returns
         * it to the calling function for further use
         */
        for (Node node = connectedNode; node != null; node = node.getPrevNode()) {
            path.add(node);
        }
        
        return path;
    }

    /**
     * This is the main() of our Djikstra.java class. It initialized various nodes and their respective edges.
     * It calculates the path and selects the shortest path from source to destination.
     * @param args
     */
    public static void main(String[] args) {
    	//Initializes various Nodes
    	Node sourceNode= null;
    	Node destinationNode= null;
        Node v0 = new Node("A");
		Node v1 = new Node("B");
		Node v2 = new Node("C");
		Node v3 = new Node("D");
		Node v4 = new Node("E");
		Node v5 = new Node("F");
		Node v6 = new Node("G");
		//source node
		sourceNode= v0;
		//destination node
		destinationNode= v5;
		
		Dijkstra djk= new Dijkstra();
		
		//Initializes the Edgesbudding out from  out respective nodes.
		v0.setEdges(new Edges[]{ new Edges(v1, 5), new Edges(v2, 10)});
		v1.setEdges(new Edges[]{ new Edges(v3, 6), new Edges(v4, 3)});
		v3.setEdges(new Edges[]{ new Edges(v5, 6)});
		v4.setEdges(new Edges[]{ new Edges(v2, 2), new Edges(v3, 2), new Edges(v6, 2)});
		v6.setEdges(new Edges[]{ new Edges(v5, 2)});
		
		//Calculates the path from source
		djk.calculatePath(sourceNode);
        
		System.out.println("Distance from "+sourceNode+" to " + destinationNode + " is " + destinationNode.getMinDist());
	    
		//Stores the shortest Path in the list of nodes
        List<Node> path = djk.shortestPath(destinationNode);
	    
        //Itterator to iterate through our list of path
	    Iterator<Node> iterator = path.iterator();
	    System.out.print("Path: ");
	    //reverses our listof path.
        Collections.reverse(path);
        
        //prints contects of ArrayList in desired format.
	    while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if(iterator.hasNext())
            	System.out.print("->");
        }
    }
}