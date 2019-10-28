package ie.home.graphs_own;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphMapList extends Graph{

	Map<Integer, List<Integer>> graphMap;
	
	public GraphMapList() {
		graphMap = new HashMap<Integer, List<Integer>>();
	}
	
	@Override
	protected void implementAddVertex() {
		int numV = getNumVertices();
		
		if (graphMap.get(numV) == null) {
			graphMap.put(numV, new ArrayList<Integer>());
		}
	}

	@Override
	protected void implementAddEdge(int from, int to) {
		List<Integer> nodes = graphMap.get(from);
		
		if (!nodes.contains(to)) {
			nodes.add(to);
		}
	}

	@Override
	protected List<Integer> getNeighbours(int vertex) {
		List<Integer> allNeighbours = getIndegreeNeighbours(vertex);
		for (Integer integer : getOutNeighbours(vertex)) {
			if (allNeighbours.contains(integer)) {
				continue;
			}
		}
		return allNeighbours;
	}

	@Override
	protected List<Integer> getIndegreeNeighbours(int vertex) {
		List<Integer> indegreeNeighbours = new ArrayList<Integer>();
		
		for (Integer node: graphMap.keySet()) {
			if (node == vertex) {
				continue;
			}
			
			if (graphMap.get(node).contains(vertex)) {
				indegreeNeighbours.add(node);
			}
		}
		
		return indegreeNeighbours;
	}

	@Override
	protected List<Integer> getOutNeighbours(int vertex) {
		return graphMap.get(vertex);
	}
}
