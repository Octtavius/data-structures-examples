package ie.home.tree.tries.enhancement;

public class TrieNode {

	private static final int ALPHABET_SIZE = 26;

	private TrieNode[] children;
	
	private boolean isLeaf;
	
	public TrieNode() {
		children = new TrieNode[ALPHABET_SIZE];
		isLeaf = false;
		
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			children[i] = null;
		}
	}

	public TrieNode[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}
