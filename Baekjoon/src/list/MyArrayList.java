package list;

import java.util.Arrays;

public class MyArrayList<T> implements IList<T> {
	private static final int DEFAULT_SIZE = 50; // designate the fixed size of array for easing maintenance 
	
	private int size;	// input data count
	private T[] elements;
	
	public MyArrayList() {
		this.size = 0;
		this.elements = (T[]) new Object[DEFAULT_SIZE]; // not using ArrayList class cuz we're making it.
	}
	
	@Override
	public void add(T t) {
		if (this.size == this.elements.length) { // in case list is full
			this.elements = Arrays.copyOf(this.elements, this.size * 2); 
		}
		this.elements[this.size++] = t;
		// above line implies
		// (1) this.elements[this.size] = t;
		// (2) this.size += 1;
		// Q. in line 21, why does the size start with 0 not 1?
		
	}

	@Override
	public void insert(int index, T t) {
		if (this.size == this.elements.length) { // in case list is full
			this.elements = Arrays.copyOf(this.elements, this.size * 2); 
		}
		for (int i = index; i < this.size; i++) {	// i < this.size means i <= last index (cuz index starts with 0)
			this.elements[i+1] = this.elements[i];
		}
		this.elements[index] = t;
		this.size++; // data++	->	size++
		
	}

	@Override
	public void clear() { // just like the constructor (initialization)
		this.size = 0;
		this.elements = (T[]) new Object[DEFAULT_SIZE];
	}

	@Override
	public boolean delete(T t) {
		for (int i= 0; i<this.size; i++) {	// process of checking if (target data = parameter data)   
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
		if (index < 0 || index > this.size - 1) {	// this.size - 1 means last index
			return false;
		}
		for ( int i = index; i < this.size-1; i++) { // check (i < this.size"-1"), cuz the element moves to index i+1.
			this.elements[i] = this.elements[i+1];	
		}
		this.size--; // for문에 대한 이해가 부족한데 만약 last index 뽑히면 위에거 건너뛰고 바로여기로 오는건지? if문처럼 조건 안맞아서?
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
		return -1;	// index starts with 0, so return negative integer which isn't included in index.
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;	//outcome: t(size=0)/f(size=not 0)
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
		return this.size;
	}

}
