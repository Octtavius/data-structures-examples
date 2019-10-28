package ie.home.graphs_own;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMatrix extends Graph{

	private int[][] adjMatrix;
	
	public GraphAdjMatrix() {
		adjMatrix = new int[2][2];
	}
	
	@Override
	protected void implementAddVertex() {
		int numV = getNumVertices();
		
		// if num of vertices is equal to adjMatrix length, then adjMatrix is full
		// we need to resize the matrix and repopulate everything
		if (numV >= adjMatrix.length) {
			// double the existing size
			int[][] newAdjMatrix = new int[2*numV][2*numV];
			
			for (int i = 0; i < numV; i++) {
				for (int j = 0; j < numV; j++) {
					newAdjMatrix[i][j] = adjMatrix[i][j];
				}
			}
			
			adjMatrix = newAdjMatrix;
		}
	}

	@Override
	protected void implementAddEdge(int from, int to) {
		adjMatrix[from][to] = 1;
	}

	@Override
	protected List<Integer> getNeighbours(int vertex) {
		List<Integer> neighboursIntegers = getIndegreeNeighbours(vertex);
		neighboursIntegers.addAll(getOutNeighbours(vertex));
		
		return neighboursIntegers;
	}

	@Override
	protected List<Integer> getIndegreeNeighbours(int vertex) {
		List<Integer> indegreeNeighbours = new ArrayList<Integer>();
		
		for (int i = 0; i < adjMatrix[vertex].length; i++) {
			if (adjMatrix[i][vertex] != 0) {
				indegreeNeighbours.add(i);
			}
		}
		
		return indegreeNeighbours;
	}

	@Override
	protected List<Integer> getOutNeighbours(int vertex) {
		List<Integer> outdegreeNeighbours = new ArrayList<Integer>();
		
		for (int i = 0; i < adjMatrix[vertex].length; i++) {
			if (adjMatrix[vertex][i] != 0) {
				outdegreeNeighbours.add(i);
			}
		}
		
		return outdegreeNeighbours;
	}
	
	protected int totalSpace() {
		return adjMatrix[0].length;
	}
}
