package ie.home.graphs;

import java.util.List;

public abstract class GraphMatrix extends Graph {

	protected abstract List<Integer> getTwoHopesNeighborsByMultiplying(int vertex);
}
