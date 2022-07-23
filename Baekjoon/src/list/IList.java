package list;

public interface IList<T> {	// <T> is for all Type
	
	void add(T t); // t´Â data
	
	void insert(int index, T t);
	
	void clear();
	
	boolean delete(T t);
	
	boolean deleteByIndex(int index);
	
	T get(int index);
	
	int indexOf(T t);
	
	boolean isEmpty();
	
	boolean contains(T t);
	
	int size();

}
