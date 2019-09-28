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

	protected abstract List<Integer> getNeighbors(int vertex);
	
	public int getNumVertices() {
		return numVertices;
	}
	
	public int getNumEdges() {
		return numEdges;
	}
}
