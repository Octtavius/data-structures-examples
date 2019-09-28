package ie.home.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMatrix extends Graph{

	private int[][] adjMatrix;
	
	public GraphAdjMatrix() {
		adjMatrix = new int[2][2];
	}

	@Override
	protected void implementAddVertex() {
		int v = getNumVertices();
		if (v >= adjMatrix.length) {
			// double the size
			int[][] newAdjMatrix = new int[v*2][v*2];
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix.length; j++) {
					newAdjMatrix[i][j] = adjMatrix[i][j];
				}
			}
			
			adjMatrix = newAdjMatrix;
		}
		// populate the new added row
		for (int i = 0; i < adjMatrix[v].length; i++) {
			adjMatrix[v][i] = 0;
		}
	}

	@Override
	protected void implementAddEdge(int from, int to) {
		adjMatrix[from][to] = 1;
	}

	@Override
	protected List<Integer> getNeighbors(int vertex) {
		List<Integer> neighbors = new ArrayList<Integer>();
		
		int numOfVertices = getNumVertices();
		
		for (int i = 0; i < numOfVertices; i++) {
			if (adjMatrix[vertex][i] != 0) {
				neighbors.add(i);
			}
		}
		return null;
	}

	
}
