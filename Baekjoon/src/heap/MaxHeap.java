package heap;

public class MaxHeap<T extends Comparable<T>> implements IHeap<T>{

	T[] data;
	int size;
	int maxSize;
	
	public MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.data = (T[]) new Comparable[maxSize+1];
		this.size = 0;
	}
	
	private int parent(int pos) {
		return pos / 2;
	}
	
	private int leftChild(int pos) {
		return pos * 2;
		
	}
	
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}
	
	private boolean isLeaf(int pos) {
		return (pos > (size / 2) && pos <= size);
	}
	
	@Override
	public void insert(T val) {
		
	}

	@Override
	public boolean contains(T val) {
		return false;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
