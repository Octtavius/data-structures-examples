package ie.home.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAdjList extends Graph{

	private Map<Integer, ArrayList<Integer>> adjList;
	
	public GraphAdjList() {
		this.adjList = new HashMap<Integer, ArrayList<Integer>>();
	}
	
	@Override
	protected void implementAddVertex() {
		int v = getNumVertices();
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		adjList.put(v, neighbors);
	}

	@Override
	protected void implementAddEdge(int from, int to) {
		(adjList.get(from)).add(to);
	}
	
	@Override
	public List<Integer> getNeighbors(int vertex) {
		//return a copy of list, not THE list
		return new ArrayList<Integer>(adjList.get(vertex));
	}

	@Override
	protected List<Integer> getNeighboursIndegree(int vertex) {
		List<Integer> neighbors = new ArrayList<Integer>();
		
		adjList.keySet().stream()
			.forEach(key -> {
				if (adjList.get(key).contains(vertex)) {
					neighbors.add(key);
				}
			});
		
		return neighbors;
	}

	// this is outdegree
	@Override
	protected List<Integer> getTwoHopesNeighbors(int vertex) {
		List<Integer> twoHopesNeighbors = new ArrayList<Integer>();
		List<Integer> oneHopesNeighbors = adjList.get(vertex);
		
		oneHopesNeighbors
			.stream()
			.forEach(oneHope -> {
				twoHopesNeighbors.addAll(getNeighbors(oneHope));
			});
		
		return twoHopesNeighbors;
	}
}
