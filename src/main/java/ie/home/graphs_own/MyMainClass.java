package ie.home.graphs_own;

import java.util.HashSet;

public class MyMainClass {
	public static void main(String[] args) {
		GraphAdjMatrix matrixGraph = new GraphAdjMatrix();
		
		int numVertices = 12;
		for (int i = 0; i < numVertices; i++) {
			matrixGraph.addVertext();
		}
		
		matrixGraph.addEdge(0, 1);
		matrixGraph.addEdge(1,2);
		matrixGraph.addEdge(2, 11);
		matrixGraph.addEdge(11, 2);
		matrixGraph.addEdge(2,3);
		matrixGraph.addEdge(3,4);
		matrixGraph.addEdge(4,5);
		matrixGraph.addEdge(5,6);
		matrixGraph.addEdge(6,7);
		matrixGraph.addEdge(7,8);
		matrixGraph.addEdge(8,9);
		matrixGraph.addEdge(9,10);
		matrixGraph.addEdge(10,9);
		matrixGraph.addEdge(9,8);
		matrixGraph.addEdge(8,7);
		matrixGraph.addEdge(7,6);
		matrixGraph.addEdge(6,5);
		matrixGraph.addEdge(5,4);
		matrixGraph.addEdge(4,3);
		matrixGraph.addEdge(3,2);
		matrixGraph.addEdge(2,1);
		matrixGraph.addEdge(1,0);
		
//		matrixGraph.DFS(7, 10, new HashSet<Integer>());
		matrixGraph.BFS(7, 10, new HashSet<Integer>());
		
//		matrixGraph.addVertext();

		System.out.println("indegree neighbours");
		for (Integer neigh : matrixGraph.getIndegreeNeighbours(1)) {
			System.out.print(neigh + ", ");
		}
		System.out.println();
		
		System.out.println("outdegree neighbours");
		for (Integer neigh : matrixGraph.getOutNeighbours(1)) {
			System.out.print(neigh + ", ");
		}
		
		System.out.println();
		
		System.out.println("get all neighbours");
		for (Integer neigh : matrixGraph.getNeighbours(1)) {
			System.out.print(neigh + ", ");
		}
		
		System.out.println();
		
		System.out.println("Number of vertices");
		System.out.println(matrixGraph.getNumVertices());
		
//		System.out.println("Total space:"); 
//		System.out.println(matrixGraph.totalSpace());
		
	}
}
