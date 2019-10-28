package ie.home.graphs_own;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public abstract class Graph {
	
	private int numVertices;
	private int numEdges;
	
	public Graph() {
		this.numEdges = 0;
		this.numVertices = 0;
	}
	
	public void addVertext() {
		implementAddVertex();
		numVertices++;
	}

	protected abstract void implementAddVertex();
	
	protected void addEdge(int from, int to) {
		implementAddEdge(from, to);
		numEdges++;
	}

	protected abstract void implementAddEdge(int from, int to);
	
	protected abstract List<Integer> getNeighbours(int vertex);
	protected abstract List<Integer> getIndegreeNeighbours(int vertex);
	protected abstract List<Integer> getOutNeighbours(int vertex);
	
	/**
	 * the degree of a vertex is the sum of its in-degree and its out-degree
	 */
	protected int degree(int vertex) {
		return getNeighbours(vertex).size();
	}

	public int getNumVertices() {
		return numVertices;
	}

	public int getNumEdges() {
		return numEdges;
	}
	
	public void BFS(int start, int target, Set<Integer> visited) {
		Queue<Integer> queueWithChildren = new LinkedList<Integer>();
		
		visited.add(start);
		
		if (start == target) {
			System.out.println("Target found");
			return;
		}
		
		queueWithChildren.addAll(getOutNeighbours(start));
		
		while (!queueWithChildren.isEmpty()) {
			Integer nextChild = queueWithChildren.poll();
			visited.add(nextChild);
			
			if (nextChild == target) {
				System.out.println("Target found");
				break;
			}
			
			for (Integer children : getOutNeighbours(nextChild)) {
				if (!visited.contains(children)) {
					queueWithChildren.add(children);
				}
			}
		}
	}
	
	public void DFS(int start, int target, Set<Integer> visited) {
		List<Integer> childNodes = getOutNeighbours(start);
		
		visited.add(start);
		
		if (start == target) {
			System.out.println("Target found");
		}
		
		if (childNodes.isEmpty()) {
			return;
		}
		
		for (Integer child : childNodes) {
			if (!visited.contains(child)) {
				DFS(child, target, visited);
			}
		}
	}
}
