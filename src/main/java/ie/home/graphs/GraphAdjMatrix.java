package ie.home.graphs;

import java.util.ArrayList;
import java.util.List;

import ie.home.matrixes.MatrixHelpers;

public class GraphAdjMatrix extends GraphMatrix{

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
		return neighbors;
	}

	@Override
	protected List<Integer> getNeighboursIndegree(int vertex) {
		List<Integer> neighbors = new ArrayList<Integer>();
		int numOfVertices = getNumVertices();
		
		for (int i = 0; i < numOfVertices; i++) {
			if (adjMatrix[i][vertex] != 0) {
				neighbors.add(i);
			}
		}
		
		return neighbors;
	}

	// this is outdegree neighbours
	@Override
	protected List<Integer> getTwoHopesNeighbors(int vertex) {
		List<Integer> neighbours = new ArrayList<Integer>();
		
		for (int i = 0; i < getNumVertices(); i++) {
			if (adjMatrix[vertex][i] > 0) {
				getNeighbors(i)
					.stream()
					.forEach(n -> {
						if (!neighbours.contains(n)) {
							neighbours.add(n);
						}
					});;
			}
		}
		
		return neighbours;
	}
	
	// this is outdegree neighbours
	@Override
	protected List<Integer> getTwoHopesNeighborsByMultiplying(int vertex) {
		List<Integer> neighbours = new ArrayList<Integer>();
		int[][] multipliedMatrix = MatrixHelpers.matrixToPowerTwo(adjMatrix);

		for (int i = 0; i < multipliedMatrix.length; i++) {
			if (multipliedMatrix[vertex][i] > 0) {
				neighbours.add(i);
			}
		}
		
		return neighbours;
	}
}
