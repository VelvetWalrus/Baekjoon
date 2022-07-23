package list;

import java.util.Arrays;

public class MyArrayList<T> implements IList<T> {
	private static final int DEFAULT_SIZE = 50; // 유지보수를 위해 여기서 size를 정의한다.
	
	private int size;
	private T[] elements;
	
	public MyArrayList() {
		this.size = 0;
		this.elements = (T[]) new Object[DEFAULT_SIZE];
	}
	
	@Override
	public void add(T t) {
		if (this.size == this.elements.length) { // in case list is full
			this.elements = Arrays.copyOf(this.elements, this.size * 2); 
		}
		this.elements[this.size++] = t;
	}

	@Override
	public void insert(int index, T t) {
		if (this.size == this.elements.length) { // in case list is full
			this.elements = Arrays.copyOf(this.elements, this.size * 2); 
		}
		for (int i = index; i < this.size; i++) {
			this.elements[i+1] = this.elements[i];
		}
		this.elements[index] = t;
		this.size++;
		
	}

	@Override
	public void clear() { // just like the constructor (initialization)
		this.size = 0;
		this.elements = (T[]) new Object[DEFAULT_SIZE];
	}

	@Override
	public boolean delete(T t) {
		for (int i= 0; i<this.size; i++) {
			if(this.elements[i].equals(t)) {
				for (int j = i; j < this.size - 1; j++) {
					this.elements[j] = this.elements[j+1];
				}
				this.size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteByIndex(int index) {
		if (index < 0 || index > this.size - 1) {
			return false;
		}
		for ( int i = index; i < this.size-1; i++) { // check (i < this.size"-1")
			this.elements[i] = this.elements[i+1];
		}
		this.size--;
		return true;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException(); // method's type : T (not boolean), so use "throw exception" instead of "return false"  
		}
		return this.elements[index];
	}

	@Override
	public int indexOf(T t) { // showing (1) the existence of t (in this arrayList) or not, and (2) which index(int)
		for (int i=0; i<this.size; i++) {
			if(this.elements[i].equals(t)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean contains(T t) { //if data t exists in this arrayList : True, vice versa : False
		for (int i=0; i<this.size; i++) {
			if(this.elements[i].equals(t)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
