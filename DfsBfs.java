/**
 * DfsBfs.java
 * @author Hrishikesh Karale
 * @id hhk9433
 * @date 03/30/2015
 * @version v1.3
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class consists of Dfs and Bfs algoriths along with other supporting methods.
 * It performs the dfs and bfs algorithms on a pre-set undirected graph given by prof Mooman.
 */
public class DfsBfs {

	private boolean dfsbfs[][];
	private boolean visited[];
	private Stack <Character> dfs;
	private Queue <Character> bfs;
	private boolean count=false;
	
	/**
	 * Default Constructor.Objects are created
	 */
	DfsBfs() {
		visited= new boolean[8];
		dfsbfs= new boolean[8][8];
		dfs= new Stack<Character>();
		bfs= new LinkedList<Character>();
	}
	
	/**
	 * This is the initialize() where  default values to the objects created 
	 * in default constructor is set.
	 */
	private void initialize() {
		 for(int i=0; i<8; i++) {
			visited[i]= false;
			for(int j=0; j<8; j++)
				dfsbfs[i][j]=false;
		}
		dfsbfs[0][1]= true;dfsbfs[1][0]= true;
		dfsbfs[0][3]= true;dfsbfs[3][0]= true;
		dfsbfs[0][6]= true;dfsbfs[6][0]= true;
		dfsbfs[1][4]= true;dfsbfs[4][1]= true;
		dfsbfs[1][5]= true;dfsbfs[5][1]= true;
		dfsbfs[2][7]= true;dfsbfs[7][2]= true;
		dfsbfs[2][5]= true;dfsbfs[5][2]= true;
		dfsbfs[3][5]= true;dfsbfs[5][3]= true;
		dfsbfs[4][6]= true;dfsbfs[6][4]= true;
	}
	
	/**
	 * this method keeps track of nodes being visited
	 * @return
	 */
	private boolean visitedAll() {
		boolean trigger= true;
		for(int i=0; i<8; i++) {
			if(!visited[i]) {
				trigger= false;
				break;
			}
		}
		return trigger;
	}
	
	/**
	 * This method uses Queue to keep track of the order in which the bfs is performed
	 * @param index
	 */
	private void bfsOrderVisited (int index) {
		switch (index) {
			case 0:	bfs.add('A');
				break;
			case 1:	bfs.add('B');
				break;
			case 2:	bfs.add('C');
				break;
			case 3:	bfs.add('D');
				break;
			case 4:	bfs.add('E');
				break;
			case 5:	bfs.add('F');
				break;
			case 6:	bfs.add('G');
				break;
			case 7:	bfs.add('H');
				break;
		}
	}
	
	/**
	 * this method uses stack to keep track of path used by dfs
	 * @param index
	 */
	private void dfsOrderVisited (int index) {
		switch (index) {
			case 0:	dfs.push('A');
				break;
			case 1:	dfs.push('B');
				break;
			case 2:	dfs.push('C');
				break;
			case 3:	dfs.push('D');
				break;
			case 4:	dfs.push('E');
				break;
			case 5:	dfs.push('F');
				break;
			case 6:	dfs.push('G');
				break;
			case 7:	dfs.push('H');
				break;
		}
	}
	
	/**
	 * This is where bfs has its main logic set up. This method takes in a
	 * parameter which is to be explored. It uses recurssion.
	 * @param node
	 */
	private void bfs(int node) {
		//removes node searched in last attempt
		if(count) {
			bfs.remove();
		}
		
		//checks if all the nodes are visited if not then proceeds
		if(!visitedAll()) {
			/*
			 * checks if current node is visited, if not proceed and
			 * mark current node as visited and add it to the bfs path
			 */
			if(!visited[node]) {
				dfsOrderVisited (node);
				visited[node]= true;
			}
			
			/*
			 * this block of code checks if there are any other connecting nodes 
			 * and if found to be true thay are checked if they are already visited, 
			 * if not then they are set as visited and added to the path of bfs and
			 * dfs stack is also used for displaying the path
			 */
			for(int i=0; i<8; i++) {
				if(dfsbfs[node][i]) {
					if(!visited[i]) {
						visited[i]= true;
						bfsOrderVisited(i);
						dfsOrderVisited (i);
					}
				}
			}
			count= true;
			//recursive call. element is converted to desired form ex: 0-5 node
			bfs((int)bfs.element()-65);
		}
	}
	
	/**
	 * This is a recursive method which takes in an int as a parameter which is
	 * the current node to be explored
	 * @param node
	 */
	private void dfs(int node) {
		//if all nodes are not visited, proceed
		if(!visitedAll()) {
			//check if current node is visited, if not proceed and mark it visited and add it to the stack
			if(!visited[node]) {
				dfsOrderVisited (node);
				visited[node]= true;
			}
			/*
			 * recursively calls itself for any unvisited and connected child nodes 
			 */
			for(int i=0; i<8; i++) {
				if(dfsbfs[node][i]) {
					if(!visited[i]) {
						dfs(i);
					}
				}
			}
		}
	}
	
	/**
	 * This is the main() of our program, where calls to  various methods are made
	 * belonging to DfsBfs clas and the dfs and bfs is calculated for the given graph 
	 * and displayed
	 * @param args
	 */
	public static void main(String args[]) {
		//start node
		int node= 0;
		//object is made
		DfsBfs dfsObject= new DfsBfs();
		//class object is initialized
		dfsObject.initialize();
		//dfs() is called using start node as parameter
		dfsObject.dfs(node);
		//dfs path is printed
		System.out.println("DFS: "+dfsObject.dfs);
		//object is made
		DfsBfs bfsObject= new DfsBfs();
		//initialized
		bfsObject.initialize();
		//bfs() call with start node as parameter
		bfsObject.bfs(node);
		//the path is printed
		System.out.println("BFS: "+bfsObject.dfs);
	}
	
}
