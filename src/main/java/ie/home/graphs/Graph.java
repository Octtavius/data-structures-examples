package ie.home.graphs;

import java.util.List;

public abstract class Graph {

	private int numVertices;
	private int numEdges;
	
	public Graph() {
		this.numEdges = 0;
		this.numVertices = 0;
	}
	
	public void addVertex() {
		implementAddVertex();
		numVertices++;
	}
	
	protected abstract void implementAddVertex();
	
	public void addEdge(int from, int to) {
		implementAddEdge(from, to);
		numEdges++;
	}

	protected abstract void implementAddEdge(int from, int to);
	
	/**
	 * only the outgoing edges.
	 */
	protected abstract List<Integer> getNeighbors(int vertex);
	
	protected abstract List<Integer> getNeighboursIndegree(int vertex);
	
	protected abstract List<Integer> getTwoHopesNeighbors(int vertex);
	
	/**
	 * the degree of a vertex is the sum of its in-degree and its out-degree
	 */
	protected int degree(int vertex) {
		return getNeighbors(vertex).size()
				+ getNeighboursIndegree(vertex).size();
	};
	
	public int getNumVertices() {
		return numVertices;
	}
	
	public int getNumEdges() {
		return numEdges;
	}
}
