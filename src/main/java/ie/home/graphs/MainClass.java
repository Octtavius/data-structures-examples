package ie.home.graphs;

import java.util.stream.IntStream;

public class MainClass {

	public static void main(String[] args) {
		Graph matrixGraph = initMatrixGraph();
//		
//		System.out.println("Matris Graphs");
//		matrixGraph
//			.getNeighbors(5)
//			.stream()
//			.forEach(v -> System.out.println(v + ", "));
//		
//
//		Graph listGraph = initListAdjGraph();
//		
//		System.out.println("List Graphs");
//		listGraph
//			.getNeighbors(5)
//			.stream()
//			.forEach(v -> System.out.println(v + ", "));
		
		GraphMatrix graph = initTwoHopesGraph();
		
//		System.out.println("neighbours: ");
//		graph.getTwoHopesNeighbors(0)
//			.stream()
//			.forEach(neighbour -> {
//				System.out.print(neighbour + ", ");
//			});
		
//		System.out.println("neighbours by multiplying: ");
//		graph.getTwoHopesNeighborsByMultiplying(0)
//			.stream()
//			.forEach(neighbour -> {
//				System.out.println(neighbour + ", ");
//			});
		
		System.out.println("Indegree of vertex 2");
		System.out.println(graph.degree(3));
	}
	
	public static GraphMatrix initTwoHopesGraph() {
		GraphMatrix matrixGraph = new GraphAdjMatrix();

		// add 6 vertices
		IntStream
			.range(0, 4)
			.forEach(num -> matrixGraph.addVertex());

		matrixGraph.addEdge(0, 1);
		matrixGraph.addEdge(0, 2);
		matrixGraph.addEdge(2, 1);
		matrixGraph.addEdge(2, 3);
		matrixGraph.addEdge(1, 3);
		
		return matrixGraph;
	}
	
	public static Graph initMatrixGraph() {
		Graph matrixGraph = new GraphAdjMatrix();

		// add 6 vertices
		IntStream
			.range(0, 6)
			.forEach(num -> matrixGraph.addVertex());

		matrixGraph.addEdge(0, 1);
		matrixGraph.addEdge(2, 3);
		matrixGraph.addEdge(4, 3);
		matrixGraph.addEdge(5, 3);
		matrixGraph.addEdge(5, 4);
		
		return matrixGraph;
	}
	
	public static Graph initListAdjGraph() {
		Graph listGraph = new GraphAdjList();

		// add 6 vertices
		IntStream
			.range(0, 6)
			.forEach(num -> listGraph.addVertex());

		listGraph.addEdge(0, 1);
		listGraph.addEdge(2, 3);
		listGraph.addEdge(4, 3);
		listGraph.addEdge(5, 3);
		listGraph.addEdge(5, 4);
		return listGraph;
	}

}
