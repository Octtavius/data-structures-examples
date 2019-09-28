package ie.home.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphAdjList extends Graph{

	private Map<Integer, ArrayList<Integer>> adjList;

	@Override
	public List<Integer> getNeighbors(int vertex) {
		//return a copy of list, not THE list
		return new ArrayList<Integer>(adjList.get(vertex));
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
	
}
