package ie.home.graphs;

import java.util.Comparator;

public class Vertex implements Comparator<Vertex>{

	private int id;
	
	public Vertex (int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public int compare(Vertex o1, Vertex o2) {
		return o1.getId() == o2.getId() ? 1 : 0;
	}

}
