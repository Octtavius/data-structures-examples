package ie.home.tree.heap;

public class HeapMin {

	private static final int FRONT = 1;
	private int[] heap;
	private int maxSize;
	private int size;
	
	public HeapMin(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		
		//initialize the heap array
		heap = new int[this.maxSize + 1];
		heap[0] = Integer.MIN_VALUE;
	}
	
	/*
	 * get position of parent by element's id
	 * formula of getting the parrent is i/2 where i is current position of element
	 */
	private int positionOfParent(int childIndex) {
		return childIndex / 2;
	}
	
	/*
	 * get left child of current element
	 * formula is (elementIndex * 2)
	 */
	private int getLeftChild(int currentElementIndex) {
		return (currentElementIndex * 2);
	}
	
	/*
	 * get right child of current element
	 * formula is (elementIndex * 2) + 1
	 */
	private int getRightChild(int currentElementIndex) {
		return (currentElementIndex * 2);
	}
	
	/*
	 * check if a node is a leaf.
	 * if current index is greater the totalSize/2 and index is not out ouf bound
	 */
	private boolean isLeaf(int currentPosition) {
		if (currentPosition >= (size / 2) && currentPosition <= size) {
			return true;
		}
		
		return false;
	}
	
	// Function to swap two nodes of the heap 
    private void swap(int firstPosition, int secondPosition) 
    { 
        int tmp; 
        tmp = heap[firstPosition]; 
        heap[firstPosition] = heap[secondPosition]; 
        heap[secondPosition] = tmp; 
    }
    
    /*
     * heapify the tree in MIN form
     */
    private void minHeapify(int position) {
    	if (!isLeaf(position)) {
    		// in Min Heap, if parent is greater than children then heap needs to be fixed
    		if (nodeGreaterThanChildren(position)) {
    			if (heap[getLeftChild(position)] < heap[getRightChild(position)]) {
    				swap(heap[position], getLeftChild(position));
    				minHeapify(getLeftChild(position));
    			}
    			else {
    				swap(heap[position], getRightChild(position));
    				minHeapify(getRightChild(position));
    			}
    		}
    	}
    }
    
    // Function to build the min heap using 
    // the minHeapify
    public void minHeap() {
    	for (int position = (size / 2); position >= 1; position--) {
    		minHeapify(position);
    	}
    }
    
 // Function to remove and return the minimum 
    // element from the heap 
    public int remove() 
    { 
        int popped = heap[FRONT]; 
        heap[FRONT] = heap[size--]; 
        minHeapify(FRONT); 
        return popped; 
    } 
    
    private boolean nodeGreaterThanChildren(int nodeIndex) {
    	return heap[nodeIndex] > heap[getLeftChild(nodeIndex)] 
    			|| heap[nodeIndex] > heap[getRightChild(nodeIndex)];
    }
    
 // Function to insert a node into the heap 
    public void insert(int element) 
    { 
        if (size >= maxSize) { 
            return; 
        } 
        heap[++size] = element; 
        int current = size; 
  
        while (heap[current] < heap[positionOfParent(current)]) { 
            swap(current, positionOfParent(current)); 
            current = positionOfParent(current); 
        } 
    } 
    
    
 // Driver code 
    public static void main(String[] arg) 
    { 
        System.out.println("The Min Heap is "); 
        HeapMin minHeap = new HeapMin(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
        minHeap.minHeap(); 
  
        minHeap.print(); 
        System.out.println("The Min val is " + minHeap.remove()); 
    } 
    
    // Function to print the contents of the heap 
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + heap[i] 
                             + " LEFT CHILD : " + heap[2 * i] 
                             + " RIGHT CHILD :" + heap[2 * i + 1]); 
            System.out.println(); 
        } 
    }
}
